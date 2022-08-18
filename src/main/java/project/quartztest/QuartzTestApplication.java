package project.quartztest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import project.quartztest.controller.BatchController;

@SpringBootApplication
public class QuartzTestApplication {

    @Autowired
    BatchController batchController;

    public static void main(String[] args) {
        SpringApplication.run(QuartzTestApplication.class, args);
    }

}
