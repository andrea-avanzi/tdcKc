package it.ctinnovation.tdcKc.service.implementation;

import it.ctinnovation.tdcKc.model.attribute.Attribute;
import it.ctinnovation.tdcKc.model.placemark.PlacemarkAttributeSearch;
import it.ctinnovation.tdcKc.repository.AttributeRepository;
import it.ctinnovation.tdcKc.repository.PlacemarkRepository;
import it.ctinnovation.tdcKc.service.AttributeService;
import it.ctinnovation.tdcKc.service.PlacemarkService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlacemarkServiceImpl implements PlacemarkService {

    PlacemarkRepository repository;

    public PlacemarkServiceImpl(PlacemarkRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<PlacemarkAttributeSearch> findAll() {
        return repository.findAll();
    }


}
