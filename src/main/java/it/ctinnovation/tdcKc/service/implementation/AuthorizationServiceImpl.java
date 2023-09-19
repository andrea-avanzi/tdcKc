package it.ctinnovation.tdcKc.service.implementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.ctinnovation.tdcKc.config.properties.AuthorizationServiceProperties;
import it.ctinnovation.tdcKc.config.properties.CorsConfigurationProperties;
import it.ctinnovation.tdcKc.model.KeyCloakResponse;
import it.ctinnovation.tdcKc.service.AuthorizationService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
@EnableConfigurationProperties({AuthorizationServiceProperties.class})
public class AuthorizationServiceImpl implements AuthorizationService {
    private final Logger log = LoggerFactory.getLogger(AuthorizationServiceImpl.class);

    RestTemplate restTemplate;
    ObjectMapper objectMapper;
    AuthorizationServiceProperties authorizationServiceProperties;

    AuthorizationServiceImpl(RestTemplate restTemplate, ObjectMapper objectMapper, AuthorizationServiceProperties authorizationServiceProperties) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
        this.authorizationServiceProperties = authorizationServiceProperties;
        log.info(authorizationServiceProperties.getClientId());
        log.info(authorizationServiceProperties.getJwtServer());
        log.info(authorizationServiceProperties.getPasswordGrantType());
        log.info(authorizationServiceProperties.getRefreshToken());
    }

    @Override
    public KeyCloakResponse login(String username, String password) throws JsonProcessingException {
        return loginConnect(username, password);
    }


    @Override
    public KeyCloakResponse renewJwt(String refreshToken) throws JsonProcessingException {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", authorizationServiceProperties.getRefreshToken());
        map.add("refresh_token",refreshToken);
        return getKeyCloakResponse(map);
    }

    private KeyCloakResponse loginConnect(String username, String password) throws JsonProcessingException {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("grant_type", authorizationServiceProperties.getPasswordGrantType());
        map.add("username", username);
        map.add("password", password);
        return getKeyCloakResponse(map);
    }

    private KeyCloakResponse getKeyCloakResponse(MultiValueMap<String, String> map) throws JsonProcessingException {
        map.add("client_id", authorizationServiceProperties.getClientId());
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> re = restTemplate.postForEntity(authorizationServiceProperties.getJwtServer(), request, String.class);
        String jwtResponse = re.getBody();
        return objectMapper.readValue(jwtResponse, KeyCloakResponse.class);
    }
}
