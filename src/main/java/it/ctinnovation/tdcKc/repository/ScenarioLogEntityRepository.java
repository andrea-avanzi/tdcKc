package it.ctinnovation.tdcKc.repository;

import it.ctinnovation.tdcKc.model.scenario.entity.ScenarioLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScenarioLogEntityRepository extends JpaRepository<ScenarioLogEntity, Long> {
    void deleteByScenarioId(Long scenarioId);

    ScenarioLogEntity findByScenarioId(Long scenarioId);
}
