package it.ctinnovation.tdcKc.service.implementation;

import it.ctinnovation.tdcKc.model.message.Message;
import it.ctinnovation.tdcKc.model.message.MqttMessage;
import it.ctinnovation.tdcKc.model.scenario.entitiy.ScenarioMessageEntity;
import it.ctinnovation.tdcKc.repository.ScenarioMessageEntityRepository;
import it.ctinnovation.tdcKc.service.MqttService;
import it.ctinnovation.tdcKc.service.PlacemarkSendingService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PlacemarkSendingServiceImpl implements PlacemarkSendingService {
    private final ScenarioMessageEntityRepository scenarioMessageRepository;
    private final MqttService mqttService;
    private volatile Thread messageSendingThread; // Reference to the message sending thread


    public PlacemarkSendingServiceImpl(ScenarioMessageEntityRepository scenarioMessageRepository, MqttService mqttService) {
        this.scenarioMessageRepository = scenarioMessageRepository;
        this.mqttService = mqttService;
        this.messageSendingThread = null;

    }

    public void startSendingMessages(String placemark) {
        if (messageSendingThread != null && messageSendingThread.isAlive()) {
            // A message sending loop is already running
            return;
        }
        List<ScenarioMessageEntity> records = scenarioMessageRepository.findAllByName(placemark);
        messageSendingThread = new Thread(() -> {
            while(!Thread.currentThread().isInterrupted()) {
                for (ScenarioMessageEntity record : records) {
                    // Check if the thread has been interrupted
                    if (Thread.currentThread().isInterrupted()) {
                        break;
                    }

                    // Perform your operation with the record
                    log.info("Sending message for record: " + record);

                    // Send the MQTT message
                    try {
                        log.info("Sending message to MQTT broker: " + record.getName() + " " + record.getData());
                        List<Message> messages = new ArrayList<>();
                        record.getData().stream().forEach(message -> messages.add(new Message(message.getKey(), message.getValue())));
                        MqttMessage mqttMessage = new MqttMessage(record.getName(), messages);
                        mqttService.sendMessageToMqttBroker(mqttMessage);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    // Sleep for 1 second
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        // Thread.sleep() may throw InterruptedException when interrupted
                        Thread.currentThread().interrupt(); // Reset the interrupted flag
                        break;
                    }
                }
            }
        });
        messageSendingThread.start();
    }

    public void stopSendingMessages() {
        if (messageSendingThread != null && messageSendingThread.isAlive()) {
            messageSendingThread.interrupt(); // Interrupt the running thread
            messageSendingThread = null; // Reset the thread reference
        }
        log.info("Stopped sending messages");
    }
}
