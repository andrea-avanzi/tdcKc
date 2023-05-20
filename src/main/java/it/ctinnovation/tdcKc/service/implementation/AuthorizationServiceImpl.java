package it.ctinnovation.tdcKc.service.implementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.ctinnovation.tdcKc.model.KeyCloakResponse;
import it.ctinnovation.tdcKc.service.AuthorizationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
@Transactional
public class AuthorizationServiceImpl implements AuthorizationService {
    private final Logger log = LoggerFactory.getLogger(AuthorizationServiceImpl.class);

    private static final String JWTSERVER = "http://localhost:8090/realms/SpringBootKeycloak/protocol/openid-connect/token";
    private static final String CLIENT_ID = "springboot-keycloak-client";
    private static final String PASSWORD_GRANTTYPE = "password";
    private static final String REFRESH_TOKEN = "refresh_token";

    RestTemplate restTemplate;
    ObjectMapper objectMapper;

    AuthorizationServiceImpl(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @Override
    public KeyCloakResponse login(String username, String password) throws JsonProcessingException {
        return loginConnect(username, password);
    }

    @Override
    public KeyCloakResponse renewJwt(String refreshToken) throws JsonProcessingException {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
        map.add("grant_type", REFRESH_TOKEN);
        map.add("refresh_token",refreshToken);
        return getKeyCloakResponse(map);
    }

    private KeyCloakResponse loginConnect(String username, String password) throws JsonProcessingException {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        map.add("grant_type", PASSWORD_GRANTTYPE);
        map.add("username", username);
        map.add("password", password);
        return getKeyCloakResponse(map);
    }

    private KeyCloakResponse getKeyCloakResponse(MultiValueMap<String, String> map) throws JsonProcessingException {
        map.add("client_id", CLIENT_ID);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);
        ResponseEntity<String> re = restTemplate.postForEntity(JWTSERVER, request, String.class);
        String jwtResponse = re.getBody();
        return objectMapper.readValue(jwtResponse, KeyCloakResponse.class);
    }
}
