package it.ctinnovation.tdcKc.config;


import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.ArrayList;

@ConfigurationProperties(prefix = "it.ctinnovation.web.security.server.cors")
public class CorsConfigurationProperties {

    private Boolean enabled = true;
    private String[] allowedOrigin= {"http://localhost:1841"};

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String[] getAllowedOrigin() {
        return allowedOrigin;
    }

    public void setAllowedOrigin(String[] allowedOrigin) {
        this.allowedOrigin = allowedOrigin;
    }
}
