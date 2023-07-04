package it.ctinnovation.tdcKc.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    public static final String ADMIN = "admin";
    public static final String USER = "user";
    private final JwtAuthConverter jwtAuthConverter;

    public WebSecurityConfig(JwtAuthConverter jwtAuthConverter) {
        this.jwtAuthConverter = jwtAuthConverter;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable()
            .cors().and()
            .authorizeHttpRequests()
            .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
            .requestMatchers(HttpMethod.GET, "/api/**").permitAll()
            .requestMatchers(HttpMethod.GET, "/error").permitAll()
            .requestMatchers(HttpMethod.GET, "/api.js").permitAll()
            .requestMatchers(HttpMethod.GET, "/api.js/**").permitAll()
            //.requestMatchers(HttpMethod.POST, "/pocTerna/**").permitAll() // TODO togliere
            //.requestMatchers(HttpMethod.GET, "/custom/**").permitAll() // TODO togliere
            //.requestMatchers(HttpMethod.GET, "/loadPlacemarks").permitAll()
            .anyRequest().authenticated()
            .and()
            .headers().addHeaderWriter(new StaticHeadersWriter("Content-Security-Policy","frame-ancestors 'self' http://localhost:1841"))
            .frameOptions().disable();
        http.oauth2ResourceServer()
            .jwt()
            .jwtAuthenticationConverter(jwtAuthConverter);
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }
}
