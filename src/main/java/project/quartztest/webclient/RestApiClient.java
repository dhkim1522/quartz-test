package project.quartztest.webclient;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import project.quartztest.vo.HypervisorVO;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class RestApiClient {

    @Autowired
    WebClientConfig webClientConfig;

    public void insertHypervisor() {

        log.info(" ## insert Hypervisor !!");

        webClientConfig.webClient()
                    .post().uri("insert/hypervisor")
                    .accept(MediaType.APPLICATION_JSON)
                    .retrieve()
                    .bodyToMono(Object.class)
                    .block();

    }

    public void insertPodList() {

        log.info(" ## insert pod list !!");

        webClientConfig.webClient()
                .post().uri("insert/pod-list")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Object.class)
                .block();

    }

    public void insertHpaList() {

        log.info(" ## insert hpa list !!");

        webClientConfig.webClient()
                .post().uri("insert/hpa-list")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Object.class)
                .block();

    }

}
