package it.ctinnovation.tdcKc.model.scenario.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import it.ctinnovation.tdcKc.model.message.KeyValue;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ScenarioPlacemarkMessage {
    Long scenarioPlacemarkId;
    String publicId;
    List<KeyValue> keyValues=new ArrayList<>();

    public Long getScenarioPlacemarkId() {
        return scenarioPlacemarkId;
    }

    public void setScenarioPlacemarkId(Long scenarioPlacemarkId) {
        this.scenarioPlacemarkId = scenarioPlacemarkId;
    }

    public List<KeyValue> getKeyValues() {
        return keyValues;
    }

    public void setKeyValues(List<KeyValue> keyValues) {
        this.keyValues = keyValues;
    }

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    @Override
    public String toString() {
        return "ScenarioMessage{" +
            "scenarioPlacemarkId=" + scenarioPlacemarkId +
            ", publicId='" + publicId + '\'' +
            ", keyValues=" + keyValues +
            '}';
    }
}
