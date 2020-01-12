package com.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;


/**
 * describe:
 *
 * @author douyanfeng
 * @date 2020/01/08
 */

@EnableScheduling
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
          SpringApplication.run(Application.class,args);
    }



}
