package it.ctinnovation.tdcKc.service.implementation;

import it.ctinnovation.tdcKc.model.attribute.Attribute;
import it.ctinnovation.tdcKc.repository.AttributeRepository;
import it.ctinnovation.tdcKc.service.AttributeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttributeServiceImpl implements AttributeService {

    AttributeRepository repository;

    public AttributeServiceImpl(AttributeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Attribute> findAll() {
        return repository.findAll();
    }
}
