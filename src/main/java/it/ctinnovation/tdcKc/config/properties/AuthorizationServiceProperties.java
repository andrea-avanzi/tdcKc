package it.ctinnovation.tdcKc.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "it.ctinnovation.authorizationserver")
public class AuthorizationServiceProperties {
    private String jwtServer;
    private String clientId;
    private String passwordGrantType;
    private String refreshToken;
}
