package it.ctinnovation.tdcKc;


import it.ctinnovation.tdcKc.config.properties.MqttProperties;
import it.ctinnovation.tdcKc.model.scenario.entitiy.ScenarioEntity;
import it.ctinnovation.tdcKc.security.JwtAuthConverterProperties;
import it.ctinnovation.tdcKc.service.implementation.ScenarioServiceImpl;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EnableConfigurationProperties({JwtAuthConverterProperties.class, MqttProperties.class})
@RequiredArgsConstructor
public class ScenarioTest {

    final ScenarioServiceImpl scenarioService;



}
