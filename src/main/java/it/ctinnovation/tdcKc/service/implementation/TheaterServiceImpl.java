package it.ctinnovation.tdcKc.service.implementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.ctinnovation.tdcKc.model.TheaterJwtResponse;
import it.ctinnovation.tdcKc.model.attribute.Attribute;
import it.ctinnovation.tdcKc.model.placemark.PlacemarkAttributeSearch;
import it.ctinnovation.tdcKc.model.placemark.PlacemarkAttributeSearchReduced;
import it.ctinnovation.tdcKc.repository.AttributeRepository;
import it.ctinnovation.tdcKc.repository.PlacemarkAttributeSearchRepository;
import it.ctinnovation.tdcKc.service.RenewExternalJwtTask;
import it.ctinnovation.tdcKc.service.TheaterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class TheaterServiceImpl implements TheaterService {
    private final Logger log = LoggerFactory.getLogger(TheaterServiceImpl.class);

    private static final String JWTSERVER = "https://geo-demo.dev.ctinnovation.it/api/oauth/token";
    private static final String GRANTTYPE = "client_credentials";
    private static final String CLIENTID = "8a9939805f12eb25";
    private static final String SECRET = "035f61b2bc83043e78d5c3df261e6661f5cf1d69f5c1f37f";

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    ThreadPoolTaskScheduler scheduler;

    @Autowired
    AttributeRepository attributeRepository;

    @Autowired
    PlacemarkAttributeSearchRepository placemarkAttributeSearchRepository;

    TheaterJwtResponse connectionToken;
    boolean serverRunning = false;
    Instant lastConnection;

    @Override
    @Retryable(retryFor = {HttpClientErrorException.class, HttpServerErrorException.class}, maxAttemptsExpression = "5", backoff = @Backoff(delayExpression = "500"))
    public TheaterJwtResponse getConnectionToken() throws JsonProcessingException, HttpClientErrorException {
        if (connectionToken == null || jwtTokenIsExpired()) {
            connect();
        }
        return connectionToken;
    }

    private boolean jwtTokenIsExpired() {
        return Instant.now().isAfter(lastConnection.plusSeconds(connectionToken.expires_in()));
    }

    @Override
    public void connect() throws JsonProcessingException {
        log.info("Try to connect to Theater Server");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("grant_type", GRANTTYPE);
        map.add("client_id", CLIENTID);
        map.add("client_secret", SECRET);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        connectionToken = objectMapper.readValue(restTemplate.postForEntity(JWTSERVER, request, String.class).getBody(), TheaterJwtResponse.class);
        lastConnection = Instant.now();
        setServerRunning(true);
        long expirationTime = connectionToken == null ? 290 : connectionToken.expires_in() - 10;
        scheduler.scheduleWithFixedDelay(
            new RenewExternalJwtTask(this, objectMapper, restTemplate, JWTSERVER, GRANTTYPE, CLIENTID, SECRET),
            new Date(System.currentTimeMillis() + 290000).toInstant(), Duration.of(expirationTime, ChronoUnit.SECONDS));
        log.info("Theater Server successfully connected: JWT received and renew scheduled");
    }

    public void setConnectionToken(TheaterJwtResponse connectionToken) {
        this.connectionToken = connectionToken;
    }

    @Override
    public boolean getServerRunning() {
        return serverRunning;
    }

    @Override
    public void setServerRunning(boolean status) {
        serverRunning = status;
    }

    @Override
    public void setLastConnection(Instant connetionTime) {
        this.lastConnection = connetionTime;
    }

    @Override
    public ResponseEntity<String> getChannels() throws JsonProcessingException {
        RequestEntity<Void> request = createRequest("https://geo-demo.dev.ctinnovation.it/api/channels");
        return restTemplate.exchange(request, String.class);
    }

    @Override
    public List<Attribute> getAttributes() throws JsonProcessingException {
        RequestEntity<Void> request = createRequest("https://geo-demo.dev.ctinnovation.it/api/attributes");
        ResponseEntity<String> response = restTemplate.exchange(request, String.class);
        TypeReference<List<Attribute>> attributeTypeReference = new TypeReference<List<Attribute>>() {};
        List<Attribute> attributeList=  objectMapper.readValue(response.getBody(), attributeTypeReference);
        attributeRepository.deleteAll();
        attributeRepository.saveAll(attributeList);
        return attributeList;
    }

    @Override
    public List<PlacemarkAttributeSearch> getPlacemarks() throws JsonProcessingException {
        List<PlacemarkAttributeSearch> placemarkAttributeSearchList= new ArrayList<>();
        RequestEntity<Void> reduced = createRequest("https://geo-demo.dev.ctinnovation.it/api/search/stream?bbox=-174.541254&bbox=-62.866286&bbox=61.366711&bbox=71.2788");
        ResponseEntity<String> response = restTemplate.exchange(reduced, String.class);
        TypeReference<List<PlacemarkAttributeSearchReduced>> attributeTypeReference = new TypeReference<>() {};
        List<PlacemarkAttributeSearchReduced> placemarkAttributeSearchReducedList=  objectMapper.readValue(response.getBody(), attributeTypeReference);

        for(PlacemarkAttributeSearchReduced pr:placemarkAttributeSearchReducedList){
            RequestEntity<Void>  request = createRequest("https://geo-demo.dev.ctinnovation.it/api/search/placemarks/"+pr.getId());
            ResponseEntity<String> resp = restTemplate.exchange(request, String.class);
            placemarkAttributeSearchList.add(objectMapper.readValue(resp.getBody(), PlacemarkAttributeSearch.class));
        }
        placemarkAttributeSearchRepository.deleteAll();
        placemarkAttributeSearchRepository.saveAll(placemarkAttributeSearchList);
        return placemarkAttributeSearchList;
    }

    @Override
    public ResponseEntity<String> getAttributesKeyFeatures() throws JsonProcessingException {
        RequestEntity<Void> request = createRequest("https://geo-demo.dev.ctinnovation.it/api/attributesKeysFeatures");
        return restTemplate.exchange(request, String.class);
    }

    private RequestEntity<Void> createRequest(String url) throws JsonProcessingException {
        TheaterJwtResponse jwtResponse = getConnectionToken();
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(jwtResponse.access_token());
        URI uri = URI.create(url);
        return RequestEntity.get(uri).headers(headers).build();
    }
}
