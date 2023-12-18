package it.ctinnovation.tdcKc.service.implementation.scenario;

import it.ctinnovation.tdcKc.model.scenario.entity.ScenarioEntity;
import it.ctinnovation.tdcKc.repository.ScenarioEntityRepository;
import it.ctinnovation.tdcKc.service.ScenarioEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScenarioEntityServiceImpl implements ScenarioEntityService {
    final ScenarioEntityRepository scenarioEntityRepository;

    @Override
    @Transactional(readOnly = true)
    public ScenarioEntity readScenario(Long scenarioId) {
        return scenarioEntityRepository.findById(scenarioId).orElseThrow();
    }
}
