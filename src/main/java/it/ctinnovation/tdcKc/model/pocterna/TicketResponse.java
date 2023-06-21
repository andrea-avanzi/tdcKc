package it.ctinnovation.tdcKc.model.pocterna;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketResponse {
    private List<Ticket> activeCases=new ArrayList<>();
    private List<Ticket> closedCases=new ArrayList<>();
    public void setAnomalieAperte(List<AnomaliaAperta> all) {
        long ticketNumber=3279l;
        ZoneId zoneId = ZoneId.of("Europe/Rome");
        for(AnomaliaAperta anomalieAperta:all){
            Date anoAp=new Date(anomalieAperta.getDataUltimaRilevazioneAnomalia().getTime());
            Instant dataUltimaRilevazione=anoAp.toInstant();
            Ticket ticket=new Ticket(
                ticketNumber++,
                anomalieAperta.getCodiceSAP(),
                anomalieAperta.getNumeroElaborazioneDiagnostica().toString(),
                anomalieAperta.getDescrizioneAnomalia(),
                "Anomalia",
                anomalieAperta.getStatoAnomalia(),
                dataUltimaRilevazione,
                null,
                null,
                null,
                null,
                null);
            activeCases.add(ticket);
        }
    }

    public void setProvvedimenti(List<Provvedimento> all) {
        long ticketNumber=3279l;
        ObjectMapper objectMapper=new ObjectMapper();
        Locale locale = new Locale("it", "IT");
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);
        String date = dateFormat.format(new Date());
        for(Provvedimento provvedimento:all){
            Map<String, String> data = new HashMap<>();
            data.put("Data validazione", dateFormat.format(provvedimento.dataValidazioneProvvedimento));
            data.put("Data scadenza", dateFormat.format(provvedimento.dataScadenzaProvvedimento));
            Ticket ticket=new Ticket(
                ticketNumber++,
                provvedimento.getCodiceSAP(),
                provvedimento.getNumElaborazioneDiagnostica().toString(),
                provvedimento.controlliProvvedimenti,
                "Provvedimento",
                provvedimento.getStatoProvvedimento(),
                provvedimento.dataElaborazioneProvvedimento.toInstant(),
                provvedimento.dataValidazioneProvvedimento.toInstant(),
                null,
                provvedimento.dataScadenzaProvvedimento.toInstant(),
                data,
                null);
            closedCases.add(ticket);
        }
    }
}

/**
 String assetId,
 String caseNumber,
 String failureDescription,
 String failureType,
 String status,
 @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss[.SSS]'Z'", timezone = "UTC+1")
 Instant openingTimestamp,
 @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss[.SSS]'Z'", timezone = "UTC+1")
 Instant suspensionTimestamp,
 @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss[.SSS]'Z'", timezone = "UTC+1")
 Instant closingTimestamp,
 @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss[.SSS]'Z'", timezone = "UTC+1")
 Instant closingDeadlineTimestamp,
 Object data,
 String url) {
 */


