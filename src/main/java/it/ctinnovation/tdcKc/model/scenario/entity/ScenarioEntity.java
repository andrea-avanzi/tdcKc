package it.ctinnovation.tdcKc.model.scenario.entity;

import it.ctinnovation.tdcKc.model.abstractEntities.AbstractEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "scenario_entity")
public class ScenarioEntity extends AbstractEntity {
    String name;
    Integer iterations;
    Integer interval;

    @Column(length = 4096)
    String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getIterations() {
        return iterations;
    }

    public void setIterations(Integer iterations) {
        this.iterations = iterations;
    }

    public Integer getInterval() {
        return interval;
    }

    public void setInterval(Integer interval) {
        this.interval = interval;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
