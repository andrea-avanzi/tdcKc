package it.ctinnovation.tdcKc.controller;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreResult;
import it.ctinnovation.tdcKc.model.scenario.entitiy.ScenarioEntity;
import it.ctinnovation.tdcKc.model.scenario.entitiy.ScenarioFlowEntity;
import it.ctinnovation.tdcKc.service.ScenarioFlowService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

import java.util.List;

import static ch.ralscha.extdirectspring.annotation.ExtDirectMethodType.STORE_MODIFY;
import static ch.ralscha.extdirectspring.annotation.ExtDirectMethodType.STORE_READ;

@Controller
@RequiredArgsConstructor
public class ScenarioFlowDirectController {

   final ScenarioFlowService scenarioFlowService;

    @ExtDirectMethod(STORE_READ)
    public ExtDirectStoreResult<ScenarioFlowEntity> read(ExtDirectStoreReadRequest storeRequest) {
        Long scenarioEntityId = (Long) storeRequest.getParams().get("scenarioEntityId");
        List<ScenarioFlowEntity> data = scenarioFlowService.read(scenarioEntityId);
        return new ExtDirectStoreResult<>(data.size(), data);
    }

    @ExtDirectMethod(ExtDirectMethodType.STORE_MODIFY)
    public ScenarioFlowEntity create(Long scenarioEntityId, ScenarioFlowEntity companyRole) {
        return scenarioFlowService.create(companyRole);
    }

    @ExtDirectMethod(ExtDirectMethodType.STORE_MODIFY)
    public ScenarioFlowEntity update(Long scenarioEntityId, ScenarioFlowEntity companyRole) {
        return scenarioFlowService.update(companyRole);
    }

    @ExtDirectMethod(STORE_MODIFY)
    public void destroy(Long scenarioEntityId, List<ScenarioFlowEntity> companyRoleList) {
        scenarioFlowService.destroy(companyRoleList);
    }
}
