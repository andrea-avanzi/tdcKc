package it.ctinnovation.tdcKc.mapper;

import it.ctinnovation.tdcKc.model.scenario.dto.ScenarioPlacemarkDto;
import it.ctinnovation.tdcKc.model.scenario.entity.ScenarioPlacemark;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface ScenarioPlacemarkMapper {
    @Mapping(source = "placemarkAttributeSearchTitle", target = "placemarkAttributeSearch.title")
    @Mapping(source = "placemarkAttributeSearchId", target = "placemarkAttributeSearch.id")
    @Mapping(source = "scenarioEntityName", target = "scenarioEntity.name")
    @Mapping(source = "scenarioEntityId", target = "scenarioEntity.id")
    ScenarioPlacemark toEntity(ScenarioPlacemarkDto scenarioPlacemarkDto);

    @InheritInverseConfiguration(name = "toEntity")
    ScenarioPlacemarkDto toDto(ScenarioPlacemark scenarioPlacemark);

    @InheritConfiguration(name = "toEntity")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ScenarioPlacemark partialUpdate(ScenarioPlacemarkDto scenarioPlacemarkDto, @MappingTarget ScenarioPlacemark scenarioPlacemark);
}
