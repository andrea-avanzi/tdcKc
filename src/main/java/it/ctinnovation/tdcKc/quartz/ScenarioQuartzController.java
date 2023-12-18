package it.ctinnovation.tdcKc.quartz;

import it.ctinnovation.tdcKc.service.ScenarioLogEntityService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.SchedulerException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quartz")
@Slf4j
@RequiredArgsConstructor
public class ScenarioQuartzController {

    private final ScenarioQuartzService quartzService;
    private final ScenarioLogEntityService scenarioLogEntityService;

    /**
     * la cronExpression deve essere del tipo "0/5 * * * * ?" (ogni 5 secondi)
     * oppure "0 0/1 * * * ?" (ogni minuto)
     * oppure "0 0 0/1 * * ?" (ogni ora)
     * oppure "0 0 0 1/1 * ?" (ogni giorno)
     * oppure "0 0 0 ? * MON-FRI" (ogni giorno lavorativo)
     * oppure "0 0 0 ? * 6L" (l'ultimo sabato del mese)
     * oppure "0 0 0 ? * 6#3" (il terzo sabato del mese)
     * oppure "0 0 0 ? * 6L 2016-2018" (l'ultimo sabato del mese dal 2016 al 2018)
     *
     * @param scenarioId
     * @param cronExpression
     * @return
     */
    @RequestMapping("/start")
    public String startJob(@RequestParam Long scenarioId, @RequestParam String cronExpression) {
        log.info("Schedulo il job {} con cron {}", scenarioId, cronExpression);
        try {
            scenarioLogEntityService.createLog(scenarioId, cronExpression);
            quartzService.scheduleJob(scenarioId, cronExpression);
            return "Job relativo allo scenario" + scenarioId + " schedulato con successo!";
        } catch (SchedulerException e) {
            return "Errore nello schedulare il job: " + e.getMessage();
        }
    }

    @RequestMapping("/stop")
    public String stopJob(@RequestParam Long scenarioId) {
        try {
            quartzService.unscheduleJob(scenarioId);
            scenarioLogEntityService.removeLog(scenarioId);
            return "Job relativo allo scenario" + scenarioId + " interrotto con successo!";
        } catch (SchedulerException e) {
            return "Errore nell'interruzione del job: " + e.getMessage();
        }
    }

}
