package it.ctinnovation.tdcKc.model.scenario.entity;

import it.ctinnovation.tdcKc.model.abstractEntities.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
public class ScenarioLogEntity extends AbstractEntity {
    Integer scenarioId;
    String key;
    String name;
    String description;
    Instant startingTime;
    Integer itarations;
}
