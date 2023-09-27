package it.ctinnovation.tdcKc.service;

import it.ctinnovation.tdcKc.repository.ScenarioMessageEntityRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScenarioMessageService {

    private final ScenarioMessageEntityRepository scenarioMessageEntityRepository;


}
