package it.ctinnovation.tdcKc.controller;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreResult;
import it.ctinnovation.tdcKc.model.placemark.PlacemarkAttributeSearch;
import it.ctinnovation.tdcKc.service.PlacemarkAttributeSearchService;
import it.ctinnovation.tdcKc.service.PlacemarkService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import static ch.ralscha.extdirectspring.annotation.ExtDirectMethodType.STORE_READ;

@Service
public class PlacemarkController {

    PlacemarkService placemarkService;
    PlacemarkAttributeSearchService placemarkAttributeSearchService;

    public PlacemarkController(PlacemarkService placemarkService) {
        this.placemarkService = placemarkService;
    }

    @ExtDirectMethod(STORE_READ)
    public ExtDirectStoreResult<PlacemarkAttributeSearch> read(ExtDirectStoreReadRequest storeRequest) {
        Page<PlacemarkAttributeSearch> data = placemarkService.getPlacemarks(storeRequest);
        return new ExtDirectStoreResult<>(data.getTotalElements(), data.getContent());
    }

}
