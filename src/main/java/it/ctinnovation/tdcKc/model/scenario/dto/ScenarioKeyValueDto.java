package it.ctinnovation.tdcKc.model.scenario.dto;

import java.io.Serializable;

/**
 * DTO for {@link it.ctinnovation.tdcKc.model.scenario.entity.ScenarioKeyValue}
 */
public record ScenarioKeyValueDto(Long id, Long scenarioPlacemarkId, String key, String keyName,
                                  String keyValue) implements Serializable {
}
