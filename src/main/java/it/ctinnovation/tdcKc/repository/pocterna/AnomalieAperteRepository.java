package it.ctinnovation.tdcKc.repository.pocterna;

import it.ctinnovation.tdcKc.model.pocterna.AnomaliaAperta;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AnomalieAperteRepository extends JpaRepository<AnomaliaAperta, Long> {

    @Modifying
    @Query(nativeQuery = true, value = "ALTER SEQUENCE anomalia_aperta_id_seq RESTART WITH 1")
    void resetSequence();

    List<AnomaliaAperta> findByCodiceSAP(String codiceSap);

    Page<AnomaliaAperta> findAll(Pageable pageable);
}
