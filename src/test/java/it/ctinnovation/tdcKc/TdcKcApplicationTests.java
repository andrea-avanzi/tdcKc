package it.ctinnovation.tdcKc;

import com.fasterxml.jackson.core.JsonProcessingException;
import it.ctinnovation.tdcKc.model.KeyCloakResponse;
import it.ctinnovation.tdcKc.service.AuthorizationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootTest
class TdcKcApplicationTests {

    @Autowired
    AuthorizationService authorizationService;


    @Test
	void contextLoads() {
	}

    @Test
    void testLogin() throws JsonProcessingException {
        KeyCloakResponse token=authorizationService.login("user1","password");
        printOutTokens(token);
    }

    @Test
    void testRefresh() throws JsonProcessingException, InterruptedException {
        KeyCloakResponse token = authorizationService.login("user1", "password");
        printOutTokens(token);
        Thread.sleep(5000);
        KeyCloakResponse newToken=authorizationService.renewJwt(token.refresh_token());
        printOutTokens(newToken);
    }

    private static void printOutTokens(KeyCloakResponse token) {
        System.out.println("AccessToken: "+ token.access_token());
        System.out.println("RefreshToken: "+ token.refresh_token());
    }

}
