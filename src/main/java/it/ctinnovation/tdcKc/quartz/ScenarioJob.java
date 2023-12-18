package it.ctinnovation.tdcKc.quartz;

import it.ctinnovation.tdcKc.service.ScenarioService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ScenarioJob implements Job {

    @Autowired
    private ScenarioService scenarioService;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("Eseguo Job: " + jobExecutionContext.getJobDetail().getKey().getName());
        scenarioService.readAndSendScenario(Long.parseLong(jobExecutionContext.getJobDetail().getKey().getName()));
    }
}
