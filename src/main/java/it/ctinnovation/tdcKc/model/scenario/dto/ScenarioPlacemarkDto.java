package it.ctinnovation.tdcKc.model.scenario.dto;

import java.io.Serializable;

/**
 * DTO for {@link it.ctinnovation.tdcKc.model.scenario.entity.ScenarioPlacemark}
 */
public record ScenarioPlacemarkDto(Long id, Long scenarioEntityId, String scenarioEntityName,
                                   Long placemarkAttributeSearchId, String placemarkAttributeSearchTitle,
                                   Integer iterations, Integer interval) implements Serializable {
}
