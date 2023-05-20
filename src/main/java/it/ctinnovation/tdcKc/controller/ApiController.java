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
    public KeyCloakResponse login() throws JsonProcessingException {
        return authorizationService.login("user1", "password");
    }

    @PostMapping(value = "/renewToken")
    public KeyCloakResponse renewToken(@RequestBody String renewToken) throws JsonProcessingException {
        return authorizationService.renewJwt(renewToken);
    }


}
