package it.ctinnovation.tdcKc.mapper;

import it.ctinnovation.tdcKc.model.scenario.dto.ScenarioKeyValueDto;
import it.ctinnovation.tdcKc.model.scenario.entity.ScenarioKeyValue;
import it.ctinnovation.tdcKc.model.scenario.entity.ScenarioPlacemark;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-02-27T16:14:18+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class ScenarioKeyValueMapperImpl implements ScenarioKeyValueMapper {

    @Override
    public ScenarioKeyValue toEntity(ScenarioKeyValueDto scenarioKeyValueDto) {
        if ( scenarioKeyValueDto == null ) {
            return null;
        }

        ScenarioKeyValue scenarioKeyValue = new ScenarioKeyValue();

        scenarioKeyValue.setScenarioPlacemark( scenarioKeyValueDtoToScenarioPlacemark( scenarioKeyValueDto ) );
        scenarioKeyValue.setId( scenarioKeyValueDto.id() );
        scenarioKeyValue.setKey( scenarioKeyValueDto.key() );
        scenarioKeyValue.setKeyName( scenarioKeyValueDto.keyName() );
        scenarioKeyValue.setKeyValue( scenarioKeyValueDto.keyValue() );

        return scenarioKeyValue;
    }

    @Override
    public ScenarioKeyValueDto toDto(ScenarioKeyValue scenarioKeyValue) {
        if ( scenarioKeyValue == null ) {
            return null;
        }

        Long scenarioPlacemarkId = null;
        Long id = null;
        String key = null;
        String keyName = null;
        String keyValue = null;

        scenarioPlacemarkId = scenarioKeyValueScenarioPlacemarkId( scenarioKeyValue );
        id = scenarioKeyValue.getId();
        key = scenarioKeyValue.getKey();
        keyName = scenarioKeyValue.getKeyName();
        keyValue = scenarioKeyValue.getKeyValue();

        ScenarioKeyValueDto scenarioKeyValueDto = new ScenarioKeyValueDto( id, scenarioPlacemarkId, key, keyName, keyValue );

        return scenarioKeyValueDto;
    }

    @Override
    public ScenarioKeyValue partialUpdate(ScenarioKeyValueDto scenarioKeyValueDto, ScenarioKeyValue scenarioKeyValue) {
        if ( scenarioKeyValueDto == null ) {
            return scenarioKeyValue;
        }

        if ( scenarioKeyValue.getScenarioPlacemark() == null ) {
            scenarioKeyValue.setScenarioPlacemark( new ScenarioPlacemark() );
        }
        scenarioKeyValueDtoToScenarioPlacemark1( scenarioKeyValueDto, scenarioKeyValue.getScenarioPlacemark() );
        if ( scenarioKeyValueDto.id() != null ) {
            scenarioKeyValue.setId( scenarioKeyValueDto.id() );
        }
        if ( scenarioKeyValueDto.key() != null ) {
            scenarioKeyValue.setKey( scenarioKeyValueDto.key() );
        }
        if ( scenarioKeyValueDto.keyName() != null ) {
            scenarioKeyValue.setKeyName( scenarioKeyValueDto.keyName() );
        }
        if ( scenarioKeyValueDto.keyValue() != null ) {
            scenarioKeyValue.setKeyValue( scenarioKeyValueDto.keyValue() );
        }

        return scenarioKeyValue;
    }

    protected ScenarioPlacemark scenarioKeyValueDtoToScenarioPlacemark(ScenarioKeyValueDto scenarioKeyValueDto) {
        if ( scenarioKeyValueDto == null ) {
            return null;
        }

        ScenarioPlacemark scenarioPlacemark = new ScenarioPlacemark();

        scenarioPlacemark.setId( scenarioKeyValueDto.scenarioPlacemarkId() );

        return scenarioPlacemark;
    }

    private Long scenarioKeyValueScenarioPlacemarkId(ScenarioKeyValue scenarioKeyValue) {
        if ( scenarioKeyValue == null ) {
            return null;
        }
        ScenarioPlacemark scenarioPlacemark = scenarioKeyValue.getScenarioPlacemark();
        if ( scenarioPlacemark == null ) {
            return null;
        }
        Long id = scenarioPlacemark.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected void scenarioKeyValueDtoToScenarioPlacemark1(ScenarioKeyValueDto scenarioKeyValueDto, ScenarioPlacemark mappingTarget) {
        if ( scenarioKeyValueDto == null ) {
            return;
        }

        if ( scenarioKeyValueDto.scenarioPlacemarkId() != null ) {
            mappingTarget.setId( scenarioKeyValueDto.scenarioPlacemarkId() );
        }
    }
}
