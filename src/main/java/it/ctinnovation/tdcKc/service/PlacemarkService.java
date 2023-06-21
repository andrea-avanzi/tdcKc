package it.ctinnovation.tdcKc.service;


import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import it.ctinnovation.tdcKc.model.placemark.PlacemarkAttributeSearch;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PlacemarkService {
    List<PlacemarkAttributeSearch>  findAll();
    Page<PlacemarkAttributeSearch> getPlacemarks(ExtDirectStoreReadRequest storeRequest);
}
