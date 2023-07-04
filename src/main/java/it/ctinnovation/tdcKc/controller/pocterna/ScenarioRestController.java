package it.ctinnovation.tdcKc.controller.pocterna;

import it.ctinnovation.tdcKc.service.implementation.ScenarioServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/scenario")
@Slf4j
@RequiredArgsConstructor
public class ScenarioRestController {

    final ScenarioServiceImpl scenarioService;

    @PostMapping("/uploadMessages")
    public ResponseEntity<String> upload(@RequestParam("file") MultipartFile file) throws IOException {
            // Validate the file and ID
            scenarioService.saveScenario(file);
            // Process the file upload

            // Update the entity with the file
            log.info("Upload scenario file");
            return ResponseEntity.ok("File uploaded successfully.");
    }
}
