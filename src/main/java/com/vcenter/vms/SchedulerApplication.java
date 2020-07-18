package com.vcenter.vms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@ComponentScan(basePackages = {"com.vcenter.vms"})
@SpringBootApplication
public class SchedulerApplication {

    public static void main (String[] args) {
        SpringApplication.run(SchedulerApplication.class, args);
    }
}
