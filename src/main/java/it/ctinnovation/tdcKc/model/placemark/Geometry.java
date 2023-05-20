package it.ctinnovation.tdcKc.model.placemark;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;

import java.io.Serializable;
import java.util.List;

public class Geometry implements Serializable {
    private String type;

    @Lob
    @Column(columnDefinition = "jsonb")
    private List<Double> coordinates;

    // Getters and Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCoordinates(List<Double> coordinates) {
        this.coordinates = coordinates;
    }

    @Lob
    public List<Double> getCoordinates() {
        return coordinates;
    }
}
