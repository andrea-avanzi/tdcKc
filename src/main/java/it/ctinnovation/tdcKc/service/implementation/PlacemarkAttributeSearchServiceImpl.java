package it.ctinnovation.tdcKc.service.implementation;

import it.ctinnovation.tdcKc.model.placemark.PlacemarkAttributeSearch;
import it.ctinnovation.tdcKc.repository.PlacemarkAttributeSearchRepository;
import it.ctinnovation.tdcKc.service.PlacemarkAttributeSearchService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PlacemarkAttributeSearchServiceImpl implements PlacemarkAttributeSearchService {
    PlacemarkAttributeSearchRepository placemarkAttributeSearchRepository;

    PlacemarkAttributeSearchServiceImpl(PlacemarkAttributeSearchRepository placemarkAttributeSearchRepository) {
        this.placemarkAttributeSearchRepository = placemarkAttributeSearchRepository;
    }

    public Optional<PlacemarkAttributeSearch> findByPublicId(String publicId) {
        return placemarkAttributeSearchRepository.findByPublicId(publicId);
    }

    @Override
    public void save(PlacemarkAttributeSearch placemarkAttributeSearch) {
        placemarkAttributeSearchRepository.save(placemarkAttributeSearch);
    }
}
