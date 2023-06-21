package it.ctinnovation.tdcKc.service.implementation.pocterna;

import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import ch.ralscha.extdirectspring.bean.SortDirection;
import ch.ralscha.extdirectspring.bean.SortInfo;
import ch.ralscha.extdirectspring.filter.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import it.ctinnovation.tdcKc.model.pocterna.*;
import it.ctinnovation.tdcKc.repository.pocterna.AnomalieAperteRepository;
import it.ctinnovation.tdcKc.repository.pocterna.ProvvedimentiRepository;
import it.ctinnovation.tdcKc.service.pocterna.PocTernaService;
import it.ctinnovation.tdcKc.util.PageableBuilder;
import it.ctinnovation.tdcKc.util.SpecificationFactory;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import static org.springframework.data.jpa.domain.Specification.where;

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
    public String getTicketsAsString(String codiceSap) {
        TicketResponse ticketResponse = new TicketResponse();
        String response = "{}";
        try {
            // codiceSap - last character
            String codiceRicerca= codiceSap.substring(0, codiceSap.length() - 1);
            ticketResponse.setAnomalieAperte(anomalieAperteRepository.findByCodiceSAPStartingWith(codiceRicerca));
            ticketResponse.setProvvedimenti(provvedimentiRepository.findByCodiceSAPStartingWith(codiceRicerca));
            if (!ticketResponse.getActiveCases().isEmpty())
                ticketResponse.getActiveCases().sort(Comparator.comparing(Ticket::openingTimestamp));
            if (!ticketResponse.getClosedCases().isEmpty())
                ticketResponse.getClosedCases().sort(Comparator.comparing(Ticket::closingDeadlineTimestamp).reversed());
            response = objectMapper.writeValueAsString(ticketResponse);
        } catch (JsonProcessingException e) {
            log.error("Error while converting to json", e);
        }
        return response;
    }

    @Override
    public Page<Provvedimento> getProvvedimenti(ExtDirectStoreReadRequest storeRequest) {
        SortInfo defaultSort = new SortInfo("dataScadenzaProvvedimento", SortDirection.DESCENDING);
        Pageable pageable = PageableBuilder.of(storeRequest, defaultSort);
        Specification<Provvedimento> sp = SpecificationFactory.buildSpecs(storeRequest, Provvedimento.class);
        if (sp != null)
            return provvedimentiRepository.findAll(sp, pageable);
        else
            return provvedimentiRepository.findAll(pageable);
        //return provvedimentiRepository.findAll(pageable);
    }

    @Override
    public Page<AnomaliaAperta> getAnomalie(ExtDirectStoreReadRequest storeRequest) {
        SortInfo defaultSort = new SortInfo("dataRilevazioneAnomalia", SortDirection.DESCENDING);
        Pageable pageable = PageableBuilder.of(storeRequest, defaultSort);
        Specification<AnomaliaAperta> sp = SpecificationFactory.buildSpecs(storeRequest, AnomaliaAperta.class);
        if (sp != null)
            return anomalieAperteRepository.findAll(sp, pageable);
        else
            return anomalieAperteRepository.findAll(pageable);
    }
/*
    private Specification<AnomaliaAperta> buildSpecs(ExtDirectStoreReadRequest storeRequest) {
        if (storeRequest.getFilters().isEmpty()) {
            return null;
        }
        List<Filter> filters = storeRequest.getFilters().stream().collect(Collectors.toList());
        Specification<AnomaliaAperta> specification =
            where(createSingleSpec(filters.remove(0)));
        for (Filter input : filters) {
            specification = specification.and(createSingleSpec(input));
        }
        return specification;
    }

    private Specification<AnomaliaAperta> createSingleSpec(Filter filter) {
        if (filter instanceof StringFilter) {
            StringFilter stringFilter = (StringFilter) filter;
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ITALY);
                formatter.parse(stringFilter.getValue());
                return dateSpecification(stringFilter);
            } catch (ParseException e) {
                return stringSpecification(stringFilter);
            }
        }
        if (filter instanceof NumericFilter) {
            return numericSpecification((NumericFilter) filter);
        }
        return null;
    }

    private Specification<AnomaliaAperta> dateSpecification(StringFilter filter) {
        OffsetDateTime date = OffsetDateTime.parse(filter.getValue());
        ZonedDateTime zdt = date.atZoneSameInstant(ZoneId.of("Europe/Rome"));
        LocalDateTime ldt = zdt.toLocalDateTime();
        switch (filter.getRawComparison()) {
            case "==":
                return dateEqual(filter.getField(), ldt);
            case "!=":
                return dateNotEqual(filter.getField(), ldt);
            case ">":
                return dateGreater(filter.getField(), ldt);
            case ">=":
                return dateGreaterEqual(filter.getField(), ldt);
            case "<":
                return dateLower(filter.getField(), ldt);
            case "<=":
                return dateLowerEqual(filter.getField(), ldt);
            default:
                return null;
        }
    }

    private Specification<AnomaliaAperta> dateEqual(String field, LocalDateTime value) {
        return (root, query, cb) -> cb.equal(root.get(field), value);
    }

    private Specification<AnomaliaAperta> dateNotEqual(String field, LocalDateTime value) {
        return (root, query, cb) -> cb.notEqual(root.get(field), value);
    }

    private Specification<AnomaliaAperta> dateGreater(String field, LocalDateTime value) {
        return (root, query, cb) -> cb.greaterThan(root.get(field), value);
    }

    private Specification<AnomaliaAperta> dateGreaterEqual(String field, LocalDateTime value) {
        return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get(field), value);
    }

    private Specification<AnomaliaAperta> dateLower(String field, LocalDateTime value) {
        return (root, query, cb) -> cb.lessThan(root.get(field), value);
    }

    private Specification<AnomaliaAperta> dateLowerEqual(String field, LocalDateTime value) {
        return (root, query, cb) -> cb.lessThanOrEqualTo(root.get(field), value);
    }

    private Specification<AnomaliaAperta> numericSpecification(NumericFilter filter) {
        switch (filter.getRawComparison()) {
            case "==":
                return numericEqual(filter.getField(), filter.getValue());
            case "!=":
                return numericNotEqual(filter.getField(), filter.getValue());
            case ">":
                return numericGreater(filter.getField(), filter.getValue());
            case ">=":
                return numericGreaterEqual(filter.getField(), filter.getValue());
            case "<":
                return numericLower(filter.getField(), filter.getValue());
            case "<=":
                return numericLowerEqual(filter.getField(), filter.getValue());
            default:
                return null;
        }
    }

    private Specification<AnomaliaAperta> numericEqual(String field, Number value) {
        return (root, query, cb) -> cb.equal(root.get(field), value);
    }

    private Specification<AnomaliaAperta> numericNotEqual(String field, Number value) {
        return (root, query, cb) -> cb.notEqual(root.get(field), value);
    }

    private Specification<AnomaliaAperta> numericGreater(String field, Number value) {
        return (root, query, cb) -> cb.gt(root.get(field), value);
    }

    private Specification<AnomaliaAperta> numericGreaterEqual(String field, Number value) {
        return (root, query, cb) -> cb.ge(root.get(field), value);
    }

    private Specification<AnomaliaAperta> numericLower(String field, Number value) {
        return (root, query, cb) -> cb.lt(root.get(field), value);
    }

    private Specification<AnomaliaAperta> numericLowerEqual(String field, Number value) {
        return (root, query, cb) -> cb.le(root.get(field), value);
    }

    private Specification<AnomaliaAperta> stringSpecification(StringFilter filter) {
        switch (filter.getRawComparison()) {
            case "like":
                return stringLike(filter.getField(), filter.getValue());
            case "==":
                return stringEqual(filter.getField(), filter.getValue());
            case "!=":
                return stringNotEqual(filter.getField(), filter.getValue());
            case "nempty":
                return stringNotEmpty(filter.getField());
            case "empty":
                return stringEmpty(filter.getField());
            default:
                return null;
        }
    }

    private Specification<AnomaliaAperta> stringEmpty(String attribute) {
        return (root, query, cb) -> cb.isNull(root.get(attribute));
    }

    private Specification<AnomaliaAperta> stringNotEmpty(String attribute) {
        return (root, query, cb) -> cb.isNotNull(root.get(attribute));
    }

    private Specification<AnomaliaAperta> stringNotEqual(String attribute, String value) {
        return (root, query, cb) -> cb.notEqual(root.get(attribute), value);
    }

    private Specification<AnomaliaAperta> stringLike(String attribute, String value) {
        return (root, query, cb) -> cb.like(root.get(attribute), "%" + value + "%");
    }

    private Specification<AnomaliaAperta> stringEqual(String attribute, String value) {
        return (root, query, cb) -> cb.equal(root.get(attribute), value);
    }
*/
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
