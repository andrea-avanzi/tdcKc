package it.ctinnovation.tdcKc.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

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
        http.csrf()
            .ignoringRequestMatchers("/api/**", "/api.js", "/router", "/router/**");
        http.cors().and()
            .authorizeHttpRequests()
            .requestMatchers(HttpMethod.OPTIONS,"/**").permitAll()
            .requestMatchers(HttpMethod.GET, "/api/**").permitAll()
            //.requestMatchers(HttpMethod.POST, "/router","/router/**").permitAll()
            .requestMatchers(HttpMethod.GET, "/api.js").permitAll()
            .requestMatchers(HttpMethod.POST, "/login","/renewToken").permitAll()
            .requestMatchers(HttpMethod.GET, "/error","/test/anonymous", "/test/anonymous/**").permitAll()
            .requestMatchers(HttpMethod.GET, "/test/admin", "/test/admin/**").hasRole(ADMIN)
            .requestMatchers(HttpMethod.GET, "/test/user").hasAnyRole(ADMIN, USER)

            .anyRequest().authenticated();
        http.oauth2ResourceServer()
            .jwt()
            .jwtAuthenticationConverter(jwtAuthConverter);
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        return http.build();
    }
}
