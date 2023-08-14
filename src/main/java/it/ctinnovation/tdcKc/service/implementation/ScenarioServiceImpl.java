package it.ctinnovation.tdcKc.service.implementation;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.ctinnovation.tdcKc.model.scenario.entitiy.ScenarioEntity;
import it.ctinnovation.tdcKc.model.scenario.entitiy.ScenarioMessageEntity;
import it.ctinnovation.tdcKc.repository.ScenarioEntityRepository;
import it.ctinnovation.tdcKc.repository.ScenarioMessageEntityRepository;
import it.ctinnovation.tdcKc.service.ScenarioService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;


@Slf4j
@Service
@RequiredArgsConstructor
public class ScenarioServiceImpl implements ScenarioService {
    final ScenarioMessageEntityRepository scenarioMessageRepository;
    final ScenarioEntityRepository scenarioEntityRepository;

    @Override
    public void saveScenario(MultipartFile file) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        //List<ScenarioMessage> messages = new ArrayList<>();
        List<ScenarioMessageEntity> messages = new ArrayList<>();

        try (InputStream inputStream = file.getInputStream()) {
            // Read the entire content as a byte array
            byte[] contentBytes = inputStream.readAllBytes();
            // Convert the byte array to a String
            String contentWithoutCommas = new String(contentBytes, StandardCharsets.UTF_8);
            //JsonNode jsonNode = objectMapper.readTree(content);
            JsonNode jsonNode = objectMapper.readTree(contentWithoutCommas);
            if (jsonNode.isArray()) {
                // Unmarshal each object in the JSON array into a Message object
                for (JsonNode node : jsonNode) {
                    ScenarioMessageEntity message = objectMapper.treeToValue(node, ScenarioMessageEntity.class);
                    messages.add(message);
                    log.info(message.toString());
                }
            }
        } catch (IOException e) {
            log.error("Error reading file", e);
        }
        scenarioMessageRepository.deleteAll();
        scenarioMessageRepository.saveAll(messages);
        log.info("Scenario saved");
    }

    @Transactional(readOnly = true)
    public List<ScenarioEntity> read() {
        return scenarioEntityRepository.findAll();
    }

    @Transactional
    public ScenarioEntity getScenarioReference(Long id) {
        return scenarioEntityRepository.getReferenceById(id);
    }

    @Transactional
    public ScenarioEntity create(ScenarioEntity companyRole) {
        return scenarioEntityRepository.save(companyRole);
    }

    @Transactional
    public ScenarioEntity update(ScenarioEntity scenarioEntity) {
        ScenarioEntity scenario = scenarioEntityRepository.findById(scenarioEntity.getId()).orElseThrow(NoSuchElementException::new);
        scenario.setName(scenarioEntity.getName());
        return scenarioEntityRepository.save(scenario);
    }

    @Transactional
    public void destroy(List<ScenarioEntity> scenarioEntities) {
        List<Long> ids = scenarioEntities.stream().map(ScenarioEntity::getId).toList();
        scenarioEntityRepository.deleteAllByIdInBatch(ids);
    }
}
