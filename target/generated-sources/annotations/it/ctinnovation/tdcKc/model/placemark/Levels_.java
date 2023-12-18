package it.ctinnovation.tdcKc.model.placemark;

import it.ctinnovation.tdcKc.model.attribute.Level;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Levels.class)
public abstract class Levels_ {

	public static volatile SingularAttribute<Levels, Level> success;
	public static volatile SingularAttribute<Levels, Level> warning;
	public static volatile SingularAttribute<Levels, Level> danger;

	public static final String SUCCESS = "success";
	public static final String WARNING = "warning";
	public static final String DANGER = "danger";

}

