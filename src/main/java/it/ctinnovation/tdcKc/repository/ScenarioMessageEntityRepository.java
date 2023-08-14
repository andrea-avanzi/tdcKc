package it.ctinnovation.tdcKc.repository;

import it.ctinnovation.tdcKc.model.scenario.entitiy.ScenarioMessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScenarioMessageEntityRepository extends JpaRepository<ScenarioMessageEntity, Long> {

    public List<ScenarioMessageEntity> findAllByName(String name);
}
