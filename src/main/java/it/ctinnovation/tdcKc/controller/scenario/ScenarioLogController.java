package it.ctinnovation.tdcKc.controller.scenario;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreResult;
import it.ctinnovation.tdcKc.model.scenario.entity.ScenarioEntity;
import it.ctinnovation.tdcKc.model.scenario.entity.ScenarioLogEntity;
import it.ctinnovation.tdcKc.service.ScenarioLogEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import java.util.List;

import static ch.ralscha.extdirectspring.annotation.ExtDirectMethodType.STORE_READ;

@Slf4j
@Controller
@RequiredArgsConstructor
public class ScenarioLogController {
    private final ScenarioLogEntityService scenarioLogEntityService;

    @ExtDirectMethod(STORE_READ)
    public ExtDirectStoreResult<ScenarioLogEntity> read(ExtDirectStoreReadRequest storeRequest) {
        List<ScenarioLogEntity> data = scenarioLogEntityService.readAll();
        return new ExtDirectStoreResult<>(data.size(), data);
    }
}
