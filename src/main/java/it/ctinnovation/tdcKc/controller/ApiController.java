package it.ctinnovation.tdcKc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.ctinnovation.tdcKc.model.KeyCloakResponse;
import it.ctinnovation.tdcKc.model.attribute.Attribute;
import it.ctinnovation.tdcKc.model.placemark.PlacemarkAttributeSearch;
import it.ctinnovation.tdcKc.service.AuthorizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {

    @Autowired
    AuthorizationService authorizationService;

    @PostMapping(value = "/login")
    public KeyCloakResponse login(@RequestParam String username, @RequestParam String password) throws JsonProcessingException {
        return authorizationService.login(username, password);
    }

    @PostMapping(value = "/renewToken")
    public KeyCloakResponse renewToken(@RequestParam String renewToken) throws JsonProcessingException {
        return authorizationService.renewJwt(renewToken);
    }

    public static class LoginRequest {
        private String username;
        private String password;

        public String getUsername() {
            return username;
        }

        public String getPassword() {
            return password;
        }
    }
}

