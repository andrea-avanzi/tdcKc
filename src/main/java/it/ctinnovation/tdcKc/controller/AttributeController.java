package it.ctinnovation.tdcKc.controller;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreResult;
import it.ctinnovation.tdcKc.model.attribute.Attribute;
import it.ctinnovation.tdcKc.service.AttributeService;
import org.springframework.stereotype.Service;

import java.util.List;

import static ch.ralscha.extdirectspring.annotation.ExtDirectMethodType.STORE_READ;

@Service
public class AttributeController {

    AttributeService attributeService;

    public AttributeController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }

    @ExtDirectMethod(STORE_READ)
    public ExtDirectStoreResult<Attribute> read(ExtDirectStoreReadRequest storeRequest) {
        List<Attribute> data = attributeService.findAll();
        return new ExtDirectStoreResult<>(data.size(), data);
    }
}
