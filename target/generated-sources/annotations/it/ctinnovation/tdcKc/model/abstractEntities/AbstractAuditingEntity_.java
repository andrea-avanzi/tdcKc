package it.ctinnovation.tdcKc.model.abstractEntities;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AbstractAuditingEntity.class)
public abstract class AbstractAuditingEntity_ extends it.ctinnovation.tdcKc.model.abstractEntities.AbstractEntity_ {

	public static volatile SingularAttribute<AbstractAuditingEntity, Long> createdDate;
	public static volatile SingularAttribute<AbstractAuditingEntity, String> createdBy;
	public static volatile SingularAttribute<AbstractAuditingEntity, Long> lastModifiedDate;
	public static volatile SingularAttribute<AbstractAuditingEntity, String> lastModifiedBy;
	public static volatile SingularAttribute<AbstractAuditingEntity, Long> version;

	public static final String CREATED_DATE = "createdDate";
	public static final String CREATED_BY = "createdBy";
	public static final String LAST_MODIFIED_DATE = "lastModifiedDate";
	public static final String LAST_MODIFIED_BY = "lastModifiedBy";
	public static final String VERSION = "version";

}

