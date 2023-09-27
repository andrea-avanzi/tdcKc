package it.ctinnovation.tdcKc.model.scenario.entitiy;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ScenarioEntity.class)
public abstract class ScenarioEntity_ extends it.ctinnovation.tdcKc.model.abstractEntities.AbstractEntity_ {

	public static volatile SingularAttribute<ScenarioEntity, String> Description;
	public static volatile SingularAttribute<ScenarioEntity, String> name;

	public static final String DESCRIPTION = "Description";
	public static final String NAME = "name";

}

