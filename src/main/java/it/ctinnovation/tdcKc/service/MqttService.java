package it.ctinnovation.tdcKc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.ctinnovation.tdcKc.model.message.MqttMessage;

public interface MqttService {

    void sendMessageToMqttBroker(MqttMessage mqttMessage) throws Exception;

    void sendMessageToMqttBroker(String placemark, String key, String message) throws JsonProcessingException;
}
