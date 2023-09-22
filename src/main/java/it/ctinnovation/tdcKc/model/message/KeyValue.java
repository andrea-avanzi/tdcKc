package it.ctinnovation.tdcKc.model.message;

public class KeyValue {
    private String key;
    private String value; // Making this an Object to accommodate for different data types

    // Getters and setters
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
