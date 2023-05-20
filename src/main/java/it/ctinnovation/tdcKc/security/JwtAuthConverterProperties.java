package it.ctinnovation.tdcKc.security;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@Configuration
@ConfigurationProperties(prefix = "jwt.auth.converter")
@Primary
public class JwtAuthConverterProperties {
    private String resourceId;
    private String principalAttribute;
}
