package it.ctinnovation.tdcKc.model.message;

import java.util.List;

public record MqttMessage(String name, List<Message> data) {
}
