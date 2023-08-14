package it.ctinnovation.tdcKc.service;

import it.ctinnovation.tdcKc.model.scenario.entitiy.ScenarioEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface ScenarioService {
    void saveScenario(MultipartFile file) throws IOException;
    List<ScenarioEntity> read();
    ScenarioEntity create (ScenarioEntity companyRole);
    ScenarioEntity update (ScenarioEntity scenarioEntity);
    void destroy(List<ScenarioEntity> companyRoles);

    ScenarioEntity getScenarioReference(Long id);

}
