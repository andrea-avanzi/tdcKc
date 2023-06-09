package it.ctinnovation.tdcKc.controller;

import it.ctinnovation.tdcKc.model.message.Message;
import it.ctinnovation.tdcKc.model.message.MqttMessage;
import it.ctinnovation.tdcKc.service.MqttService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MessageController {

    MqttService mqttService;

    MessageController(MqttService mqttService) {
        this.mqttService = mqttService;
    }

    @PostMapping(value = "/sendMessage")
    public void sendMessage(@RequestParam String placemark,
                            @RequestParam String key,
                            @RequestParam String message) throws Exception {
        mqttService.sendMessageToMqttBroker(placemark,key,message);

    }

    @PostMapping(value = "/sendMessages")
    public void sendMessages(@RequestBody MqttMessage messages) throws Exception {
         mqttService.sendMessagesToMqttBroker(messages);

    }
}
