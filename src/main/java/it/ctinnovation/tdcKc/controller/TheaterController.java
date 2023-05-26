package it.ctinnovation.tdcKc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.ctinnovation.tdcKc.model.attribute.Attribute;
import it.ctinnovation.tdcKc.model.placemark.PlacemarkAttributeSearch;
import it.ctinnovation.tdcKc.service.TheaterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TheaterController {

    TheaterService theaterService;

    public TheaterController(TheaterService theaterService) {
        this.theaterService = theaterService;
    }

    @RequestMapping(value = "/api/getJWT", method = RequestMethod.GET)
    public String getToken() throws JsonProcessingException {
        //Intercettareerrori HTTP e maxRetry
        return theaterService.getConnectionToken() == null? "Gateway not responding" : theaterService.getConnectionToken().access_token()+"\n";
    }

    @GetMapping(value="/api/getChannels")
    public String getChannels() throws JsonProcessingException {
        return theaterService.getChannels().getBody();
    }

    @GetMapping(value="/api/getAttributes")
    public List<Attribute> getAttributes() throws JsonProcessingException {
        return theaterService.getAttributes();
    }

    @GetMapping(value="/api/getPlacemarks")
    public List<PlacemarkAttributeSearch> getPlacemarks() throws JsonProcessingException {
        return theaterService.getPlacemarks();
    }

    @GetMapping(value="/api/getAttributesKeyFeatures")
    public String getAttributesKeyFeatures() throws JsonProcessingException {
        return theaterService.getAttributesKeyFeatures().getBody();
    }
}
