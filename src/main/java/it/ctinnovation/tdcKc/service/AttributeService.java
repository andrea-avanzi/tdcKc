package it.ctinnovation.tdcKc.service;

import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import it.ctinnovation.tdcKc.model.attribute.Attribute;

import java.util.List;

public interface AttributeService {
    List<Attribute>  findAll();
}
