package com.fabrick.banking.config;

import com.fabrick.banking.constant.SwaggerConstant;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(info = @Info(title = SwaggerConstant.TITLE, description = SwaggerConstant.DESCRIPTION))
@Configuration
public class SwaggerConfig {
}
