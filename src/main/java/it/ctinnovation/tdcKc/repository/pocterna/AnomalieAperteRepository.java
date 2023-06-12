package it.ctinnovation.tdcKc.repository.pocterna;

import it.ctinnovation.tdcKc.model.pocterna.AnomalieAperte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface AnomalieAperteRepository extends JpaRepository<AnomalieAperte, Long> {

    @Modifying
    @Query(nativeQuery = true, value = "ALTER SEQUENCE anomalie_aperte_id_seq RESTART WITH 1")
    void resetSequence();
}
