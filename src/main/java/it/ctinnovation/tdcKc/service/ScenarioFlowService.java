package it.ctinnovation.tdcKc.service;

import it.ctinnovation.tdcKc.model.scenario.entitiy.ScenarioEntity;
import it.ctinnovation.tdcKc.model.scenario.entitiy.ScenarioFlowEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ScenarioFlowService {
    ScenarioFlowEntity getScenario(Long id);
    ScenarioFlowEntity getScenarioReference(Long id);
    List<ScenarioFlowEntity> read(Long scenarioEntityId);
    ScenarioFlowEntity create (ScenarioFlowEntity scenarioFlowEntity);
    ScenarioFlowEntity update (ScenarioFlowEntity scenarioFlowEntity);
    void destroy(List<ScenarioFlowEntity> scenarioFlowEntityList);

}
