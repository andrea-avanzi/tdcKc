package it.ctinnovation.tdcKc.service.implementation;

import it.ctinnovation.tdcKc.mapper.ScenarioPlacemarkMapper;
import it.ctinnovation.tdcKc.model.placemark.PlacemarkAttributeSearch;
import it.ctinnovation.tdcKc.model.scenario.dto.ScenarioPlacemarkDto;
import it.ctinnovation.tdcKc.model.scenario.entity.ScenarioEntity;
import it.ctinnovation.tdcKc.model.scenario.entity.ScenarioPlacemark;
import it.ctinnovation.tdcKc.repository.PlacemarkAttributeSearchRepository;
import it.ctinnovation.tdcKc.repository.ScenarioEntityRepository;
import it.ctinnovation.tdcKc.repository.ScenarioPlacemarkRepository;
import it.ctinnovation.tdcKc.service.ScenarioPlacemarkService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScenarioPlacemarkServiceImpl implements ScenarioPlacemarkService {

    private final ScenarioPlacemarkRepository scenarioPlacemarkRepository;
    private final ScenarioEntityRepository scenarioEntityRepository;
    private final PlacemarkAttributeSearchRepository placemarkAttributeSearchRepository;
    private final ScenarioPlacemarkMapper scenarioPlacemarkMapper;

    @Override
    @Transactional(readOnly = true)
    public List<ScenarioPlacemarkDto> read(Long scenarioId) {
        log.debug("Request to get all Questionnaires");
        return scenarioPlacemarkRepository.findByScenarioEntityId(scenarioId).stream().map(scenarioPlacemarkMapper::toDto).toList();
    }

    @Override
    @Transactional
    public ScenarioPlacemarkDto create(ScenarioPlacemarkDto scenarioPlacemarkDto) {
        log.debug("Request to create ScenarioPlacemark : {}", scenarioPlacemarkDto);
        ScenarioEntity scenarioEntity = scenarioEntityRepository.getReferenceById(scenarioPlacemarkDto.scenarioEntityId());
        PlacemarkAttributeSearch placemarkAttributeSearch = placemarkAttributeSearchRepository.getReferenceById(scenarioPlacemarkDto.placemarkAttributeSearchId());
        ScenarioPlacemark scenarioPlacemark = scenarioPlacemarkMapper.toEntity(scenarioPlacemarkDto);
        scenarioPlacemark.setScenarioEntity(scenarioEntity);
        scenarioPlacemark.setPlacemarkAttributeSearch(placemarkAttributeSearch);
        return scenarioPlacemarkMapper.toDto(scenarioPlacemarkRepository.save(scenarioPlacemark));
    }

    @Override
    @Transactional
    public ScenarioPlacemarkDto update(ScenarioPlacemarkDto scenarioPlacemarkDto) {
        log.debug("Request to update ScenarioPlacemark : {}", scenarioPlacemarkDto);
        ScenarioPlacemark scenarioPlacemark = scenarioPlacemarkRepository.getReferenceById(scenarioPlacemarkDto.id());
        scenarioPlacemark.setInterval(scenarioPlacemarkDto.interval());
        scenarioPlacemark.setIterations(scenarioPlacemarkDto.iterations());
        //scenarioPlacemark = scenarioPlacemarkMapper.partialUpdate(scenarioPlacemarkDto, scenarioPlacemark);
//        if (scenarioPlacemarkDto.scenarioEntityId() != null) {
//            ScenarioEntity scenarioEntity = scenarioEntityRepository.getReferenceById(scenarioPlacemarkDto.scenarioEntityId());
//            scenarioPlacemark.setScenarioEntity(scenarioEntity);
//        }
        if (scenarioPlacemarkDto.placemarkAttributeSearchId() != null) {
            PlacemarkAttributeSearch placemarkAttributeSearch = placemarkAttributeSearchRepository.getReferenceById(scenarioPlacemarkDto.placemarkAttributeSearchId());
            scenarioPlacemark.setPlacemarkAttributeSearch(placemarkAttributeSearch);
        }
        return scenarioPlacemarkMapper.toDto(scenarioPlacemarkRepository.save(scenarioPlacemark));
    }

    @Override
    @Transactional
    public void destroy(List<ScenarioPlacemarkDto> scenarioPlacemarkDtos) {
        List<Long> idList = scenarioPlacemarkDtos.stream().map(ScenarioPlacemarkDto::id).toList();
        scenarioPlacemarkRepository.deleteAllByIdInBatch(idList);
    }
}
