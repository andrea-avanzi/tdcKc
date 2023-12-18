package it.ctinnovation.tdcKc.model.scenario.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import it.ctinnovation.tdcKc.model.abstractEntities.AbstractEntity;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.DateTime;

import java.time.Instant;
import java.util.Date;

@Getter
@Setter
@Entity
public class ScenarioLogEntity extends AbstractEntity {
    Long scenarioId;
    String name;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "CET")
    Date startingTime;
    String cron;
}
