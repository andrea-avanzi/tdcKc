package it.ctinnovation.tdcKc.model.scenario.entitiy;

import it.ctinnovation.tdcKc.model.abstractEntities.AbstractEntity;
import jakarta.persistence.Entity;

import java.time.Instant;

@Entity
public class ScenarioLogEntity extends AbstractEntity {
    Integer scenarioId;
    String key;
    String name;
    String description;
    Instant startingTime;
    Integer itarations;

    //region Accessors
    public Integer getScenarioId() {
        return scenarioId;
    }

    public void setScenarioId(Integer scenarioId) {
        this.scenarioId = scenarioId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Instant getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(Instant startingTime) {
        this.startingTime = startingTime;
    }

    public Integer getItarations() {
        return itarations;
    }

    public void setItarations(Integer itarations) {
        this.itarations = itarations;
    }

    @Override
    public String toString() {
        return "ScenarioLog{" +
            "key='" + key + '\'' +
            ", name='" + name + '\'' +
            ", description='" + description + '\'' +
            ", startingTime=" + startingTime +
            ", itarations=" + itarations +
            '}';
    }

    //endregion


}
