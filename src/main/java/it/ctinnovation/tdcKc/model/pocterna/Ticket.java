package it.ctinnovation.tdcKc.model.pocterna;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.Instant;

public record Ticket(Long id,
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
}
