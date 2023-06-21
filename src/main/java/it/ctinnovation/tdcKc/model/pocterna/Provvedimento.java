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
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",timezone = "CET")
    Date dataElaborazioneProvvedimento;
    String autoreValidazioneProvvedimento;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",timezone = "CET")
    Date dataValidazioneProvvedimento;
    String codiceAvvisoSap;
    String codiceIstanzaMake;
    String idMbi;
    String statoProvvedimento;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",timezone = "CET")
    Date dataScadenzaProvvedimento;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",timezone = "CET")
    Date dataOttimizzata;
    String numElaborazioneDiagnostica;
    String notaProvvedimento;
    String noteProvvedimentoUtente;
    String noteValidazioneProvvedimento;
    String descriziooneAnomalia;
    String valoreAnomalia;
    String posizioneAnomalia;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",timezone = "CET")
    Date dataRilevazioneAnomalia;
    String autoreRilevazioneAnomalia;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'",timezone = "CET")
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
