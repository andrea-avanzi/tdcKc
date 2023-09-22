package it.ctinnovation.tdcKc.service.implementation;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.ctinnovation.tdcKc.model.message.Message;
import it.ctinnovation.tdcKc.model.message.MqttMessage;
import it.ctinnovation.tdcKc.model.placemark.PlacemarkAttributeSearch;
import it.ctinnovation.tdcKc.service.MqttGateway;
import it.ctinnovation.tdcKc.service.MqttService;
import it.ctinnovation.tdcKc.service.PlacemarkAttributeSearchService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MqttServiceImpl implements MqttService{

    MqttGateway mqttGateway;
    ObjectMapper objectMapper;
    PlacemarkAttributeSearchService placemarkAttributeSearchService;


    public MqttServiceImpl(MqttGateway mqttGateway, ObjectMapper objectMapper, PlacemarkAttributeSearchService placemarkService) {
        this.mqttGateway = mqttGateway;
        this.objectMapper = objectMapper;
        this.placemarkAttributeSearchService = placemarkService;
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

    @Override
    @Transactional
    public void sendMessagesToMqttBroker(MqttMessage mqttMessage) throws Exception {
        mqttGateway.sendToMqtt(objectMapper.writeValueAsString(mqttMessage));
        String placemarkId= mqttMessage.name();
        Optional<PlacemarkAttributeSearch> placemark = placemarkAttributeSearchService.findByPublicId(placemarkId);
        if(placemark.isPresent()){
            PlacemarkAttributeSearch placemarkAttributeSearch = placemark.get();
            List<Map<String, Object>> mapList = mqttMessage.data().stream()
                .map(message -> {
                    Map<String, Object> map = new HashMap<>();
                    map.put("key", message.key());
                    map.put("value", message.value());
                    return map;
                })
                .toList();
            placemarkAttributeSearch.setPayload(mapList);
            placemarkAttributeSearchService.save(placemarkAttributeSearch);
        }

    }

}
