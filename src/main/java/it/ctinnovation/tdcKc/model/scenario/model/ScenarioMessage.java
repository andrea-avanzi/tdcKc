package it.ctinnovation.tdcKc.model.scenario.model;

import java.util.ArrayList;
import java.util.List;

public class ScenarioMessage {
    private Long scenarioId;
    private Integer iterations;
    private Integer interval;
    private List<ScenarioPlacemarkMessage> scenarioPlacemarkMessages = new ArrayList<>();

    public Long getScenarioId() {
        return scenarioId;
    }

    public void setScenarioId(Long scenarioId) {
        this.scenarioId = scenarioId;
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

    public List<ScenarioPlacemarkMessage> getScenarioPlacemarkMessages() {
        return scenarioPlacemarkMessages;
    }

    public void setScenarioPlacemarkMessages(List<ScenarioPlacemarkMessage> scenarioPlacemarkMessages) {
        this.scenarioPlacemarkMessages = scenarioPlacemarkMessages;
    }

    @Override
    public String toString() {
        return "ScenarioMessage{" +
            "scenarioId=" + scenarioId +
            ", iterations=" + iterations +
            ", interval=" + interval +
            ", scenarioPlacemarkMessages=" + scenarioPlacemarkMessages +
            '}';
    }
}
