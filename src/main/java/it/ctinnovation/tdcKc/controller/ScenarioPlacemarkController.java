package it.ctinnovation.tdcKc.controller;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreResult;
import it.ctinnovation.tdcKc.model.scenario.dto.ScenarioPlacemarkDto;
import it.ctinnovation.tdcKc.service.ScenarioPlacemarkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import java.util.List;

import static ch.ralscha.extdirectspring.annotation.ExtDirectMethodType.STORE_MODIFY;
import static ch.ralscha.extdirectspring.annotation.ExtDirectMethodType.STORE_READ;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ScenarioPlacemarkController {

    private final ScenarioPlacemarkService scenarioPlacemarkService;

    @ExtDirectMethod(STORE_READ)
    public ExtDirectStoreResult<ScenarioPlacemarkDto> read(ExtDirectStoreReadRequest storeRequest) {
        Long scenarioId=null;
        if(storeRequest.getParams()!=null && storeRequest.getParams().containsKey("scenarioId"))
            scenarioId=Long.parseLong(storeRequest.getParams().get("scenarioId").toString());
        List<ScenarioPlacemarkDto> data = scenarioPlacemarkService.read(scenarioId);
        return new ExtDirectStoreResult<>(data.size(), data);
    }

    @ExtDirectMethod(ExtDirectMethodType.STORE_MODIFY)
    public ScenarioPlacemarkDto create(ScenarioPlacemarkDto scenarioPlacemarkDto) {
        return scenarioPlacemarkService.create(scenarioPlacemarkDto);
    }

    @ExtDirectMethod(ExtDirectMethodType.STORE_MODIFY)
    public ScenarioPlacemarkDto update(ScenarioPlacemarkDto scenarioPlacemarkDto) {
        return scenarioPlacemarkService.update(scenarioPlacemarkDto);
    }

    @ExtDirectMethod(STORE_MODIFY)
    public void destroy(List<ScenarioPlacemarkDto> scenarioPlacemarkDtoList) {
        scenarioPlacemarkService.destroy(scenarioPlacemarkDtoList);
    }
}
