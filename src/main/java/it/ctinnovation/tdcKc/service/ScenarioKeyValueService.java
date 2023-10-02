package it.ctinnovation.tdcKc.service;

import it.ctinnovation.tdcKc.model.scenario.dto.ScenarioKeyValueDto;

import java.util.List;

public interface ScenarioKeyValueService {
    List<ScenarioKeyValueDto> read(Long placemarkId);
    ScenarioKeyValueDto create(ScenarioKeyValueDto scenarioKeyValueDto);
    ScenarioKeyValueDto update(ScenarioKeyValueDto scenarioKeyValueDto);
    void destroy(List<ScenarioKeyValueDto> scenarioKeyValueDtos);
}
