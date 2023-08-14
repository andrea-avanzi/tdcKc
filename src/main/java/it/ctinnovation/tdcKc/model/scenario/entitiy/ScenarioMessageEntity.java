package it.ctinnovation.tdcKc.model.scenario.entitiy;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import it.ctinnovation.tdcKc.model.abstractEntities.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.Objects;

@Entity
public class ScenarioMessageEntity extends AbstractEntity {

    @ManyToOne
    ScenarioFlowEntity scenarioFlowEntity;

    private String name;

    @Type(JsonType.class)
    private List<DataItem> data;

    //region Accessors

    public ScenarioFlowEntity getScenarioFlowEntity() {
        return scenarioFlowEntity;
    }

    public void setScenarioFlowEntity(ScenarioFlowEntity scenarioFlowEntity) {
        this.scenarioFlowEntity = scenarioFlowEntity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<DataItem> getData() {
        return data;
    }

    public void setData(List<DataItem> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ScenarioMessageEntity that = (ScenarioMessageEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId());
    }
    //endregion
}
