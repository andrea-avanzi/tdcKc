package it.ctinnovation.tdcKc.repository.pocterna;

import it.ctinnovation.tdcKc.model.pocterna.Provvedimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProvvedimentiRepository extends JpaRepository<Provvedimento, Long> {

    @Modifying
    @Query(nativeQuery = true, value = "ALTER SEQUENCE provvedimento_id_seq RESTART WITH 1")
    void resetSequence();

    List<Provvedimento> findByCodiceSAP(String codiceSap);
}
