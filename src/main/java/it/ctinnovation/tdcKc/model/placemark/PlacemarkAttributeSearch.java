package it.ctinnovation.tdcKc.model.placemark;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;

import java.util.List;
import java.util.Map;

@Entity
public class PlacemarkAttributeSearch {
    @Id
    private Long id;
    private int channelId;
    private String publicId;
    private String assetId;
    private int attributeId;

    @Type(JsonType.class)
    private Geometry geometry;

    private String status;
    private String iconKey;
    private String placemarkUpdatedAt;

    @Type(JsonType.class)
    private List<String> tags;


    @Type(JsonType.class)
    private List<Map<String, Object>> payload;

    private String payloadTimestamp;

    @Type(JsonType.class)
    private Map<String,Threshold> statusThresholds;

    private String title;
    private String description;
    private String createdAt;
    private String updatedAt;

    @Type(JsonType.class)
    private Map<String, String> attributeName_i18n;
    private String attributeUpdatedAt;

    @Type(JsonType.class)
    private Object additionalProperties;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int channelId) {
        this.channelId = channelId;
    }

    public String getPublicId() {
        return publicId;
    }

    public void setPublicId(String publicId) {
        this.publicId = publicId;
    }

    public String getAssetId() {
        return assetId;
    }

    public void setAssetId(String assetId) {
        this.assetId = assetId;
    }

    public int getAttributeId() {
        return attributeId;
    }

    public void setAttributeId(int attributeId) {
        this.attributeId = attributeId;
    }

    public Geometry getGeometry() {
        return geometry;
    }

    public void setGeometry(Geometry geometry) {
        this.geometry = geometry;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getIconKey() {
        return iconKey;
    }

    public void setIconKey(String iconKey) {
        this.iconKey = iconKey;
    }

    public String getPlacemarkUpdatedAt() {
        return placemarkUpdatedAt;
    }

    public void setPlacemarkUpdatedAt(String placemarkUpdatedAt) {
        this.placemarkUpdatedAt = placemarkUpdatedAt;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<Map<String, Object>> getPayload() {
        return payload;
    }

    public void setPayload(List<Map<String, Object>> payload) {
        this.payload = payload;
    }

    public String getPayloadTimestamp() {
        return payloadTimestamp;
    }

    public void setPayloadTimestamp(String payloadTimestamp) {
        this.payloadTimestamp = payloadTimestamp;
    }

    public Map<String, Threshold> getStatusThresholds() {
        return statusThresholds;
    }

    public void setStatusThresholds(Map<String, Threshold> statusThresholds) {
        this.statusThresholds = statusThresholds;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Map<String, String> getAttributeName_i18n() {
        return attributeName_i18n;
    }

    public void setAttributeName_i18n(Map<String, String> attributeName_i18n) {
        this.attributeName_i18n = attributeName_i18n;
    }

    public String getAttributeUpdatedAt() {
        return attributeUpdatedAt;
    }

    public void setAttributeUpdatedAt(String attributeUpdatedAt) {
        this.attributeUpdatedAt = attributeUpdatedAt;
    }

    public Object getAdditionalProperties() {
        return additionalProperties;
    }

    public void setAdditionalProperties(Object additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
}

