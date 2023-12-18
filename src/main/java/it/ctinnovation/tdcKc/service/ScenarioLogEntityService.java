package it.ctinnovation.tdcKc.service;

import it.ctinnovation.tdcKc.model.scenario.entity.ScenarioLogEntity;

import java.util.List;

public interface ScenarioLogEntityService {
    public List<ScenarioLogEntity> readAll();

    void createLog(Long scenarioId, String cron);

    void removeLog(Long scenarioId);
}
