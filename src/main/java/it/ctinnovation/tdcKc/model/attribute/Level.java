package it.ctinnovation.tdcKc.model.attribute;

import jakarta.persistence.Embeddable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Embeddable
@NoArgsConstructor
@Getter
@Setter
public class Level {
    private Object value;
    private double min;
    private double max;
    private String operator;

}
