package project.quartztest.job;

import lombok.extern.slf4j.Slf4j;
import org.quartz.InterruptableJob;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.UnableToInterruptJobException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.stereotype.Component;
import project.quartztest.webclient.RestApiClient;

@Slf4j
@Component
public class QuartzJob extends QuartzJobBean implements InterruptableJob {

    @Autowired
    RestApiClient restApiClient;

    @Override
    public void interrupt() throws UnableToInterruptJobException {

    }

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {

        //TODO thread 및 비동기 논블로킹 처리 구현 해야함
        restApiClient.insertHypervisor();
        restApiClient.insertPodList();
        restApiClient.insertHpaList();

    }
}
