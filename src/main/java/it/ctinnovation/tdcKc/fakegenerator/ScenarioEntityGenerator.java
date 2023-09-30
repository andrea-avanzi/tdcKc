package it.ctinnovation.tdcKc.fakegenerator;

import it.ctinnovation.tdcKc.model.scenario.entity.ScenarioEntity;
import it.ctinnovation.tdcKc.repository.ScenarioEntityRepository;
import lombok.extern.slf4j.Slf4j;
import net.datafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Component
@Transactional
@Slf4j
@Order(value = 10)
public class ScenarioEntityGenerator {

    @Bean
    public CommandLineRunner loadScenarioEntityData(
        ScenarioEntityRepository scenarioEntityRepository) {
        return args -> {
            final int NUMBERSCENARIOENTITYTOGENERATE = 100;
            if (scenarioEntityRepository.count() != 0L) {
                log.info("scenarioEntity already loaded");
                return;
            }
            Faker faker = new Faker(Locale.ITALY);
            log.info("Generating demo data for ScenarioEntity...");

            List<ScenarioEntity> scenarioEntityList=new ArrayList<>();
            for (int i = 0; i < NUMBERSCENARIOENTITYTOGENERATE; i++) {
                ScenarioEntity scenarioEntity = new ScenarioEntity();
                scenarioEntity.setName(faker.animal().name());
                scenarioEntity.setDescription(faker.animal().scientificName());
                scenarioEntityList.add(scenarioEntity);
            }
            scenarioEntityRepository.saveAll(scenarioEntityList);
            log.info("... generated {} ScenarioEntity entities...", NUMBERSCENARIOENTITYTOGENERATE);
        };
    }
}
