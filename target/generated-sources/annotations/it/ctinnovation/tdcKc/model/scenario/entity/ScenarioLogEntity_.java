package it.ctinnovation.tdcKc.model.scenario.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ScenarioLogEntity.class)
public abstract class ScenarioLogEntity_ extends it.ctinnovation.tdcKc.model.abstractEntities.AbstractEntity_ {

	public static volatile SingularAttribute<ScenarioLogEntity, String> cron;
	public static volatile SingularAttribute<ScenarioLogEntity, Date> startingTime;
	public static volatile SingularAttribute<ScenarioLogEntity, String> name;
	public static volatile SingularAttribute<ScenarioLogEntity, Long> scenarioId;

	public static final String CRON = "cron";
	public static final String STARTING_TIME = "startingTime";
	public static final String NAME = "name";
	public static final String SCENARIO_ID = "scenarioId";

}

