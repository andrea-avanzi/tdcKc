package it.ctinnovation.tdcKc.service;

import it.ctinnovation.tdcKc.model.message.KeyValue;
import it.ctinnovation.tdcKc.model.message.Message;
import it.ctinnovation.tdcKc.model.message.MessageObject;
import it.ctinnovation.tdcKc.model.message.MqttMessage;
import it.ctinnovation.tdcKc.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Slf4j
@RequiredArgsConstructor
public class AsyncProcessMessage {

    final MqttService mqttService;

    @Async
    public void processMessages(MessageObject messageObject) {
        // Your processing logic here

        int iterations = messageObject.getIterations();
        int interval = messageObject.getInterval();

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        AtomicInteger counter = new AtomicInteger(0);

        scheduler.scheduleAtFixedRate(() -> {
            int i = counter.getAndIncrement();
            int iter=iterations>0?iterations:1;
            if (i >= iter) {
                log.info("Shutting down scheduler");
                scheduler.shutdown(); // Shut down the scheduler after all iterations are done.
                return;
            }

            List<List<KeyValue>> messages = messageObject.getMessages();
            Map<String, Message> builtMessage = new HashMap<>();

            for (List<KeyValue> row : messages) {
                for (KeyValue keyValue : row) {
                    String key = keyValue.getKey();
                    String value = keyValue.getValue();
                    List<String> values = StringUtils.tokenizeString(value);

                    int index = i % values.size(); // Use modulo to cycle over the list of values
                    String msgElement = values.get(index); // Now, this will never go out of bounds
                    Message msg = new Message(key, msgElement);
                    builtMessage.put(key, msg);
                }
            }
            MqttMessage mqttMessage = new MqttMessage(messageObject.getPlacemark(), builtMessage.values().stream().toList());
            try {
                mqttService.sendMessagesToMqttBroker(mqttMessage);
                log.info("Sent message: " + mqttMessage.toString() + " to MQTT broker");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        }, 0, interval>0?interval:1, TimeUnit.SECONDS);
    }
}
