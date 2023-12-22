package it.ctinnovation.tdcKc.quartz;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class ScenarioQuartzService {

    private final Scheduler scheduler;
    private final ScenarioJob job;

    public void scheduleJob(Long scenarioId, String cronExpression) throws SchedulerException {
        // esegui il job sulla base dello scenario id
        JobDetail jobDetail = JobBuilder.newJob(ScenarioJob.class)
            .withIdentity(scenarioId.toString(), "defaultGroup")
            .build();

        Trigger immediateTrigger = TriggerBuilder.newTrigger()
            .withIdentity("immediateTrigger" + scenarioId, "defaultGroup")
            .startNow()
            .forJob(jobDetail)
            .build();

        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
            .withIdentity("cronTrigger" + scenarioId, "defaultGroup")
            .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
            .forJob(jobDetail)
            .build();

        scheduler.scheduleJob(jobDetail, immediateTrigger);
        scheduler.scheduleJob(cronTrigger);
    }

    public void unscheduleJob(Long scenarioId) throws SchedulerException {
        JobKey jobKey = new JobKey(scenarioId.toString(), "defaultGroup");
        scheduler.deleteJob(jobKey);
    }
}
