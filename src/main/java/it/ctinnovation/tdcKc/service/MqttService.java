package it.ctinnovation.tdcKc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.ctinnovation.tdcKc.model.message.Message;
import it.ctinnovation.tdcKc.model.message.MqttMessage;

import java.util.List;

public interface MqttService {

    void sendMessageToMqttBroker(MqttMessage mqttMessage) throws Exception;

    void sendMessageToMqttBroker(String placemark, String key, String message) throws JsonProcessingException;

    void sendMessagesToMqttBroker(MqttMessage mqttMessage) throws Exception;
}
