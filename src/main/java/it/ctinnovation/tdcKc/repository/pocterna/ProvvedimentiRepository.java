package it.ctinnovation.tdcKc.repository.pocterna;

import it.ctinnovation.tdcKc.model.pocterna.AnomaliaAperta;
import it.ctinnovation.tdcKc.model.pocterna.Provvedimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProvvedimentiRepository extends
    JpaRepository<Provvedimento, Long>,
    JpaSpecificationExecutor<Provvedimento> {

    @Modifying
    @Query(nativeQuery = true, value = "ALTER SEQUENCE provvedimento_id_seq RESTART WITH 1")
    void resetSequence();

    List<Provvedimento> findByCodiceSAPStartingWith(String codiceSap);
    List<Provvedimento> findByCodiceSAPContaining(String codiceSap);
    List<Provvedimento> findByCodiceSAP(String codiceSap);
}
