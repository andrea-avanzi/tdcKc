package it.ctinnovation.tdcKc.service;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

@MessagingGateway
public interface MqttGateway {
    @Gateway(requestChannel = "mqttOutboundChannel")
    void sendToMqtt(String data);
}
