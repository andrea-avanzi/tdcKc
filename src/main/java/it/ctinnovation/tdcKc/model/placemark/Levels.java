package it.ctinnovation.tdcKc.model.placemark;

import com.fasterxml.jackson.annotation.JsonFormat;
import it.ctinnovation.tdcKc.model.attribute.Level;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Embeddable
@Getter
@Setter
public class Levels {
    //@Embedded
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<Level> warning;

    //@Embedded
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<Level> danger;

    //@Embedded
    @JsonFormat(with = JsonFormat.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY)
    private List<Level> success;

}
