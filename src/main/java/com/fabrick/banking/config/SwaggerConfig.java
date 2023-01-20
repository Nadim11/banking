package com.fabrick.banking.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(info = @Info(title = "FABRICK", description = "Available APIs are described below"))
@Configuration
public class SwaggerConfig {
}
