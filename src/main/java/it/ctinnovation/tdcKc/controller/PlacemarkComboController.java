package it.ctinnovation.tdcKc.controller;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreResult;
import it.ctinnovation.tdcKc.model.placemark.PlacemarkAttributeSearch;
import it.ctinnovation.tdcKc.service.PlacemarkAttributeSearchService;
import it.ctinnovation.tdcKc.service.PlacemarkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;

import static ch.ralscha.extdirectspring.annotation.ExtDirectMethodType.STORE_READ;

@Controller
@Slf4j
@RequiredArgsConstructor
public class PlacemarkComboController {

    final private PlacemarkService placemarkService;
    final private PlacemarkAttributeSearchService placemarkAttributeSearchService;

    @ExtDirectMethod(STORE_READ)
    public ExtDirectStoreResult<PlacemarkAttributeSearch> read(ExtDirectStoreReadRequest storeRequest) {
        Page<PlacemarkAttributeSearch> data = placemarkService.getPlacemarks(storeRequest);
        return new ExtDirectStoreResult<>(data.getTotalElements(), data.getContent());
    }
}
