package it.ctinnovation.tdcKc.model.placemark;

import java.util.List;

public class PlacemarkAttributeSearchReduced {
    private int id;
    private int channelId;
    private String publicId;
    private String assetId;
    private int attributeId;
    private Geometry geometry;
    private String status;
    private String iconKey;
    private List<PayloadItem> payload;

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public List<PayloadItem> getPayload() {
        return payload;
    }

    public void setPayload(List<PayloadItem> payload) {
        this.payload = payload;
    }
}

