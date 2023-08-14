package it.ctinnovation.tdcKc.service;


import it.ctinnovation.tdcKc.model.scenario.entitiy.DataItem;
import it.ctinnovation.tdcKc.model.scenario.entitiy.ScenarioMessageEntity;

import java.util.List;

public interface ScenarioMessageService {
    List<ScenarioMessageEntity> read(Long scenarioFlowEntityId);
    void create (Long scenarioFlowEntityId, ScenarioMessageEntity scenarioMessageEntity);
    ScenarioMessageEntity update (ScenarioMessageEntity scenarioMessageEntity);
    void destroy(List<ScenarioMessageEntity> scenarioMessageEntityList);


    List<DataItem> readDataItems(Long scenarioMessageEntityId);
    DataItem createDataItem(Long scenarioMessageEntityId, DataItem dataItem);
    void destroyDataItem(Long scenarioMessageEntityId, List<DataItem> dataItemList);
}
