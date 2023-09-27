package it.ctinnovation.tdcKc.model.pocterna;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import java.util.Date;
import javax.annotation.processing.Generated;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AnomaliaAperta.class)
public abstract class AnomaliaAperta_ {

	public static volatile SingularAttribute<AnomaliaAperta, String> posizioneAnomalia;
	public static volatile SingularAttribute<AnomaliaAperta, String> descrizioneAnomalia;
	public static volatile SingularAttribute<AnomaliaAperta, String> tensione;
	public static volatile SingularAttribute<AnomaliaAperta, String> autoreRilevazione;
	public static volatile SingularAttribute<AnomaliaAperta, String> linea;
	public static volatile SingularAttribute<AnomaliaAperta, String> valoreAnomalia;
	public static volatile SingularAttribute<AnomaliaAperta, String> statoAnomalia;
	public static volatile SingularAttribute<AnomaliaAperta, Date> dataRilevazioneAnomalia;
	public static volatile SingularAttribute<AnomaliaAperta, Long> numeroElaborazioneDiagnostica;
	public static volatile SingularAttribute<AnomaliaAperta, String> codiceAvvisoSap;
	public static volatile SingularAttribute<AnomaliaAperta, String> richiedeFuoriServizio;
	public static volatile SingularAttribute<AnomaliaAperta, String> notaSessione;
	public static volatile SingularAttribute<AnomaliaAperta, String> siglaSottotipoControllo;
	public static volatile SingularAttribute<AnomaliaAperta, String> unitaImpianti;
	public static volatile SingularAttribute<AnomaliaAperta, Date> dataUltimaRilevazioneAnomalia;
	public static volatile SingularAttribute<AnomaliaAperta, String> noteAnomalia;
	public static volatile SingularAttribute<AnomaliaAperta, String> codiceSAP;
	public static volatile SingularAttribute<AnomaliaAperta, String> posizioneSede;
	public static volatile SingularAttribute<AnomaliaAperta, String> notaAnomalia;
	public static volatile SingularAttribute<AnomaliaAperta, Long> id;
	public static volatile SingularAttribute<AnomaliaAperta, String> tipoSedeTecnica;
	public static volatile SingularAttribute<AnomaliaAperta, String> autoreUltimaRilevazione;

	public static final String POSIZIONE_ANOMALIA = "posizioneAnomalia";
	public static final String DESCRIZIONE_ANOMALIA = "descrizioneAnomalia";
	public static final String TENSIONE = "tensione";
	public static final String AUTORE_RILEVAZIONE = "autoreRilevazione";
	public static final String LINEA = "linea";
	public static final String VALORE_ANOMALIA = "valoreAnomalia";
	public static final String STATO_ANOMALIA = "statoAnomalia";
	public static final String DATA_RILEVAZIONE_ANOMALIA = "dataRilevazioneAnomalia";
	public static final String NUMERO_ELABORAZIONE_DIAGNOSTICA = "numeroElaborazioneDiagnostica";
	public static final String CODICE_AVVISO_SAP = "codiceAvvisoSap";
	public static final String RICHIEDE_FUORI_SERVIZIO = "richiedeFuoriServizio";
	public static final String NOTA_SESSIONE = "notaSessione";
	public static final String SIGLA_SOTTOTIPO_CONTROLLO = "siglaSottotipoControllo";
	public static final String UNITA_IMPIANTI = "unitaImpianti";
	public static final String DATA_ULTIMA_RILEVAZIONE_ANOMALIA = "dataUltimaRilevazioneAnomalia";
	public static final String NOTE_ANOMALIA = "noteAnomalia";
	public static final String CODICE_SA_P = "codiceSAP";
	public static final String POSIZIONE_SEDE = "posizioneSede";
	public static final String NOTA_ANOMALIA = "notaAnomalia";
	public static final String ID = "id";
	public static final String TIPO_SEDE_TECNICA = "tipoSedeTecnica";
	public static final String AUTORE_ULTIMA_RILEVAZIONE = "autoreUltimaRilevazione";

}

