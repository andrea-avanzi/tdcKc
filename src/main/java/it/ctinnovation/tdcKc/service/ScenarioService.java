package it.ctinnovation.tdcKc.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ScenarioService {
    void saveScenario(MultipartFile file) throws IOException;
}
