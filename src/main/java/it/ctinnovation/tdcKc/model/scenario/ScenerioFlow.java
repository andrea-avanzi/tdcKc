package it.ctinnovation.tdcKc.model.scenario;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import it.ctinnovation.tdcKc.model.abstractEntities.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.List;

@Entity
@Data
public class ScenerioFlow extends AbstractEntity {
    String placemerk;
    Integer intervalBetweenMessages;

    @Type(JsonType.class)
    List<ScenarioMessage> messages;
}
