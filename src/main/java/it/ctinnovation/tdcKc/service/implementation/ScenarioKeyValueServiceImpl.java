package it.ctinnovation.tdcKc.service.implementation;

import it.ctinnovation.tdcKc.mapper.ScenarioKeyValueMapper;
import it.ctinnovation.tdcKc.model.scenario.dto.ScenarioKeyValueDto;
import it.ctinnovation.tdcKc.model.scenario.entity.ScenarioKeyValue;
import it.ctinnovation.tdcKc.model.scenario.entity.ScenarioPlacemark;
import it.ctinnovation.tdcKc.repository.ScenarioKeyValueRepository;
import it.ctinnovation.tdcKc.repository.ScenarioPlacemarkRepository;
import it.ctinnovation.tdcKc.service.ScenarioKeyValueService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScenarioKeyValueServiceImpl implements ScenarioKeyValueService {

    private final ScenarioKeyValueRepository scenarioKeyValueRepository;
    private final ScenarioPlacemarkRepository scenarioPlacemarkRepository;
    private final ScenarioKeyValueMapper scenarioKeyValueMapper;

    @Override
    public List<ScenarioKeyValueDto> read() {
        log.debug("Request to get all ScenarioKeyValue");
        return scenarioKeyValueRepository.findAll().stream().map(scenarioKeyValueMapper::toDto).toList();
    }

    @Override
    public ScenarioKeyValueDto create(ScenarioKeyValueDto scenarioKeyValueDto) {
        log.debug("Request to update ScenarioKeyValue : {}", scenarioKeyValueDto);
        ScenarioPlacemark scenarioPlacemark = scenarioPlacemarkRepository.getReferenceById(scenarioKeyValueDto.scenarioPlacemarkId());
        ScenarioKeyValue scenarioKeyValue = scenarioKeyValueMapper.toEntity(scenarioKeyValueDto);
        scenarioKeyValue.setScenarioPlacemark(scenarioPlacemark);
        scenarioKeyValue = scenarioKeyValueRepository.save(scenarioKeyValue);
        return scenarioKeyValueMapper.toDto(scenarioKeyValue);
    }

    @Override
    public ScenarioKeyValueDto update(ScenarioKeyValueDto scenarioKeyValueDto) {
        log.debug("Request to update ScenarioKeyValue : {}", scenarioKeyValueDto);
        ScenarioKeyValue scenarioKeyValue = scenarioKeyValueRepository.getReferenceById(scenarioKeyValueDto.id());
        scenarioKeyValue = scenarioKeyValueMapper.partialUpdate(scenarioKeyValueDto, scenarioKeyValue);
        if(scenarioKeyValueDto.id() != null) {
            ScenarioPlacemark scenarioPlacemark = scenarioPlacemarkRepository.getReferenceById(scenarioKeyValueDto.scenarioPlacemarkId());
            scenarioKeyValue.setScenarioPlacemark(scenarioPlacemark);
        }
        scenarioKeyValue = scenarioKeyValueRepository.save(scenarioKeyValue);
        return scenarioKeyValueMapper.toDto(scenarioKeyValue);
    }

    @Override
    public void destroy(List<ScenarioKeyValueDto> scenarioKeyValueDtos) {
        List<Long> idList = scenarioKeyValueDtos.stream().map(ScenarioKeyValueDto::id).toList();
        scenarioKeyValueRepository.deleteAllByIdInBatch(idList);
    }
}
