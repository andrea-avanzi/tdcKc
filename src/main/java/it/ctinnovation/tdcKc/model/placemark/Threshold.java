package it.ctinnovation.tdcKc.model.placemark;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter
public class Threshold {
    private String type;

    @Embedded
    private Levels levels;

}
