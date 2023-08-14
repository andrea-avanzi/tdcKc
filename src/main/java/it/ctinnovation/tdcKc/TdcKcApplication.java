package it.ctinnovation.tdcKc;

import it.ctinnovation.tdcKc.config.properties.MqttProperties;
import it.ctinnovation.tdcKc.security.JwtAuthConverterProperties;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({JwtAuthConverterProperties.class, MqttProperties.class})
public class TdcKcApplication{


	public static void main(String[] args) {

        SpringApplication.run(TdcKcApplication.class, args);
	}



}
