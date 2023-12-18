package it.ctinnovation.tdcKc.repository;

import it.ctinnovation.tdcKc.model.attribute.Attribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeRepository extends JpaRepository<Attribute, Long> {
    Attribute findByChannelIdAndName(int channelId, String name);
}
