package it.ctinnovation.tdcKc.model.attribute;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Attribute.class)
public abstract class Attribute_ {

	public static volatile SingularAttribute<Attribute, String> createdAt;
	public static volatile SingularAttribute<Attribute, Boolean> createNotificationEventsOnDanger;
	public static volatile SingularAttribute<Attribute, List<java.lang.String>> allowedKeys;
	public static volatile SingularAttribute<Attribute, Map<java.lang.String, java.lang.String>> description_i18n;
	public static volatile SingularAttribute<Attribute, Map<java.lang.String, java.lang.String>> name_i18n;
	public static volatile SingularAttribute<Attribute, String> name;
	public static volatile SingularAttribute<Attribute, String> description;
	public static volatile SingularAttribute<Attribute, Long> id;
	public static volatile SingularAttribute<Attribute, String> iconKey;
	public static volatile SingularAttribute<Attribute, Integer> channelId;
	public static volatile SingularAttribute<Attribute, Map<java.lang.String, it.ctinnovation.tdcKc.model.attribute.Threshold>> statusThresholds;
	public static volatile SingularAttribute<Attribute, String> updatedAt;

	public static final String CREATED_AT = "createdAt";
	public static final String CREATE_NOTIFICATION_EVENTS_ON_DANGER = "createNotificationEventsOnDanger";
	public static final String ALLOWED_KEYS = "allowedKeys";
	public static final String DESCRIPTION_I18N = "description_i18n";
	public static final String NAME_I18N = "name_i18n";
	public static final String NAME = "name";
	public static final String DESCRIPTION = "description";
	public static final String ID = "id";
	public static final String ICON_KEY = "iconKey";
	public static final String CHANNEL_ID = "channelId";
	public static final String STATUS_THRESHOLDS = "statusThresholds";
	public static final String UPDATED_AT = "updatedAt";

}

