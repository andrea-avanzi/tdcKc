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
