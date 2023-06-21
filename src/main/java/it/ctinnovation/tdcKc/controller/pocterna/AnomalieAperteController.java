package it.ctinnovation.tdcKc.controller.pocterna;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreResult;
import it.ctinnovation.tdcKc.model.attribute.Attribute;
import it.ctinnovation.tdcKc.model.pocterna.AnomaliaAperta;
import it.ctinnovation.tdcKc.service.pocterna.PocTernaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

import static ch.ralscha.extdirectspring.annotation.ExtDirectMethodType.STORE_READ;

@Service
public class AnomalieAperteController {

    PocTernaService pocTernaService;

    public AnomalieAperteController(PocTernaService pocTernaService) {
        this.pocTernaService = pocTernaService;
    }

    @ExtDirectMethod(STORE_READ)
    public ExtDirectStoreResult<AnomaliaAperta> read(ExtDirectStoreReadRequest storeRequest) {

        Page<AnomaliaAperta> data = pocTernaService.getAnomalie(storeRequest);
        return new ExtDirectStoreResult<>(data.getTotalElements(), data.getContent());
    }
}
