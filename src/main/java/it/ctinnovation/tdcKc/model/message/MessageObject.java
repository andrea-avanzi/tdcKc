package it.ctinnovation.tdcKc.model.message;

import lombok.Data;

import java.util.List;

@Data
public class MessageObject {
    private String placemark;
    private int iterations;
    private int interval;
    private List<List<KeyValue>> messages; // Assuming that 'messages' (the matrix) is a List of Lists
}
