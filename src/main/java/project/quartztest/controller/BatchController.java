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

        JobDetail jobDetail = buildJobDetail(QuartzJob.class, "testJob", "test", new HashMap());

        try {
            scheduler.scheduleJob(jobDetail, buildJobTrigger("1 * * * * ?"));
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
