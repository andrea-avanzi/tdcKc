package it.ctinnovation.tdcKc.model.pocterna;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TicketResponse {
    private List<Ticket> activeCases=new ArrayList<>();
    private List<Ticket> closedCases=new ArrayList<>();



    public void setAnomalieAperte(List<AnomaliaAperta> all) {
        long ticketNumber=3279l;
        for(AnomaliaAperta anomalieAperta:all){
            Ticket ticket=new Ticket(
                ticketNumber++,
                anomalieAperta.getCodiceSAP(),
                anomalieAperta.getNumeroElaborazioneDiagnostica().toString(),
                anomalieAperta.getDescrizioneAnomalia(),
                "Anomalia",
                anomalieAperta.getStatoAnomalia(),
                anomalieAperta.dataRilevazioneAnomalia.toInstant(),
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
        for(Provvedimento provvedimento:all){
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
                null,
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
