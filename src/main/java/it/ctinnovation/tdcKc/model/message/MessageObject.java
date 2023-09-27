package it.ctinnovation.tdcKc.model.message;

import io.hypersistence.utils.hibernate.type.json.JsonType;
import jakarta.persistence.Embeddable;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.List;

@Data
@Embeddable
public class MessageObject {
    private String placemark;
    private int iterations;
    private int interval;

    @Type(JsonType.class)
    private List<List<KeyValue>> messages; // Assuming that 'messages' (the matrix) is a List of Lists
}
