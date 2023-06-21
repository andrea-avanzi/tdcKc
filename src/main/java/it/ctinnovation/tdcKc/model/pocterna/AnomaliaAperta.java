package it.ctinnovation.tdcKc.model.pocterna;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",timezone = "CET")
    @Temporal(TemporalType.DATE)
    Date dataRilevazioneAnomalia;
    String autoreRilevazione;
    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",timezone = "CET")
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
