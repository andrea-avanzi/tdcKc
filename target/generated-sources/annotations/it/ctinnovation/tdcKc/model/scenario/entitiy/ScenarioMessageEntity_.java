package it.ctinnovation.tdcKc.model.scenario.entitiy;

import it.ctinnovation.tdcKc.model.message.MessageObject;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ScenarioMessageEntity.class)
public abstract class ScenarioMessageEntity_ extends it.ctinnovation.tdcKc.model.abstractEntities.AbstractEntity_ {

	public static volatile SingularAttribute<ScenarioMessageEntity, ScenarioEntity> scenarioEntity;
	public static volatile SingularAttribute<ScenarioMessageEntity, MessageObject> messageObject;

	public static final String SCENARIO_ENTITY = "scenarioEntity";
	public static final String MESSAGE_OBJECT = "messageObject";

}

