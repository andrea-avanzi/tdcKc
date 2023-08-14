package it.ctinnovation.tdcKc.service.implementation;

import it.ctinnovation.tdcKc.model.scenario.entitiy.ScenarioEntity;
import it.ctinnovation.tdcKc.model.scenario.entitiy.ScenarioFlowEntity;
import it.ctinnovation.tdcKc.repository.ScenarioEntityRepository;
import it.ctinnovation.tdcKc.repository.ScenarioFlowEntityRepository;
import it.ctinnovation.tdcKc.service.ScenarioFlowService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Slf4j
@Service
@RequiredArgsConstructor
public class ScenarioFlowServiceImpl implements ScenarioFlowService {

    final ScenarioEntityRepository scenarioEntityRepository;
    final ScenarioFlowEntityRepository scenerioFlowEntityRepository;


    @Transactional(readOnly = true)
    public List<ScenarioFlowEntity> read(Long scenarioEntityId) {
        ScenarioEntity scenarioEntity = scenarioEntityRepository.findById(scenarioEntityId).orElseThrow(NoSuchElementException::new);
        return scenarioEntity.getScenarioFlows();
    }

    @Transactional
    public ScenarioFlowEntity getScenario(Long id) {
        return scenerioFlowEntityRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Transactional
    public ScenarioFlowEntity getScenarioReference(Long id) {
        return scenerioFlowEntityRepository.getReferenceById(id);
    }

    @Transactional
    public ScenarioFlowEntity create (ScenarioFlowEntity scenarioFlowEntity){
        return scenerioFlowEntityRepository.save(scenarioFlowEntity);
    }

    @Transactional
    public ScenarioFlowEntity update (ScenarioFlowEntity scenarioFlowEntity){
        ScenarioFlowEntity cr = scenerioFlowEntityRepository.findById(scenarioFlowEntity.getId()).orElseThrow(NoSuchElementException::new);
        cr.setPlacemerkId(scenarioFlowEntity.getScenario().getName());
        return scenerioFlowEntityRepository.save(cr);
    }

    @Transactional
    public void destroy(List<ScenarioFlowEntity> scenarioFlowEntities) {
        List<Long> ids = scenarioFlowEntities.stream().map(ScenarioFlowEntity::getId).toList();
        scenerioFlowEntityRepository.deleteAllByIdInBatch(ids);
    }
}
