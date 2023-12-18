package it.ctinnovation.tdcKc.model.scenario.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ScenarioEntity.class)
public abstract class ScenarioEntity_ extends it.ctinnovation.tdcKc.model.abstractEntities.AbstractEntity_ {

	public static volatile SingularAttribute<ScenarioEntity, String> name;
	public static volatile SingularAttribute<ScenarioEntity, String> description;
	public static volatile SingularAttribute<ScenarioEntity, Integer> interval;
	public static volatile SingularAttribute<ScenarioEntity, Integer> iterations;

	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String INTERVAL = "interval";
	public static final String ITERATIONS = "iterations";

}

