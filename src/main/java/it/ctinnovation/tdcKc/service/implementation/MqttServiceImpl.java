package it.ctinnovation.tdcKc.service.implementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.ctinnovation.tdcKc.model.message.Message;
import it.ctinnovation.tdcKc.model.message.MqttMessage;
import it.ctinnovation.tdcKc.service.MqttGateway;
import it.ctinnovation.tdcKc.service.MqttService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MqttServiceImpl implements MqttService{

    MqttGateway mqttGateway;
    ObjectMapper objectMapper;

    public MqttServiceImpl(MqttGateway mqttGateway, ObjectMapper objectMapper) {
        this.mqttGateway = mqttGateway;
        this.objectMapper = objectMapper;
    }

    @Override
    public void sendMessageToMqttBroker(MqttMessage mqttMessage) throws Exception {
        mqttGateway.sendToMqtt(objectMapper.writeValueAsString(mqttMessage));
    }

    @Override
    public void sendMessageToMqttBroker(String placemark, String key, String message) throws JsonProcessingException {
        Message msg = new Message(key, message);
        List<Message> messageList = List.of(msg);
        MqttMessage mqttMessage = new MqttMessage(placemark, messageList);
        mqttGateway.sendToMqtt(objectMapper.writeValueAsString(mqttMessage));

    }
}
