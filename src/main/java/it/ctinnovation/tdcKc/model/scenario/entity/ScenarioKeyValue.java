package it.ctinnovation.tdcKc.model.scenario.entity;

import it.ctinnovation.tdcKc.model.abstractEntities.AbstractEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "scenario_keyvalue")
public class ScenarioKeyValue extends AbstractEntity {

    @ManyToOne
    ScenarioPlacemark scenarioPlacemark;

    String key;
    String keyName;
    String keyValue;

    public ScenarioPlacemark getScenarioPlacemark() {
        return scenarioPlacemark;
    }

    public void setScenarioPlacemark(ScenarioPlacemark scenarioPlacemark) {
        this.scenarioPlacemark = scenarioPlacemark;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }
}
