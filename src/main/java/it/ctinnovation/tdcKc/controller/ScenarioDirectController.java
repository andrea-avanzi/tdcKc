package it.ctinnovation.tdcKc.controller;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreResult;
import it.ctinnovation.tdcKc.model.scenario.entitiy.ScenarioEntity;
import it.ctinnovation.tdcKc.service.ScenarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import java.util.List;

import static ch.ralscha.extdirectspring.annotation.ExtDirectMethodType.STORE_MODIFY;
import static ch.ralscha.extdirectspring.annotation.ExtDirectMethodType.STORE_READ;

@Controller
@RequiredArgsConstructor
@Slf4j
public class ScenarioDirectController {

    final ScenarioService scenarioService;


    @ExtDirectMethod
    public String startSendMessageForPlacemark(List<ScenarioEntity> scenarios) {
        return "Started message sending for scenario list: " + scenarios;
    }

    @ExtDirectMethod
    public String stopSendMessageForPlacemark(List<ScenarioEntity> scenarios) {
        return "Stopped message sending for scenarioList " + scenarios;
    }

    @ExtDirectMethod(STORE_READ)
    public ExtDirectStoreResult<ScenarioEntity> read(ExtDirectStoreReadRequest storeRequest) {
        List<ScenarioEntity> data = scenarioService.read();
        return new ExtDirectStoreResult<>(data.size(), data);
    }

    @ExtDirectMethod(ExtDirectMethodType.STORE_MODIFY)
    public ScenarioEntity create(ScenarioEntity companyRole) {
        return scenarioService.create(companyRole);
    }

    @ExtDirectMethod(ExtDirectMethodType.STORE_MODIFY)
    public ScenarioEntity update(ScenarioEntity companyRole) {
        return scenarioService.update(companyRole);
    }

    @ExtDirectMethod(STORE_MODIFY)
    public void destroy(List<ScenarioEntity> companyRoleList) {
        scenarioService.destroy(companyRoleList);
    }
}
