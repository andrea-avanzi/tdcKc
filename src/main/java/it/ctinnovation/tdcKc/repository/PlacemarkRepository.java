package it.ctinnovation.tdcKc.repository;

import it.ctinnovation.tdcKc.model.placemark.PlacemarkAttributeSearch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PlacemarkRepository extends
    JpaRepository<PlacemarkAttributeSearch, Long>,
    JpaSpecificationExecutor<PlacemarkAttributeSearch> {
}
