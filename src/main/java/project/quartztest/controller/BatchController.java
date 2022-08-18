package project.quartztest.controller;

import static org.quartz.JobBuilder.newJob;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.stereotype.Controller;
import project.quartztest.job.QuartzJob;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@Controller
public class BatchController {

    private final Scheduler scheduler;

    @PostConstruct
    public void start() {

        // Created Schedule Job
        JobDetail jobDetail = buildJobDetail(QuartzJob.class, "testJob", "test", new HashMap());

        try {

            // Started Scheduler
            scheduler.scheduleJob(jobDetail, buildJobTrigger("*/30 * * * * ?"));

        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public Trigger buildJobTrigger(String scheduleExp) {
        return TriggerBuilder.newTrigger().withSchedule(CronScheduleBuilder.cronSchedule(scheduleExp)).build();
    }

    public JobDetail buildJobDetail(Class job, String name, String group, Map params) {
        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.putAll(params);

        return newJob(job).withIdentity(name, group)
                .usingJobData(jobDataMap)
                .build();
    }
}
