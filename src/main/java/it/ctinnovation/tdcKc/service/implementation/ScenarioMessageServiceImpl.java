package it.ctinnovation.tdcKc.service.implementation;

import it.ctinnovation.tdcKc.model.scenario.entitiy.DataItem;
import it.ctinnovation.tdcKc.model.scenario.entitiy.ScenarioFlowEntity;
import it.ctinnovation.tdcKc.model.scenario.entitiy.ScenarioMessageEntity;
import it.ctinnovation.tdcKc.repository.ScenarioMessageEntityRepository;
import it.ctinnovation.tdcKc.repository.ScenarioFlowEntityRepository;
import it.ctinnovation.tdcKc.service.ScenarioMessageService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ScenarioMessageServiceImpl implements ScenarioMessageService {

    ScenarioMessageEntityRepository scenarioMessageEntityRepository;
    ScenarioFlowEntityRepository scenarioFlowRepository;

    //region ScenarioMessageEntity
    @Override
    public List<ScenarioMessageEntity> read(Long scenarioFlowEntityId) {
        ScenarioFlowEntity scenarioFlowEntity = scenarioFlowRepository.findById(scenarioFlowEntityId).orElseThrow(NoSuchElementException::new);
        return scenarioFlowEntity.getScenarioMessages();
    }

    @Override
    public void create(Long scenarioFlowEntityId, ScenarioMessageEntity scenarioMessageEntity) {
        ScenarioFlowEntity scenarioFlowEntity = scenarioFlowRepository.findById(scenarioFlowEntityId).orElseThrow(NoSuchElementException::new);
        scenarioFlowEntity.getScenarioMessages().add(scenarioMessageEntity);
        scenarioFlowRepository.save(scenarioFlowEntity);
    }

    @Override
    public ScenarioMessageEntity update(ScenarioMessageEntity scenarioMessageEntity) {
        ScenarioMessageEntity sme = scenarioMessageEntityRepository.findById(scenarioMessageEntity.getId()).orElseThrow(NoSuchElementException::new);
        sme.setName(scenarioMessageEntity.getName());
        sme.setData(scenarioMessageEntity.getData());
        scenarioMessageEntityRepository.save(sme);
        return sme;
    }

    @Override
    public void destroy(List<ScenarioMessageEntity> scenarioMessageEntityList) {
        List<Long> ids = scenarioMessageEntityList.stream().map(ScenarioMessageEntity::getId).toList();
        scenarioMessageEntityRepository.deleteAllByIdInBatch(ids);
    }
    //endregion

    // region DataItem
    @Override
    public List<DataItem> readDataItems(Long scenarioMessageEntityId) {
        ScenarioMessageEntity scenarioMessageEntity=scenarioMessageEntityRepository.findById(scenarioMessageEntityId).orElseThrow(NoSuchElementException::new);
        return scenarioMessageEntity.getData();
    }

    @Override
    public DataItem createDataItem(Long scenarioMessageEntityId, DataItem dataItem) {
        ScenarioMessageEntity scenarioMessageEntity=scenarioMessageEntityRepository.findById(scenarioMessageEntityId).orElseThrow(NoSuchElementException::new);
        scenarioMessageEntity.getData().add(dataItem);
        scenarioMessageEntityRepository.save(scenarioMessageEntity);
        return dataItem;
    }


    @Override
    public void destroyDataItem(Long scenarioMessageEntityId, List<DataItem> dataItemList) {
        ScenarioMessageEntity scenarioMessageEntity=scenarioMessageEntityRepository.findById(scenarioMessageEntityId).orElseThrow(NoSuchElementException::new);
        scenarioMessageEntity.getData().removeAll(dataItemList);
        scenarioMessageEntityRepository.save(scenarioMessageEntity);
    }
    //endregion


}
