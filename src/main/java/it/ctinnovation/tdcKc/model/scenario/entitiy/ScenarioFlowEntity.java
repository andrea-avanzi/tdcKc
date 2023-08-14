package it.ctinnovation.tdcKc.model.scenario.entitiy;

import it.ctinnovation.tdcKc.model.abstractEntities.AbstractEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
public class ScenarioFlowEntity extends AbstractEntity {

    @ManyToOne
    ScenarioEntity scenario;

    @OneToMany(mappedBy = "scenarioFlowEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    List<ScenarioMessageEntity> scenarioMessages = new ArrayList<>();

    String placemerkId;

    Integer intervalBetweenMessages;

    //region Accessors

    public ScenarioEntity getScenario() {
        return scenario;
    }

    public void setScenario(ScenarioEntity scenario) {
        this.scenario = scenario;
    }

    public List<ScenarioMessageEntity> getScenarioMessages() {
        return scenarioMessages;
    }

    public void setScenarioMessages(List<ScenarioMessageEntity> scenarioMessages) {
        this.scenarioMessages = scenarioMessages;
    }

    public String getPlacemerkId() {
        return placemerkId;
    }

    public void setPlacemerkId(String placemerkId) {
        this.placemerkId = placemerkId;
    }

    public Integer getIntervalBetweenMessages() {
        return intervalBetweenMessages;
    }

    public void setIntervalBetweenMessages(Integer intervalBetweenMessages) {
        this.intervalBetweenMessages = intervalBetweenMessages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ScenarioFlowEntity that = (ScenarioFlowEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId());
    }

    @Override
    public String toString() {
        return "ScenarioFlowEntity{" +
            "placemerkId='" + placemerkId + '\'' +
            ", intervalBetweenMessages=" + intervalBetweenMessages +
            '}';
    }
    //endregion
}
