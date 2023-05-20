package it.ctinnovation.tdcKc.model.attribute;

public class Level {
    private Object value;
    private double min;
    private double max;
    private String operator;

    // Getters and setters

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public double getMin() {
        return min;
    }

    public void setMin(double min) {
        this.min = min;
    }
    public double getMax() {
        return max;
    }

    public void setMax(double max) {
        this.max = max;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }
}
