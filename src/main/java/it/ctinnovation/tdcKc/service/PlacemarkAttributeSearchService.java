package it.ctinnovation.tdcKc.service;


import it.ctinnovation.tdcKc.model.placemark.PlacemarkAttributeSearch;

import java.util.List;
import java.util.Optional;

public interface PlacemarkAttributeSearchService {
    Optional<PlacemarkAttributeSearch> findByPublicId(String publicId);

    void save(PlacemarkAttributeSearch placemarkAttributeSearch);

    PlacemarkAttributeSearch getById(Long id);
}
