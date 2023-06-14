package it.ctinnovation.tdcKc.service.pocterna;

import ch.ralscha.extdirectspring.bean.ExtDirectStoreReadRequest;
import com.opencsv.exceptions.CsvValidationException;
import it.ctinnovation.tdcKc.model.pocterna.AnomaliaAperta;
import it.ctinnovation.tdcKc.model.pocterna.Provvedimento;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface PocTernaService {
    void uploadAnomalieAperte(@NotNull MultipartFile file) throws IOException, CsvValidationException;
    void uploadProvvedimenti(@NotNull MultipartFile file) throws IOException, CsvValidationException;

    String getTicketsAsString();

    String getTicketsAsString(String id);

    List<Provvedimento> getProvvedimenti();

    List<AnomaliaAperta> getAnomalie(ExtDirectStoreReadRequest storeRequest);
}
