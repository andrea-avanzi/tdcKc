package it.ctinnovation.tdcKc.model.scenario.entity;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ScenarioKeyValue.class)
public abstract class ScenarioKeyValue_ extends it.ctinnovation.tdcKc.model.abstractEntities.AbstractEntity_ {

	public static volatile SingularAttribute<ScenarioKeyValue, String> keyValue;
	public static volatile SingularAttribute<ScenarioKeyValue, String> keyName;
	public static volatile SingularAttribute<ScenarioKeyValue, String> key;
	public static volatile SingularAttribute<ScenarioKeyValue, ScenarioPlacemark> scenarioPlacemark;

	public static final String KEY_VALUE = "keyValue";
	public static final String KEY_NAME = "keyName";
	public static final String KEY = "key";
	public static final String SCENARIO_PLACEMARK = "scenarioPlacemark";

}

