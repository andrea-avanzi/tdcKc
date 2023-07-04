package it.ctinnovation.tdcKc.model.attribute;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import it.ctinnovation.tdcKc.model.abstractEntities.AbstractEntity;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

import java.util.List;
import java.util.Map;

@Entity
public class Attribute {
    @Id
    private Long id;

    private int channelId;

    @Type(JsonType.class)
    private Map<String, String> name_i18n;

    @Type(JsonType.class)
    private Map<String, String> description_i18n;

    @Type(JsonType.class)
    private Map<String,Threshold> statusThresholds;

    private String iconKey;

    @Type(JsonType.class)
    private List<String> allowedKeys;

    private boolean createNotificationEventsOnDanger;
    private String createdAt;
    private String updatedAt;
    private String name;
    private String description;

    //region Getters and setters

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

    public Map<String, String> getName_i18n() {
        return name_i18n;
    }

    public void setName_i18n(Map<String, String> name_i18n) {
        this.name_i18n = name_i18n;
    }

    public Map<String, String> getDescription_i18n() {
        return description_i18n;
    }

    public void setDescription_i18n(Map<String, String> description_i18n) {
        this.description_i18n = description_i18n;
    }

    public Map<String, Threshold> getStatusThresholds() {
        return statusThresholds;
    }

    public void setStatusThresholds(Map<String, Threshold> statusThresholds) {
        this.statusThresholds = statusThresholds;
    }

    public String getIconKey() {
        return iconKey;
    }

    public void setIconKey(String iconKey) {
        this.iconKey = iconKey;
    }

    public List<String> getAllowedKeys() {
        return allowedKeys;
    }

    public void setAllowedKeys(List<String> allowedKeys) {
        this.allowedKeys = allowedKeys;
    }

    public boolean isCreateNotificationEventsOnDanger() {
        return createNotificationEventsOnDanger;
    }

    public void setCreateNotificationEventsOnDanger(boolean createNotificationEventsOnDanger) {
        this.createNotificationEventsOnDanger = createNotificationEventsOnDanger;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    //endregion
}
