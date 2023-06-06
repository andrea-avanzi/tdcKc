package it.ctinnovation.tdcKc.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "mqtt")
public class MqttProperties {
    String url;
    String clientId;
    String defaultTopic;
}
