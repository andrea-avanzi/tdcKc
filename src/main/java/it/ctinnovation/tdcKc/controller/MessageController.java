package it.ctinnovation.tdcKc.controller;

import it.ctinnovation.tdcKc.model.message.MessageObject;
import it.ctinnovation.tdcKc.model.message.MqttMessage;
import it.ctinnovation.tdcKc.service.AsyncProcessMessage;
import it.ctinnovation.tdcKc.service.MqttService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MessageController {

    final MqttService mqttService;
    final AsyncProcessMessage asyncProcessMessage;

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

    @PostMapping("/processMessage")
    public Map<String, String> processMessage(@RequestBody MessageObject messageObject) {
        // Your processing logic here
        asyncProcessMessage.processMessages(messageObject);
        Map<String, String> response = new HashMap<>();
        response.put("status", "success");
        return response;
    }
}
