package it.ctinnovation.tdcKc.model;

public record KeyCloakResponse(String access_token, Integer expires_in, Integer refresh_expires_in, String refresh_token) {

}
