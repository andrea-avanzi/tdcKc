package it.ctinnovation.tdcKc.mapper;

import it.ctinnovation.tdcKc.model.placemark.PlacemarkAttributeSearch;
import it.ctinnovation.tdcKc.model.scenario.dto.ScenarioPlacemarkDto;
import it.ctinnovation.tdcKc.model.scenario.entity.ScenarioEntity;
import it.ctinnovation.tdcKc.model.scenario.entity.ScenarioPlacemark;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-12-18T11:11:13+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.3 (Eclipse Adoptium)"
)
@Component
public class ScenarioPlacemarkMapperImpl implements ScenarioPlacemarkMapper {

    @Override
    public ScenarioPlacemark toEntity(ScenarioPlacemarkDto scenarioPlacemarkDto) {
        if ( scenarioPlacemarkDto == null ) {
            return null;
        }

        ScenarioPlacemark scenarioPlacemark = new ScenarioPlacemark();

        scenarioPlacemark.setPlacemarkAttributeSearch( scenarioPlacemarkDtoToPlacemarkAttributeSearch( scenarioPlacemarkDto ) );
        scenarioPlacemark.setScenarioEntity( scenarioPlacemarkDtoToScenarioEntity( scenarioPlacemarkDto ) );
        scenarioPlacemark.setId( scenarioPlacemarkDto.id() );

        return scenarioPlacemark;
    }

    @Override
    public ScenarioPlacemarkDto toDto(ScenarioPlacemark scenarioPlacemark) {
        if ( scenarioPlacemark == null ) {
            return null;
        }

        String placemarkAttributeSearchTitle = null;
        Long placemarkAttributeSearchId = null;
        String publicId = null;
        String scenarioEntityName = null;
        Long scenarioEntityId = null;
        Long id = null;

        placemarkAttributeSearchTitle = scenarioPlacemarkPlacemarkAttributeSearchTitle( scenarioPlacemark );
        placemarkAttributeSearchId = scenarioPlacemarkPlacemarkAttributeSearchId( scenarioPlacemark );
        publicId = scenarioPlacemarkPlacemarkAttributeSearchPublicId( scenarioPlacemark );
        scenarioEntityName = scenarioPlacemarkScenarioEntityName( scenarioPlacemark );
        scenarioEntityId = scenarioPlacemarkScenarioEntityId( scenarioPlacemark );
        id = scenarioPlacemark.getId();

        ScenarioPlacemarkDto scenarioPlacemarkDto = new ScenarioPlacemarkDto( id, publicId, scenarioEntityId, scenarioEntityName, placemarkAttributeSearchId, placemarkAttributeSearchTitle );

        return scenarioPlacemarkDto;
    }

    @Override
    public ScenarioPlacemark partialUpdate(ScenarioPlacemarkDto scenarioPlacemarkDto, ScenarioPlacemark scenarioPlacemark) {
        if ( scenarioPlacemarkDto == null ) {
            return scenarioPlacemark;
        }

        if ( scenarioPlacemark.getPlacemarkAttributeSearch() == null ) {
            scenarioPlacemark.setPlacemarkAttributeSearch( new PlacemarkAttributeSearch() );
        }
        scenarioPlacemarkDtoToPlacemarkAttributeSearch1( scenarioPlacemarkDto, scenarioPlacemark.getPlacemarkAttributeSearch() );
        if ( scenarioPlacemark.getScenarioEntity() == null ) {
            scenarioPlacemark.setScenarioEntity( new ScenarioEntity() );
        }
        scenarioPlacemarkDtoToScenarioEntity1( scenarioPlacemarkDto, scenarioPlacemark.getScenarioEntity() );
        if ( scenarioPlacemarkDto.id() != null ) {
            scenarioPlacemark.setId( scenarioPlacemarkDto.id() );
        }

        return scenarioPlacemark;
    }

    protected PlacemarkAttributeSearch scenarioPlacemarkDtoToPlacemarkAttributeSearch(ScenarioPlacemarkDto scenarioPlacemarkDto) {
        if ( scenarioPlacemarkDto == null ) {
            return null;
        }

        PlacemarkAttributeSearch placemarkAttributeSearch = new PlacemarkAttributeSearch();

        placemarkAttributeSearch.setTitle( scenarioPlacemarkDto.placemarkAttributeSearchTitle() );
        placemarkAttributeSearch.setId( scenarioPlacemarkDto.placemarkAttributeSearchId() );
        placemarkAttributeSearch.setPublicId( scenarioPlacemarkDto.publicId() );

        return placemarkAttributeSearch;
    }

    protected ScenarioEntity scenarioPlacemarkDtoToScenarioEntity(ScenarioPlacemarkDto scenarioPlacemarkDto) {
        if ( scenarioPlacemarkDto == null ) {
            return null;
        }

        ScenarioEntity scenarioEntity = new ScenarioEntity();

        scenarioEntity.setName( scenarioPlacemarkDto.scenarioEntityName() );
        scenarioEntity.setId( scenarioPlacemarkDto.scenarioEntityId() );

        return scenarioEntity;
    }

    private String scenarioPlacemarkPlacemarkAttributeSearchTitle(ScenarioPlacemark scenarioPlacemark) {
        if ( scenarioPlacemark == null ) {
            return null;
        }
        PlacemarkAttributeSearch placemarkAttributeSearch = scenarioPlacemark.getPlacemarkAttributeSearch();
        if ( placemarkAttributeSearch == null ) {
            return null;
        }
        String title = placemarkAttributeSearch.getTitle();
        if ( title == null ) {
            return null;
        }
        return title;
    }

    private Long scenarioPlacemarkPlacemarkAttributeSearchId(ScenarioPlacemark scenarioPlacemark) {
        if ( scenarioPlacemark == null ) {
            return null;
        }
        PlacemarkAttributeSearch placemarkAttributeSearch = scenarioPlacemark.getPlacemarkAttributeSearch();
        if ( placemarkAttributeSearch == null ) {
            return null;
        }
        Long id = placemarkAttributeSearch.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String scenarioPlacemarkPlacemarkAttributeSearchPublicId(ScenarioPlacemark scenarioPlacemark) {
        if ( scenarioPlacemark == null ) {
            return null;
        }
        PlacemarkAttributeSearch placemarkAttributeSearch = scenarioPlacemark.getPlacemarkAttributeSearch();
        if ( placemarkAttributeSearch == null ) {
            return null;
        }
        String publicId = placemarkAttributeSearch.getPublicId();
        if ( publicId == null ) {
            return null;
        }
        return publicId;
    }

    private String scenarioPlacemarkScenarioEntityName(ScenarioPlacemark scenarioPlacemark) {
        if ( scenarioPlacemark == null ) {
            return null;
        }
        ScenarioEntity scenarioEntity = scenarioPlacemark.getScenarioEntity();
        if ( scenarioEntity == null ) {
            return null;
        }
        String name = scenarioEntity.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }

    private Long scenarioPlacemarkScenarioEntityId(ScenarioPlacemark scenarioPlacemark) {
        if ( scenarioPlacemark == null ) {
            return null;
        }
        ScenarioEntity scenarioEntity = scenarioPlacemark.getScenarioEntity();
        if ( scenarioEntity == null ) {
            return null;
        }
        Long id = scenarioEntity.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected void scenarioPlacemarkDtoToPlacemarkAttributeSearch1(ScenarioPlacemarkDto scenarioPlacemarkDto, PlacemarkAttributeSearch mappingTarget) {
        if ( scenarioPlacemarkDto == null ) {
            return;
        }

        if ( scenarioPlacemarkDto.placemarkAttributeSearchTitle() != null ) {
            mappingTarget.setTitle( scenarioPlacemarkDto.placemarkAttributeSearchTitle() );
        }
        if ( scenarioPlacemarkDto.placemarkAttributeSearchId() != null ) {
            mappingTarget.setId( scenarioPlacemarkDto.placemarkAttributeSearchId() );
        }
        if ( scenarioPlacemarkDto.publicId() != null ) {
            mappingTarget.setPublicId( scenarioPlacemarkDto.publicId() );
        }
    }

    protected void scenarioPlacemarkDtoToScenarioEntity1(ScenarioPlacemarkDto scenarioPlacemarkDto, ScenarioEntity mappingTarget) {
        if ( scenarioPlacemarkDto == null ) {
            return;
        }

        if ( scenarioPlacemarkDto.scenarioEntityName() != null ) {
            mappingTarget.setName( scenarioPlacemarkDto.scenarioEntityName() );
        }
        if ( scenarioPlacemarkDto.scenarioEntityId() != null ) {
            mappingTarget.setId( scenarioPlacemarkDto.scenarioEntityId() );
        }
    }
}
