package it.ctinnovation.tdcKc.service.implementation.pocterna;

import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import it.ctinnovation.tdcKc.model.pocterna.AnomaliaAperta;
import it.ctinnovation.tdcKc.model.pocterna.Provvedimento;
import it.ctinnovation.tdcKc.model.pocterna.Ticket;
import it.ctinnovation.tdcKc.model.pocterna.TicketResponse;
import it.ctinnovation.tdcKc.repository.pocterna.AnomalieAperteRepository;
import it.ctinnovation.tdcKc.repository.pocterna.ProvvedimentiRepository;
import it.ctinnovation.tdcKc.service.pocterna.PocTernaService;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
@Transactional
public class PocTernaServiceImpl implements PocTernaService {

    AnomalieAperteRepository anomalieAperteRepository;
    ProvvedimentiRepository provvedimentiRepository;
    ObjectMapper objectMapper;

    public PocTernaServiceImpl(AnomalieAperteRepository anomalieAperteRepository,
                               ProvvedimentiRepository provvedimentiRepository,
                               ObjectMapper objectMapper) {
        this.anomalieAperteRepository = anomalieAperteRepository;
        this.provvedimentiRepository = provvedimentiRepository;
        this.objectMapper = objectMapper;
    }


    public void uploadAnomalieAperte(@NotNull MultipartFile file) throws IOException, CsvValidationException {
        anomalieAperteRepository.deleteAll();
        anomalieAperteRepository.resetSequence();
        InputStreamReader isr = new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8);
        CSVReader reader = new CSVReader(isr);
        String[] line;
        while ((line = reader.readNext()) != null) {
            AnomaliaAperta aa = new AnomaliaAperta();
            aa.setUnitaImpianti(line[1]);
            aa.setLinea(line[2]);
            aa.setTensione(line[3]);
            aa.setTipoSedeTecnica(line[4]);
            aa.setCodiceSAP(line[5]);
            aa.setPosizioneSede(line[6]);
            aa.setDescrizioneAnomalia(line[7]);
            aa.setValoreAnomalia(line[8]);
            aa.setPosizioneAnomalia(line[9]);
            aa.setDataRilevazioneAnomalia(toDate(line[10]));
            aa.setAutoreRilevazione(line[11]);
            aa.setDataUltimaRilevazioneAnomalia(toDate(line[12]));
            aa.setAutoreRilevazione(line[13]);
            aa.setCodiceAvvisoSap(line[14]);
            aa.setStatoAnomalia(line[15]);
            aa.setNotaAnomalia(line[16]);
            aa.setRichiedeFuoriServizio(line[17]);
            aa.setNumeroElaborazioneDiagnostica(Long.parseLong(line[18]));
            aa.setNotaSessione(line[19]);
            aa.setSiglaSottotipoControllo(line[20]);
            aa.setNotaAnomalia(line[21]);
            anomalieAperteRepository.save(aa);
        }
    }

    @Override
    public void uploadProvvedimenti(@NotNull MultipartFile file) throws IOException, CsvValidationException {
        provvedimentiRepository.deleteAll();
        provvedimentiRepository.resetSequence();
        InputStreamReader isr = new InputStreamReader(file.getInputStream(), StandardCharsets.UTF_8);
        CSVReader reader = new CSVReader(isr);
        String[] line;
        while ((line = reader.readNext()) != null) {
            Provvedimento p = new Provvedimento();
            p.setUnitaImpianti(line[1]);
            p.setLinea(line[2]);
            p.setTensione(line[3]);
            p.setTipoSedeTecnica(line[4]);
            p.setCodiceSAP(line[5]);
            p.setPosizioneSede(line[6]);
            p.setControlliProvvedimenti(line[7]);
            p.setDataElaborazioneProvvedimento(toDate(line[8]));
            p.setAutoreValidazioneProvvedimento(line[9]);
            p.setDataValidazioneProvvedimento(toDate(line[10]));
            p.setCodiceAvvisoSap(line[11]);
            p.setCodiceIstanzaMake(line[12]);
            p.setIdMbi(line[13]);
            p.setStatoProvvedimento(line[14]);
            p.setDataScadenzaProvvedimento(toDate(line[15]));
            p.setDataOttimizzata(toDate(line[16]));
            p.setNumElaborazioneDiagnostica(line[17]);
            p.setNotaProvvedimento(line[18]);
            p.setNoteProvvedimentoUtente(line[19]);
            p.setNoteValidazioneProvvedimento(line[20]);
            p.setDescriziooneAnomalia(line[21]);
            p.setValoreAnomalia(line[22]);
            p.setPosizioneAnomalia(line[23]);
            p.setDataRilevazioneAnomalia(toDate(line[24]));
            p.setAutoreRilevazioneAnomalia(line[25]);
            p.setDataUltimaRilevazioneAnomalia(toDate(line[26]));
            p.setAutoreUltimaRilevazioneAnomalia(line[27]);
            p.setCodiceAvvisoSapAnomalia(line[28]);
            p.setStatoAnomalia(line[29]);
            p.setNotaAnomalia(line[30]);
            p.setRichiedeFuoriServizio(line[31]);
            p.setNoteSessioneAnomalia(line[32]);
            p.setSiglaSottotipoControllo(line[33]);
            provvedimentiRepository.save(p);
        }

    }

    @Override
    public String getTicketsAsString() {
        TicketResponse ticketResponse = new TicketResponse();
        String response = "{}";
        try {
            ticketResponse.setAnomalieAperte(anomalieAperteRepository.findAll());
            ticketResponse.setProvvedimenti(provvedimentiRepository.findAll());
            ticketResponse.getActiveCases().sort(Comparator.comparing(Ticket::openingTimestamp));
            ticketResponse.getClosedCases().sort(Comparator.comparing(Ticket::closingDeadlineTimestamp).reversed());
            response = objectMapper.writeValueAsString(ticketResponse);
        } catch (JsonProcessingException e) {
            log.error("Error while converting to json", e);
        }
        return response;
    }

    @Override
    public String getTicketsAsString(String id) {
        TicketResponse ticketResponse = new TicketResponse();
        String response = "{}";
        try {
            ticketResponse.setAnomalieAperte(anomalieAperteRepository.findByCodiceSAP(id));
            ticketResponse.setProvvedimenti(provvedimentiRepository.findByCodiceSAP(id));
            if(!ticketResponse.getActiveCases().isEmpty())
                ticketResponse.getActiveCases().sort(Comparator.comparing(Ticket::openingTimestamp));
            if(!ticketResponse.getClosedCases().isEmpty())
                ticketResponse.getClosedCases().sort(Comparator.comparing(Ticket::closingDeadlineTimestamp).reversed());
            response = objectMapper.writeValueAsString(ticketResponse);
        } catch (JsonProcessingException e) {
            log.error("Error while converting to json", e);
        }
        return response;
    }

    @Override
    public List<Provvedimento> getProvvedimenti() {
        List<Provvedimento> provvedimenti = provvedimentiRepository.findAll();
        provvedimenti.sort(Comparator.comparing(Provvedimento::getDataScadenzaProvvedimento).reversed());
        return provvedimenti;
    }

    @Override
    public List<AnomaliaAperta> getAnomalie(ExtDirectStoreReadRequest storeRequest) {
        Pageable pageable = PageRequest.of(storeRequest.getPage() - 1, storeRequest.getLimit());
        List<AnomaliaAperta> anomalieAperte = anomalieAperteRepository.findAll(pageable).getContent();
        //anomalieAperte.sort(Comparator.comparing(AnomaliaAperta::getDataRilevazioneAnomalia));
        return anomalieAperte;
    }

    private Date toDate(String strDate) {
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/yyyy");
        try {
            Date date = sdf.parse(strDate);
            return date;
        } catch (ParseException e) {
            return null;
        }
    }
}
