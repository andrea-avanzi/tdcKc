package it.ctinnovation.tdcKc.model.scenario.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.time.Instant;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ScenarioLogEntity.class)
public abstract class ScenarioLogEntity_ extends it.ctinnovation.tdcKc.model.abstractEntities.AbstractEntity_ {

	public static volatile SingularAttribute<ScenarioLogEntity, Instant> startingTime;
	public static volatile SingularAttribute<ScenarioLogEntity, String> name;
	public static volatile SingularAttribute<ScenarioLogEntity, String> description;
	public static volatile SingularAttribute<ScenarioLogEntity, Integer> scenarioId;
	public static volatile SingularAttribute<ScenarioLogEntity, String> key;
	public static volatile SingularAttribute<ScenarioLogEntity, Integer> itarations;

	public static final String STARTING_TIME = "startingTime";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String SCENARIO_ID = "scenarioId";
	public static final String KEY = "key";
	public static final String ITARATIONS = "itarations";

}

