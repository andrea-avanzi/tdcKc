package it.ctinnovation.tdcKc.controller.pocterna;

import com.opencsv.exceptions.CsvValidationException;
import it.ctinnovation.tdcKc.service.pocterna.PocTernaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/pocTerna")
@Slf4j
public class PocTernaController {

    private final PocTernaService pocTernaService;

    public PocTernaController(PocTernaService pocTernaService) {
        this.pocTernaService = pocTernaService;
    }

    @PostMapping("/uploadAnomalieAperte")
    public ResponseEntity<String> anomalieAperteFile(@RequestParam ("anomalieAperte") MultipartFile file) throws CsvValidationException {
        log.info("Received file: " + file.getOriginalFilename());
        try {
            pocTernaService.uploadAnomalieAperte(file);
            return ResponseEntity.ok("CSV file uploaded successfully.");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload CSV file.");
        }
    }
}
