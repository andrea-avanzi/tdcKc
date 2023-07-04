package it.ctinnovation.tdcKc.model.scenario;

import lombok.Value;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link ScenerioFlow}
 */
@Value
public class ScenerioFlowDto implements Serializable {
    Long id;
    String placemerk;
    Integer intervalBetweenMessages;
    List<List<ScenarioMessage>> messages;
}
