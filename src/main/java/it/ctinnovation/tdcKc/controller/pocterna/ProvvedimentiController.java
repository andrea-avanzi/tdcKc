package it.ctinnovation.tdcKc.controller.pocterna;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreResult;
import it.ctinnovation.tdcKc.model.pocterna.AnomaliaAperta;
import it.ctinnovation.tdcKc.model.pocterna.Provvedimento;
import it.ctinnovation.tdcKc.service.pocterna.PocTernaService;
import org.springframework.stereotype.Service;

import java.util.List;

import static ch.ralscha.extdirectspring.annotation.ExtDirectMethodType.STORE_READ;

@Service
public class ProvvedimentiController {

    PocTernaService pocTernaService;

    public ProvvedimentiController(PocTernaService pocTernaService) {
        this.pocTernaService = pocTernaService;
    }

    @ExtDirectMethod(STORE_READ)
    public ExtDirectStoreResult<Provvedimento> read(ExtDirectStoreReadRequest storeRequest) {
        List<Provvedimento> data = pocTernaService.getProvvedimenti();
        return new ExtDirectStoreResult<>(data.size(), data);
    }
}
