package it.ctinnovation.tdcKc.service;

import it.ctinnovation.tdcKc.model.scenario.entity.ScenarioEntity;

import java.util.List;

public interface ScenarioService {
    List<ScenarioEntity> read();
    ScenarioEntity create (ScenarioEntity companyRole);
    ScenarioEntity update (ScenarioEntity scenarioEntity);
    void destroy(List<ScenarioEntity> companyRoles);

    ScenarioEntity getScenarioReference(Long id);

}
