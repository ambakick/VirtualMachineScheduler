package com.vcenter.vms.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@ComponentScan(basePackages = {"com.vcenter.vms"})
public class SchedulerConfig {

}
