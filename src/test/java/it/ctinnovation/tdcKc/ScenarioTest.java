package it.ctinnovation.tdcKc;


import it.ctinnovation.tdcKc.config.properties.MqttProperties;
import it.ctinnovation.tdcKc.security.JwtAuthConverterProperties;
import org.junit.jupiter.api.Test;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@EnableConfigurationProperties({JwtAuthConverterProperties.class, MqttProperties.class})
public class ScenarioTest {

    @Autowired
    Scheduler scheduler;

    @Test
    public void testQuartz() throws SchedulerException {
        System.out.println("Quartz started processing...");
        if (!scheduler.isStarted()) {
            scheduler.start();
        }
        //JobKey jobKey = new JobKey("QuartzScenario_Job_Detail");
        //scheduler.triggerJob(jobKey);
    }
}
