package it.ctinnovation.tdcKc.service;


import it.ctinnovation.tdcKc.model.placemark.PlacemarkAttributeSearch;

import java.util.List;

public interface PlacemarkService {
    List<PlacemarkAttributeSearch>  findAll();
}
