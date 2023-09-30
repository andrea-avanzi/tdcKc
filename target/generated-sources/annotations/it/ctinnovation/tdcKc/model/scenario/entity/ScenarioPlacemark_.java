package it.ctinnovation.tdcKc.model.scenario.entity;

import it.ctinnovation.tdcKc.model.placemark.PlacemarkAttributeSearch;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ScenarioPlacemark.class)
public abstract class ScenarioPlacemark_ extends it.ctinnovation.tdcKc.model.abstractEntities.AbstractEntity_ {

	public static volatile SingularAttribute<ScenarioPlacemark, ScenarioEntity> scenarioEntity;
	public static volatile SingularAttribute<ScenarioPlacemark, PlacemarkAttributeSearch> placemarkAttributeSearch;
	public static volatile SingularAttribute<ScenarioPlacemark, Integer> interval;
	public static volatile SingularAttribute<ScenarioPlacemark, Integer> iterations;

	public static final String SCENARIO_ENTITY = "scenarioEntity";
	public static final String PLACEMARK_ATTRIBUTE_SEARCH = "placemarkAttributeSearch";
	public static final String INTERVAL = "interval";
	public static final String ITERATIONS = "iterations";

}

