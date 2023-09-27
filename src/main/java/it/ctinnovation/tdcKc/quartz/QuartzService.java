package it.ctinnovation.tdcKc.quartz;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class QuartzService {

    private final Scheduler scheduler;

    public void scheduleJob(String jobName, String cronExpression) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
            .withIdentity(jobName, "group1")
            .build();

        CronTrigger trigger = TriggerBuilder.newTrigger()
            .withIdentity("trigger" + jobName, "group1")
            .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
            .build();

        scheduler.scheduleJob(jobDetail, trigger);
    }

    public void unscheduleJob(String jobName) throws SchedulerException {
        JobKey jobKey = new JobKey(jobName, "group1");
        scheduler.deleteJob(jobKey);
    }
}
