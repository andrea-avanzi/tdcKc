package it.ctinnovation.tdcKc;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.ctinnovation.tdcKc.config.properties.MqttProperties;
import it.ctinnovation.tdcKc.model.KeyCloakResponse;
import it.ctinnovation.tdcKc.model.message.Message;
import it.ctinnovation.tdcKc.model.message.MqttMessage;
import it.ctinnovation.tdcKc.model.pocterna.AnomaliaAperta;
import it.ctinnovation.tdcKc.repository.pocterna.AnomalieAperteRepository;
import it.ctinnovation.tdcKc.security.JwtAuthConverterProperties;
import it.ctinnovation.tdcKc.service.AuthorizationService;
import it.ctinnovation.tdcKc.service.MqttService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@EnableConfigurationProperties({JwtAuthConverterProperties.class, MqttProperties.class})
class TdcKcApplicationTests {

    @Autowired
    AuthorizationService authorizationService;

    @Autowired
    MqttService mqttService;

    @Autowired
    AnomalieAperteRepository anomalieAperteRepository;


    @Test
	void contextLoads() {
	}

    //@Test
    void testLogin() throws JsonProcessingException {
        KeyCloakResponse token=authorizationService.login("user1","password");
        printOutTokens(token);
    }

    //@Test
    void testRefresh() throws JsonProcessingException, InterruptedException {
        KeyCloakResponse token = authorizationService.login("user1", "password");
        printOutTokens(token);
        Thread.sleep(5000);
        KeyCloakResponse newToken=authorizationService.renewJwt(token.refresh_token());
        printOutTokens(newToken);
    }

    //@Test
    public void send() throws Exception {
        Message m = new Message("Riempimento", "50");
        List<Message> messageList = new ArrayList<>();
        messageList.add(m);
        MqttMessage mqttMessage = new MqttMessage("TRSN-CAI", messageList);
        mqttService.sendMessageToMqttBroker(mqttMessage);
    }

    @Test
    public void testAnomalie(){
        Pageable pageable = PageRequest.of(0,10);
        Specification<AnomaliaAperta> spec = (root, query, cb) -> cb.equal(root.get("descrizioneAnomalia"), "Bosco");
        Page<AnomaliaAperta> page = anomalieAperteRepository.findAll(spec, pageable);
    }

    private static void printOutTokens(KeyCloakResponse token) {
        System.out.println("AccessToken: "+ token.access_token());
        System.out.println("RefreshToken: "+ token.refresh_token());
    }
}
