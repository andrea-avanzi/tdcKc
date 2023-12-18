package it.ctinnovation.tdcKc.model.message;

import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.List;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MessageObject.class)
public abstract class MessageObject_ {

	public static volatile ListAttribute<MessageObject, List> messages;
	public static volatile SingularAttribute<MessageObject, String> placemark;
	public static volatile SingularAttribute<MessageObject, Integer> interval;
	public static volatile SingularAttribute<MessageObject, Integer> iterations;

	public static final String MESSAGES = "messages";
	public static final String PLACEMARK = "placemark";
	public static final String INTERVAL = "interval";
	public static final String ITERATIONS = "iterations";

}

