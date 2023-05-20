package it.ctinnovation.tdcKc.model.attribute;

import java.util.Map;


public class Threshold {

    private String type;

    private Map<String, Level> levels;

    // Getters and setters

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Level> getLevels() {
        return levels;
    }

    public void setLevels(Map<String, Level> levels) {
        this.levels = levels;
    }
}
