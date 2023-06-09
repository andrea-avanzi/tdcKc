package it.ctinnovation.tdcKc.repository;

import it.ctinnovation.tdcKc.model.placemark.PlacemarkAttributeSearch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlacemarkAttributeSearchRepository extends JpaRepository<PlacemarkAttributeSearch, Long> {
    Optional<PlacemarkAttributeSearch> findByPublicId(String publicId);
}
