package it.ctinnovation.tdcKc.model.scenario.entitiy;

import it.ctinnovation.tdcKc.model.abstractEntities.AbstractEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class ScenarioEntity extends AbstractEntity {
    String name;

    @OneToMany(mappedBy = "scenario", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ScenarioFlowEntity> scenarioFlows = new ArrayList<>();

    //region Accessors
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ScenarioFlowEntity> getScenarioFlows() {
        return scenarioFlows;
    }

    public void setScenarioFlows(List<ScenarioFlowEntity> scenarioFlows) {
        this.scenarioFlows = scenarioFlows;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ScenarioEntity scenario = (ScenarioEntity) o;
        return Objects.equals(getId(), scenario.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId());
    }

    @Override
    public String toString() {
        return "ScenarioEntity{" +
            "name='" + name + '\'' +
            '}';
    }
    //endregion
}
