package it.ctinnovation.tdcKc.service.implementation.scenario;

import it.ctinnovation.tdcKc.model.message.KeyValue;
import it.ctinnovation.tdcKc.model.message.Message;
import it.ctinnovation.tdcKc.model.message.MessageObject;
import it.ctinnovation.tdcKc.model.message.MqttMessage;
import it.ctinnovation.tdcKc.model.scenario.model.ScenarioMessage;
import it.ctinnovation.tdcKc.model.scenario.model.ScenarioPlacemarkMessage;
import it.ctinnovation.tdcKc.model.scenario.dto.ScenarioKeyValueDto;
import it.ctinnovation.tdcKc.model.scenario.dto.ScenarioPlacemarkDto;
import it.ctinnovation.tdcKc.model.scenario.entity.ScenarioEntity;
import it.ctinnovation.tdcKc.repository.ScenarioEntityRepository;
import it.ctinnovation.tdcKc.service.*;
import it.ctinnovation.tdcKc.util.StringUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;


@Slf4j
@Service
@RequiredArgsConstructor
public class ScenarioServiceImpl implements ScenarioService {
    final ScenarioEntityRepository scenarioEntityRepository;
    final ScenarioEntityService scenarioEntityService;
    final ScenarioPlacemarkService scenarioPlacemarkService;
    final ScenarioKeyValueService scenarioKeyValueService;
    final MqttService mqttService;

    @Transactional(readOnly = true)
    public List<ScenarioEntity> read() {
        return scenarioEntityRepository.findAll();
    }

    @Transactional(readOnly = true)
    public ScenarioEntity getScenarioReference(Long id) {
        return scenarioEntityRepository.getReferenceById(id);
    }

    @Override
    public void readAndSendScenario(Long scenarioId) {
        log.debug("ScenarioId: {}", scenarioId);
        ScenarioEntity scenarioEntity = scenarioEntityService.readScenario(scenarioId);
        // Leggi i placemark associati ad uno scenario
        List<ScenarioPlacemarkDto> scenarioPlacemarkDtos = scenarioPlacemarkService.read(scenarioId);
        List<ScenarioPlacemarkMessage> scenarioMessageList = new ArrayList<>();
        // Per ogni placemark costruisci un Message fatto dai dati del placemark e dai dati associati
        ScenarioMessage scenarioMessage = new ScenarioMessage();
        scenarioMessage.setScenarioId(scenarioId);
        scenarioMessage.setIterations(scenarioEntity.getIterations());
        scenarioMessage.setInterval(scenarioEntity.getInterval());

        scenarioPlacemarkDtos.forEach(scenarioPlacemarkDto -> {
            ScenarioPlacemarkMessage scenarioPlacemarkMessage = new ScenarioPlacemarkMessage();
            scenarioPlacemarkMessage.setScenarioPlacemarkId(scenarioPlacemarkDto.id());
            scenarioPlacemarkMessage.setPublicId(scenarioPlacemarkDto.publicId());
            List<KeyValue> keyValues = new ArrayList<>();
            List<ScenarioKeyValueDto> scenarioKeyValueDtos = scenarioKeyValueService.read(scenarioPlacemarkDto.id());
            scenarioKeyValueDtos.forEach(scenarioKeyValueDto -> {
                KeyValue keyValue = new KeyValue();
                keyValue.setKey(scenarioKeyValueDto.key());
                keyValue.setValue(scenarioKeyValueDto.keyValue());
                keyValues.add(keyValue);
            });
            scenarioPlacemarkMessage.setKeyValues(keyValues);
            scenarioMessageList.add(scenarioPlacemarkMessage);
        });
        scenarioMessage.setScenarioPlacemarkMessages(scenarioMessageList);
        // Invia i messaggi
        sendScenarioMessages(scenarioMessage);
    }

    @Async
    public void sendScenarioMessages(ScenarioMessage scenarioMessage) {
        int iterations = scenarioMessage.getIterations();
        int interval = scenarioMessage.getInterval();

        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        AtomicInteger counter = new AtomicInteger(0);

        scheduler.scheduleAtFixedRate(() -> {
            int i = counter.getAndIncrement();
            int iter = iterations > 0 ? iterations : 1;
            if (i >= iter) {
                log.info("Shutting down scheduler");
                scheduler.shutdown(); // Shut down the scheduler after all iterations are done.
                return;
            }
            scenarioMessage.getScenarioPlacemarkMessages().forEach(messageObject -> {
                String placemarkPuplicId = messageObject.getPublicId();
                List<KeyValue> keyValuesList = messageObject.getKeyValues();
                Map<String, Message> builtMessage = new HashMap<>();
                for (KeyValue keyValue : keyValuesList) {
                    String key = keyValue.getKey();
                    String value = keyValue.getValue();
                    List<String> values = StringUtils.tokenizeString(value);
                    int index = i % values.size(); // Use modulo to cycle over the list of values
                    String msgElement = values.get(index); // Now, this will never go out of bounds
                    Message msg = new Message(key, msgElement);
                    builtMessage.put(key, msg);
                }
                MqttMessage mqttMessage = new MqttMessage(placemarkPuplicId, builtMessage.values().stream().toList());
                try {
                    mqttService.sendMessagesToMqttBroker(mqttMessage);
                    log.info("Sent message: " + mqttMessage.toString() + " to MQTT broker");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            });
        }, 0, interval > 0 ? interval : 1, TimeUnit.SECONDS);
    }


    @Transactional
    public ScenarioEntity create(ScenarioEntity companyRole) {
        return scenarioEntityRepository.save(companyRole);
    }

    @Transactional
    public ScenarioEntity update(ScenarioEntity scenarioEntity) {
        ScenarioEntity scenario = scenarioEntityRepository.findById(scenarioEntity.getId()).orElseThrow(NoSuchElementException::new);
        if (scenarioEntity.getName() != null)
            scenario.setName(scenarioEntity.getName());
        if (scenarioEntity.getDescription() != null)
            scenario.setDescription(scenarioEntity.getDescription());
        if (scenarioEntity.getInterval() != null)
            scenario.setInterval(scenarioEntity.getInterval());
        if (scenarioEntity.getIterations() != null)
            scenario.setIterations(scenarioEntity.getIterations());
        return scenarioEntityRepository.save(scenario);
    }

    @Transactional
    public void destroy(List<ScenarioEntity> scenarioEntities) {
        List<Long> ids = scenarioEntities.stream().map(ScenarioEntity::getId).toList();
        scenarioEntityRepository.deleteAllByIdInBatch(ids);
    }
}
