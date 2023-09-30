package it.ctinnovation.tdcKc.mapper;

import it.ctinnovation.tdcKc.model.scenario.dto.ScenarioKeyValueDto;
import it.ctinnovation.tdcKc.model.scenario.entity.ScenarioKeyValue;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ScenarioKeyValueMapper {
    @Mapping(source = "scenarioPlacemarkId", target = "scenarioPlacemark.id")
    ScenarioKeyValue toEntity(ScenarioKeyValueDto scenarioKeyValueDto);

    @Mapping(source = "scenarioPlacemark.id", target = "scenarioPlacemarkId")
    ScenarioKeyValueDto toDto(ScenarioKeyValue scenarioKeyValue);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(source = "scenarioPlacemarkId", target = "scenarioPlacemark.id")
    ScenarioKeyValue partialUpdate(ScenarioKeyValueDto scenarioKeyValueDto, @MappingTarget ScenarioKeyValue scenarioKeyValue);
}
