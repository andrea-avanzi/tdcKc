package it.ctinnovation.tdcKc.model.pocterna;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.util.Date;

@Entity
@Data
public class Provvedimento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String unitaImpianti;
    String linea;
    String tensione;
    String tipoSedeTecnica;
    String codiceSAP;
    String posizioneSede;
    String controlliProvvedimenti;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss[.SSS]'Z'", timezone = "UTC+1")
    Date dataElaborazioneProvvedimento;
    String autoreValidazioneProvvedimento;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss[.SSS]'Z'", timezone = "UTC+1")
    Date dataValidazioneProvvedimento;
    String codiceAvvisoSap;
    String codiceIstanzaMake;
    String idMbi;
    String statoProvvedimento;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss[.SSS]'Z'", timezone = "UTC+1")
    Date dataScadenzaProvvedimento;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss[.SSS]'Z'", timezone = "UTC+1")
    Date dataOttimizzata;
    String numElaborazioneDiagnostica;
    String notaProvvedimento;
    String noteProvvedimentoUtente;
    String noteValidazioneProvvedimento;
    String descriziooneAnomalia;
    String valoreAnomalia;
    String posizioneAnomalia;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss[.SSS]'Z'", timezone = "UTC+1")
    Date dataRilevazioneAnomalia;
    String autoreRilevazioneAnomalia;
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss[.SSS]'Z'", timezone = "UTC+1")
    Date dataUltimaRilevazioneAnomalia;
    String autoreUltimaRilevazioneAnomalia;
    String codiceAvvisoSapAnomalia;
    String statoAnomalia;
    String notaAnomalia;
    String richiedeFuoriServizio;
    @Column(columnDefinition = "TEXT")
    String noteSessioneAnomalia;
    String siglaSottotipoControllo;
}
