package it.ctinnovation.tdcKc.controller;

import it.ctinnovation.tdcKc.model.placemark.PlacemarkAttributeSearch;
import it.ctinnovation.tdcKc.model.placemark.PlacemarkAttributeSearch_;
import it.ctinnovation.tdcKc.service.PlacemarkAttributeSearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping(value = "/placemarkSearchController")
@Slf4j
@RequiredArgsConstructor

public class PlacemarkSearchController {

    final PlacemarkAttributeSearchService placemarkAttributeSearchService;

    @GetMapping("/load")
    public PlacemarkAttributeSearch load(@RequestParam(value = "id") Long id){
        return placemarkAttributeSearchService.getById(id);
    }

}
