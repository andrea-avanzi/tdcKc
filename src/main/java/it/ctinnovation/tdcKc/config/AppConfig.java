package it.ctinnovation.tdcKc.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableRetry
@EnableConfigurationProperties({CorsConfigurationProperties.class})
public class AppConfig implements WebMvcConfigurer {

    @Autowired
    private CorsConfigurationProperties corsConfigurationProperties;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public ObjectMapper defaultMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper;
    }


    @Override
    public void addCorsMappings(CorsRegistry registry) {
        if (corsConfigurationProperties.getEnabled()) {
            CorsRegistration corsRegistration =
                registry.addMapping("/**")
                    .allowedMethods("*")
                    .allowedHeaders("*");
            for (String origin : corsConfigurationProperties.getAllowedOrigin()) {
                System.out.println("Aggiunta origin: "+origin);
                corsRegistration.allowedOrigins(origin);
            }
        }
    }

}
