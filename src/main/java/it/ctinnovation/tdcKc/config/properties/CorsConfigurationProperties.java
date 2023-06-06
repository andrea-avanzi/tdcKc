package it.ctinnovation.tdcKc.config.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties (prefix = "it.ctinnovation.web.security.server.cors")
public class CorsConfigurationProperties {

    private Boolean enabled = true;
    private String[] allowedOrigin= {"http://localhost:1841"};
}
