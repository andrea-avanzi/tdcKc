package it.ctinnovation.tdcKc.model.scenario.entity;

import it.ctinnovation.tdcKc.model.abstractEntities.AbstractEntity;
import it.ctinnovation.tdcKc.model.placemark.PlacemarkAttributeSearch;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "scenario_placemark")
public class ScenarioPlacemark extends AbstractEntity {

    @ManyToOne
    ScenarioEntity scenarioEntity;

    @ManyToOne
    PlacemarkAttributeSearch    placemarkAttributeSearch;

    Integer iterations;
    Integer interval;

    public ScenarioEntity getScenarioEntity() {
        return scenarioEntity;
    }

    public void setScenarioEntity(ScenarioEntity scenarioEntity) {
        this.scenarioEntity = scenarioEntity;
    }

    public PlacemarkAttributeSearch getPlacemarkAttributeSearch() {
        return placemarkAttributeSearch;
    }

    public void setPlacemarkAttributeSearch(PlacemarkAttributeSearch placemarkAttributeSearch) {
        this.placemarkAttributeSearch = placemarkAttributeSearch;
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

    @Override
    public String toString() {
        return "ScenarioPlacemark{" +
            "scenarioEntity=" + scenarioEntity +
            ", placemarkAttributeSearch=" + placemarkAttributeSearch +
            ", iterations=" + iterations +
            ", interval=" + interval +
            '}';
    }
}
