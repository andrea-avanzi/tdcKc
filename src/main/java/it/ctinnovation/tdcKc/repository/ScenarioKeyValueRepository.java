package it.ctinnovation.tdcKc.repository;

import it.ctinnovation.tdcKc.model.scenario.entity.ScenarioKeyValue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScenarioKeyValueRepository extends JpaRepository<ScenarioKeyValue, Long> {

    @Query("select skv from ScenarioKeyValue skv where skv.scenarioPlacemark.id = ?1")
    List<ScenarioKeyValue> readKeyValues(Long scenarioPlacemarkId);
}
