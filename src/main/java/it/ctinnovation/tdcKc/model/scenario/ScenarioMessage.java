package it.ctinnovation.tdcKc.model.scenario;

import it.ctinnovation.tdcKc.model.abstractEntities.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class ScenarioMessage extends AbstractEntity {
    String ts;
    String msg;
}
