package it.ctinnovation.tdcKc.model.pocterna;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.Date;

@Data
@Entity
public class AnomaliaAperta {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String unitaImpianti;
    String linea;
    String tensione;
    String tipoSedeTecnica;
    String codiceSAP;
    String posizioneSede;
    String descrizioneAnomalia;
    String valoreAnomalia;
    String posizioneAnomalia;
    Date dataRilevazioneAnomalia;
    String autoreRilevazione;
    Date dataUltimaRilevazioneAnomalia;
    String autoreUltimaRilevazione;
    String codiceAvvisoSap;
    String statoAnomalia;
    String notaAnomalia;
    String richiedeFuoriServizio;
    Long numeroElaborazioneDiagnostica;
    String notaSessione;
    String siglaSottotipoControllo;
    String noteAnomalia;
}
