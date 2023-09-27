package it.ctinnovation.tdcKc.model.placemark;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.List;
import java.util.Map;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PlacemarkAttributeSearch.class)
public abstract class PlacemarkAttributeSearch_ {

	public static volatile SingularAttribute<PlacemarkAttributeSearch, String> payloadTimestamp;
	public static volatile SingularAttribute<PlacemarkAttributeSearch, Map<java.lang.String, java.lang.String>> attributeName_i18n;
	public static volatile SingularAttribute<PlacemarkAttributeSearch, String> description;
	public static volatile SingularAttribute<PlacemarkAttributeSearch, String> iconKey;
	public static volatile SingularAttribute<PlacemarkAttributeSearch, String> title;
	public static volatile SingularAttribute<PlacemarkAttributeSearch, Map<java.lang.String, it.ctinnovation.tdcKc.model.placemark.Threshold>> statusThresholds;
	public static volatile SingularAttribute<PlacemarkAttributeSearch, String> attributeUpdatedAt;
	public static volatile SingularAttribute<PlacemarkAttributeSearch, List<java.lang.String>> tags;
	public static volatile SingularAttribute<PlacemarkAttributeSearch, Integer> attributeId;
	public static volatile SingularAttribute<PlacemarkAttributeSearch, String> createdAt;
	public static volatile SingularAttribute<PlacemarkAttributeSearch, List<java.util.Map<java.lang.String, java.lang.Object>>> payload;
	public static volatile SingularAttribute<PlacemarkAttributeSearch, String> assetId;
	public static volatile SingularAttribute<PlacemarkAttributeSearch, String> placemarkUpdatedAt;
	public static volatile SingularAttribute<PlacemarkAttributeSearch, Geometry> geometry;
	public static volatile SingularAttribute<PlacemarkAttributeSearch, Long> id;
	public static volatile SingularAttribute<PlacemarkAttributeSearch, Object> additionalProperties;
	public static volatile SingularAttribute<PlacemarkAttributeSearch, Integer> channelId;
	public static volatile SingularAttribute<PlacemarkAttributeSearch, String> publicId;
	public static volatile SingularAttribute<PlacemarkAttributeSearch, String> status;
	public static volatile SingularAttribute<PlacemarkAttributeSearch, String> updatedAt;

	public static final String PAYLOAD_TIMESTAMP = "payloadTimestamp";
	public static final String ATTRIBUTE_NAME_I18N = "attributeName_i18n";
	public static final String DESCRIPTION = "description";
	public static final String ICON_KEY = "iconKey";
	public static final String TITLE = "title";
	public static final String STATUS_THRESHOLDS = "statusThresholds";
	public static final String ATTRIBUTE_UPDATED_AT = "attributeUpdatedAt";
	public static final String TAGS = "tags";
	public static final String ATTRIBUTE_ID = "attributeId";
	public static final String CREATED_AT = "createdAt";
	public static final String PAYLOAD = "payload";
	public static final String ASSET_ID = "assetId";
	public static final String PLACEMARK_UPDATED_AT = "placemarkUpdatedAt";
	public static final String GEOMETRY = "geometry";
	public static final String ID = "id";
	public static final String ADDITIONAL_PROPERTIES = "additionalProperties";
	public static final String CHANNEL_ID = "channelId";
	public static final String PUBLIC_ID = "publicId";
	public static final String STATUS = "status";
	public static final String UPDATED_AT = "updatedAt";

}

