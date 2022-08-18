package project.quartztest.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.InterruptableJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.UnableToInterruptJobException;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Component
public class QuartzJobTest extends QuartzJobBean implements InterruptableJob {

    @Override
    public void interrupt() throws UnableToInterruptJobException {

    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        Date date = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy년 MM월 dd일");
        SimpleDateFormat sdf2 = new SimpleDateFormat("HH시 mm분 ss초");
        String currentDate = sdf1.format(date);
        String currentTime = sdf2.format(date);

        /*
         *         execute() method 에 로직 추가
         */
        log.info("========= QuartzJob execute() method Start !!! =========");
        log.info("QuartzJob Start Time >>> {}", currentDate + " " + currentTime);
    }
}
