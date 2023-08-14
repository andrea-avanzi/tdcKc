package it.ctinnovation.tdcKc.controller;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreResult;
import it.ctinnovation.tdcKc.model.scenario.entitiy.ScenarioMessageEntity;
import it.ctinnovation.tdcKc.service.ScenarioMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

import static ch.ralscha.extdirectspring.annotation.ExtDirectMethodType.STORE_MODIFY;
import static ch.ralscha.extdirectspring.annotation.ExtDirectMethodType.STORE_READ;

@Controller
@RequiredArgsConstructor
public class ScenarioDataItemDirectController {

   final ScenarioMessageService scenarioMessageService;

    @ExtDirectMethod(STORE_READ)
    public ExtDirectStoreResult<ScenarioMessageEntity> read(ExtDirectStoreReadRequest storeRequest) {
        Long scenarioEntityFlowId = (Long) storeRequest.getParams().get("scenarioEntityFlowId");
        List<ScenarioMessageEntity> data = scenarioMessageService.read(scenarioEntityFlowId);
        return new ExtDirectStoreResult<>(data.size(), data);
    }

    @ExtDirectMethod(ExtDirectMethodType.STORE_MODIFY)
    public void create(Long scenarioEntityId, ScenarioMessageEntity scenarioMessageEntity) {
        scenarioMessageService.create(scenarioEntityId, scenarioMessageEntity);
    }

    @ExtDirectMethod(ExtDirectMethodType.STORE_MODIFY)
    public ScenarioMessageEntity update(ScenarioMessageEntity scenarioMessageEntity) {
        return scenarioMessageService.update(scenarioMessageEntity);
    }

    @ExtDirectMethod(STORE_MODIFY)
    public void destroy(List<ScenarioMessageEntity> scenarioMessageEntityList) {
        scenarioMessageService.destroy(scenarioMessageEntityList);
    }
}
