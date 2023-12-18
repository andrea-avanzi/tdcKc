package it.ctinnovation.tdcKc.service;

import it.ctinnovation.tdcKc.model.scenario.entity.ScenarioEntity;
import org.springframework.transaction.annotation.Transactional;


public interface ScenarioEntityService {

    @Transactional(readOnly = true)
    ScenarioEntity readScenario(Long scenarioId);
}
