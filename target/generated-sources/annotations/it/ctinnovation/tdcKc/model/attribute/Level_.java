package it.ctinnovation.tdcKc.model.attribute;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Level.class)
public abstract class Level_ {

	public static volatile SingularAttribute<Level, Double> min;
	public static volatile SingularAttribute<Level, Double> max;
	public static volatile SingularAttribute<Level, String> operator;

	public static final String MIN = "min";
	public static final String MAX = "max";
	public static final String OPERATOR = "operator";

}

