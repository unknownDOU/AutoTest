package com.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PreDestroy;

/**
 * describe:
 *
 * @author douyanfeng
 * @date 2019/12/30
 */

@SpringBootApplication
@EnableScheduling
public class application {

    private static ConfigurableApplicationContext context;

    public static void main(String[] args) {
        application.context = SpringApplication.run(application.class,args);
    }

    @PreDestroy
    public void  close(){
        application.context.close();

    }
}
