package it.ctinnovation.tdcKc.model.placemark;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;

@Embeddable
public class Threshold {
    private String type;

    @Embedded
    private Levels levels;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Levels getLevels() {
        return levels;
    }

    public void setLevels(Levels levels) {
        this.levels = levels;
    }
}
