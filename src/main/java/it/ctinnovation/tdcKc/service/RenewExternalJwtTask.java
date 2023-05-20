package it.ctinnovation.tdcKc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.ctinnovation.tdcKc.model.TheaterJwtResponse;
import it.ctinnovation.tdcKc.service.implementation.TheaterServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;

public class RenewExternalJwtTask implements Runnable {
    private final Logger log = LoggerFactory.getLogger(TheaterServiceImpl.class);

    private String jwtServer;
    private String grantType;
    private String clientId;
    private String secret;
    TheaterService service;
    TheaterJwtResponse connectionToken;
    ObjectMapper objectMapper;
    RestTemplate restTemplate;

    public RenewExternalJwtTask(TheaterService service, ObjectMapper objectMapper, RestTemplate restTemplate, String jwtServer, String grantType, String clientId, String secret) {
        super();
        this.jwtServer = jwtServer;
        this.grantType = grantType;
        this.clientId = clientId;
        this.secret = secret;
        this.service = service;
        this.objectMapper = objectMapper;
        this.restTemplate = restTemplate;
    }

    @Override
    public void run() {
        if (service.getServerRunning()) {
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
            map.add("grant_type", grantType);
            map.add("client_id", clientId);
            map.add("client_secret", secret);
            HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
            try {
                connectionToken = objectMapper.readValue(restTemplate.postForEntity(jwtServer, request, String.class).getBody(), TheaterJwtResponse.class);
                service.setConnectionToken(connectionToken);
                log.info("New JWT {}", connectionToken.access_token());
            } catch (JsonProcessingException e) {
                service.setConnectionToken(null);
                service.setServerRunning(false);
                log.error("Error in Json processing");
            } catch (HttpServerErrorException se) {
                service.setConnectionToken(null);
                service.setServerRunning(false);
                log.error("JWT renew request failed");
            } finally {
                service.setLastConnection(Instant.now());
            }
        } else
            log.info("Sheduled but not executed");
    }
}
