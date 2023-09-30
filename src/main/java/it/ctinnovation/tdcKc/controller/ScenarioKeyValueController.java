package it.ctinnovation.tdcKc.controller;

import ch.ralscha.extdirectspring.annotation.ExtDirectMethod;
import ch.ralscha.extdirectspring.annotation.ExtDirectMethodType;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.ExtDirectStoreResult;
import it.ctinnovation.tdcKc.model.scenario.dto.ScenarioKeyValueDto;
import it.ctinnovation.tdcKc.service.ScenarioKeyValueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import java.util.List;

import static ch.ralscha.extdirectspring.annotation.ExtDirectMethodType.STORE_MODIFY;
import static ch.ralscha.extdirectspring.annotation.ExtDirectMethodType.STORE_READ;

@Controller
@Slf4j
@RequiredArgsConstructor
public class ScenarioKeyValueController {
    private final ScenarioKeyValueService scenarioKeyValueService;

    @ExtDirectMethod(STORE_READ)
    public ExtDirectStoreResult<ScenarioKeyValueDto> read(ExtDirectStoreReadRequest storeRequest) {
        List<ScenarioKeyValueDto> data = scenarioKeyValueService.read();
        return new ExtDirectStoreResult<>(data.size(), data);
    }

    @ExtDirectMethod(ExtDirectMethodType.STORE_MODIFY)
    public ScenarioKeyValueDto create(ScenarioKeyValueDto scenarioKeyValueDto) {
        return scenarioKeyValueService.create(scenarioKeyValueDto);
    }

    @ExtDirectMethod(ExtDirectMethodType.STORE_MODIFY)
    public ScenarioKeyValueDto update(ScenarioKeyValueDto scenarioKeyValueDto) {
        return scenarioKeyValueService.update(scenarioKeyValueDto);
    }

    @ExtDirectMethod(STORE_MODIFY)
    public void destroy(List<ScenarioKeyValueDto> scenarioKeyValueDtos) {
        scenarioKeyValueService.destroy(scenarioKeyValueDtos);
    }
}
