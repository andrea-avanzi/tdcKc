package it.ctinnovation.tdcKc.service.pocterna;

import com.opencsv.exceptions.CsvValidationException;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface PocTernaService {
    void uploadAnomalieAperte(@NotNull MultipartFile file) throws IOException, CsvValidationException;
}
