package it.ctinnovation.tdcKc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.ctinnovation.tdcKc.model.KeyCloakResponse;

public interface AuthorizationService {

    KeyCloakResponse login(String username, String password) throws JsonProcessingException;

    KeyCloakResponse renewJwt(String renewToken) throws JsonProcessingException;
}
