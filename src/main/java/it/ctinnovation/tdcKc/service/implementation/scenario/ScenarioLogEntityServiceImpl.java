package it.ctinnovation.tdcKc.service.implementation.scenario;

import it.ctinnovation.tdcKc.model.scenario.entity.ScenarioEntity;
import it.ctinnovation.tdcKc.model.scenario.entity.ScenarioLogEntity;
import it.ctinnovation.tdcKc.repository.ScenarioLogEntityRepository;
import it.ctinnovation.tdcKc.service.ScenarioEntityService;
import it.ctinnovation.tdcKc.service.ScenarioLogEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScenarioLogEntityServiceImpl implements ScenarioLogEntityService {

    final private ScenarioLogEntityRepository scenarioLogEntityRepository;
    final private ScenarioEntityService scenarioEntityService;

    @Override
    @Transactional(readOnly = true)
    public List<ScenarioLogEntity> readAll() {
        return scenarioLogEntityRepository.findAll();
    }

    @Override
    @Transactional
    public void createLog(Long scenarioId, String cron) {
        ScenarioLogEntity slc = scenarioLogEntityRepository.findByScenarioId(scenarioId);
        if(slc == null) {
            ScenarioEntity scenarioEntity = scenarioEntityService.readScenario(scenarioId);
            ScenarioLogEntity scenarioLogEntity = new ScenarioLogEntity();
            scenarioLogEntity.setScenarioId(scenarioId);
            scenarioLogEntity.setName(scenarioEntity.getName());
            scenarioLogEntity.setCron("0 0/1 * 1/1 * ? *");
            scenarioLogEntityRepository.save(scenarioLogEntity);
        }
    }

    @Override
    @Transactional
    public void removeLog(Long scenarioId) {
        scenarioLogEntityRepository.deleteByScenarioId(scenarioId);
    }
}
