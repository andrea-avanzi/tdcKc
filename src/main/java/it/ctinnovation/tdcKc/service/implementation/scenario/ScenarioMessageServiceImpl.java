package it.ctinnovation.tdcKc.service.implementation.scenario;

import it.ctinnovation.tdcKc.model.scenario.model.ScenarioPlacemarkMessage;
import it.ctinnovation.tdcKc.model.scenario.entity.ScenarioKeyValue;
import it.ctinnovation.tdcKc.model.scenario.entity.ScenarioPlacemark;
import it.ctinnovation.tdcKc.repository.ScenarioKeyValueRepository;
import it.ctinnovation.tdcKc.repository.ScenarioPlacemarkRepository;
import it.ctinnovation.tdcKc.service.ScenarioMessageService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScenarioMessageServiceImpl implements ScenarioMessageService {

    final private ScenarioKeyValueRepository scenarioKeyValueRepository;
    final private ScenarioPlacemarkRepository scenarioPlacemarkRepository;

    @Override
    public void saveMessages(ScenarioPlacemarkMessage scenarioMessage) {
        scenarioKeyValueRepository.deleteByScenarioPlacemarkId(scenarioMessage.getScenarioPlacemarkId());
        scenarioMessage.getKeyValues().forEach(keyValue -> {
            log.debug("Saving message: " + keyValue.getKey() + " " + keyValue.getKey() + " " + keyValue.getValue());
            ScenarioKeyValue scenarioKeyValue = new ScenarioKeyValue();
            scenarioKeyValue.setKey(keyValue.getKey());
            scenarioKeyValue.setKeyValue(keyValue.getValue());
            ScenarioPlacemark scenarioPlacemark = scenarioPlacemarkRepository.getReferenceById(scenarioMessage.getScenarioPlacemarkId());
            scenarioKeyValue.setScenarioPlacemark(scenarioPlacemark);
            scenarioKeyValueRepository.save(scenarioKeyValue);
        });
    }
}
