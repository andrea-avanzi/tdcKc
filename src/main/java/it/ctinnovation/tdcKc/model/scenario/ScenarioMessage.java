package it.ctinnovation.tdcKc.model.scenario;

import it.ctinnovation.tdcKc.model.abstractEntities.AbstractEntity;
import lombok.Data;

//@Entity
@Data
public class ScenarioMessage extends AbstractEntity {
   // String placeMark;
   // Integer intervalBetweenMessages;

    String ts;
    String msg;

}
