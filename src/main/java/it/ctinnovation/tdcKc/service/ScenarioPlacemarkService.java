package it.ctinnovation.tdcKc.service;

import it.ctinnovation.tdcKc.model.scenario.dto.ScenarioPlacemarkDto;

import java.util.List;

public interface ScenarioPlacemarkService {
    List<ScenarioPlacemarkDto> read(Long scenarioId);
    ScenarioPlacemarkDto create(ScenarioPlacemarkDto scenarioPlacemarkDto);
    ScenarioPlacemarkDto update(ScenarioPlacemarkDto scenarioPlacemarkDto);
    void destroy(List<ScenarioPlacemarkDto> scenarioPlacemarkDtos);
}
