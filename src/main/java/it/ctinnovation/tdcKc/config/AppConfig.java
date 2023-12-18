package it.ctinnovation.tdcKc.config;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import it.ctinnovation.tdcKc.config.properties.CorsConfigurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.annotation.EnableRetry;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableRetry
@EnableConfigurationProperties({CorsConfigurationProperties.class})
@ComponentScan({"ch.ralscha.extdirectspring"})
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
             corsRegistration.allowedOrigins(corsConfigurationProperties.getAllowedOrigin());
        }
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/static/**")
            .addResourceLocations("classpath:/static/");
    }

//    @Bean
//    public MultipartResolver multipartResolver() {
//        CommonsMultipartResolver commonsMultipartResolver = new CommonsMultipartResolver();
//        commonsMultipartResolver.setMaxUploadSize(52428800);
//        commonsMultipartResolver.setMaxInMemorySize(20480);
//        return commonsMultipartResolver;
//    }

}
