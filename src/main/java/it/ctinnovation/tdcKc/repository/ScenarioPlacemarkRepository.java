package it.ctinnovation.tdcKc.repository;

import it.ctinnovation.tdcKc.model.scenario.entity.ScenarioPlacemark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScenarioPlacemarkRepository extends JpaRepository<ScenarioPlacemark, Long> {
    List<ScenarioPlacemark> findByScenarioEntityId(Long scenarioId);
}
