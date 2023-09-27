package it.ctinnovation.tdcKc.model.scenario.entitiy;

import it.ctinnovation.tdcKc.model.abstractEntities.AbstractEntity;
import it.ctinnovation.tdcKc.model.message.MessageObject;
import it.ctinnovation.tdcKc.model.placemark.PayloadItem;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import java.util.List;
import java.util.Objects;

@Entity
public class ScenarioMessageEntity extends AbstractEntity {

    @ManyToOne
    ScenarioEntity scenarioEntity;

    @Embedded
    MessageObject messageObject;

    //region Accessors

    public ScenarioEntity getScenarioEntity() {
        return scenarioEntity;
    }

    public void setScenarioEntity(ScenarioEntity scenarioEntity) {
        this.scenarioEntity = scenarioEntity;
    }

    public MessageObject getMessageObject() {
        return messageObject;
    }

    public void setMessageObject(MessageObject messageObject) {
        this.messageObject = messageObject;
    }

    @Override
    public String toString() {
        return "ScenarioMessageEntity{" +
            "scenarioEntity=" + scenarioEntity +
            ", messageObject=" + messageObject +
            '}';
    }

    //endregion
}
