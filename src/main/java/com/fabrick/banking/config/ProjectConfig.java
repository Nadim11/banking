package com.fabrick.banking.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "com.fabrick.banking.feign")
public class ProjectConfig {
}
