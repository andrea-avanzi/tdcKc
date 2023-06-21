package it.ctinnovation.tdcKc.service.implementation;

import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.SortDirection;
import ch.ralscha.extdirectspring.bean.SortInfo;
import it.ctinnovation.tdcKc.model.attribute.Attribute;
import it.ctinnovation.tdcKc.model.placemark.PlacemarkAttributeSearch;
import it.ctinnovation.tdcKc.model.pocterna.Provvedimento;
import it.ctinnovation.tdcKc.repository.AttributeRepository;
import it.ctinnovation.tdcKc.repository.PlacemarkRepository;
import it.ctinnovation.tdcKc.service.AttributeService;
import it.ctinnovation.tdcKc.service.PlacemarkService;
import it.ctinnovation.tdcKc.util.PageableBuilder;
import it.ctinnovation.tdcKc.util.SpecificationFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
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

    public Page<PlacemarkAttributeSearch> getPlacemarks(ExtDirectStoreReadRequest storeRequest) {
        SortInfo defaultSort = new SortInfo("title", SortDirection.ASCENDING);
        Pageable pageable = PageableBuilder.of(storeRequest, defaultSort);
        Specification<PlacemarkAttributeSearch> sp = SpecificationFactory.buildSpecs(storeRequest, PlacemarkAttributeSearch.class);
        if (sp != null)
            return repository.findAll(sp, pageable);
        else
            return repository.findAll(pageable);
    }
}
