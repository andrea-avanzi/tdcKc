package it.ctinnovation.tdcKc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.ctinnovation.tdcKc.model.TheaterJwtResponse;
import it.ctinnovation.tdcKc.model.attribute.Attribute;
import it.ctinnovation.tdcKc.model.placemark.PlacemarkAttributeSearch;
import org.springframework.http.ResponseEntity;

import java.time.Instant;
import java.util.List;

public interface TheaterService {


    TheaterJwtResponse getConnectionToken() throws JsonProcessingException;

    void connect() throws JsonProcessingException;

    void setConnectionToken(TheaterJwtResponse connectionToken);

    boolean getServerRunning();

    void setServerRunning(boolean status);

    void setLastConnection(Instant connetionTime);

    ResponseEntity<String> getChannels() throws JsonProcessingException;

    List<Attribute> getAttributes() throws JsonProcessingException;

    List<PlacemarkAttributeSearch> getPlacemarks() throws JsonProcessingException;

    ResponseEntity<String> getAttributesKeyFeatures() throws JsonProcessingException;
}
