package it.ctinnovation.tdcKc.service.implementation;

import it.ctinnovation.tdcKc.model.placemark.PlacemarkAttributeSearch;
import it.ctinnovation.tdcKc.repository.PlacemarkAttributeSearchRepository;
import it.ctinnovation.tdcKc.service.PlacemarkAttributeSearchService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class PlacemarkAttributeSearchServiceImpl implements PlacemarkAttributeSearchService {
    PlacemarkAttributeSearchRepository placemarkAttributeSearchRepository;

    PlacemarkAttributeSearchServiceImpl(PlacemarkAttributeSearchRepository placemarkAttributeSearchRepository) {
        this.placemarkAttributeSearchRepository = placemarkAttributeSearchRepository;
    }

    @Override
    public Optional<PlacemarkAttributeSearch> findByPublicId(String publicId) {
        return placemarkAttributeSearchRepository.findByPublicId(publicId);
    }

    @Override
    public void save(PlacemarkAttributeSearch placemarkAttributeSearch) {
        placemarkAttributeSearchRepository.save(placemarkAttributeSearch);
    }

    @Override
    public PlacemarkAttributeSearch getById(Long id) {
        log.info("getById: " + id);
        return placemarkAttributeSearchRepository.getReferenceById(id);
    }
}
