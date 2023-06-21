package it.ctinnovation.tdcKc.repository.pocterna;

import it.ctinnovation.tdcKc.model.pocterna.AnomaliaAperta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnomalieAperteRepository extends
    JpaRepository<AnomaliaAperta, Long> ,
    JpaSpecificationExecutor<AnomaliaAperta>
{

    @Modifying
    @Query(nativeQuery = true, value = "ALTER SEQUENCE anomalia_aperta_id_seq RESTART WITH 1")
    void resetSequence();

    List<AnomaliaAperta> findByCodiceSAPStartingWith(String codiceSap);
    List<AnomaliaAperta> findByCodiceSAPContaining(String codiceSap);
    List<AnomaliaAperta> findByCodiceSAP(String codiceSap);

}
