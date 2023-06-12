package it.ctinnovation.tdcKc.service.implementation.pocterna;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import it.ctinnovation.tdcKc.model.pocterna.AnomalieAperte;
import it.ctinnovation.tdcKc.repository.pocterna.AnomalieAperteRepository;
import it.ctinnovation.tdcKc.service.pocterna.PocTernaService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@Service
@Slf4j
@Transactional
public class PocTernaServiceImpl implements PocTernaService {

    AnomalieAperteRepository anomalieAperteRepository;

    public PocTernaServiceImpl(AnomalieAperteRepository anomalieAperteRepository) {
        this.anomalieAperteRepository = anomalieAperteRepository;
    }

    /*
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
    */

    public void uploadAnomalieAperte(@NotNull MultipartFile file) throws IOException, CsvValidationException {
        anomalieAperteRepository.deleteAll();
        anomalieAperteRepository.resetSequence();
        InputStreamReader isr = new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8);
        CSVReader reader = new CSVReader(isr);
        String[] line;
        while ((line = reader.readNext()) != null) {
            AnomalieAperte aa = new AnomalieAperte();
            aa.setUnitaImpianti(line[0]);
            aa.setLinea(line[1]);
            anomalieAperteRepository.save(aa);
        }
    }
}
