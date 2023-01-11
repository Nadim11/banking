package com.fabrick.banking.feign.config;

import feign.RequestInterceptor;
import feign.Retryer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import static com.fabrick.banking.feign.constant.APIFeignConstants.API_KEY;
import static com.fabrick.banking.feign.constant.APIFeignConstants.AUTH_SCHEMA;

public class FeignConfig {

    @Value("${api.feign.credentials.Auth-Schema}")
    private String authSchema;

    @Value("${api.feign.credentials.Api-Key}")
    private String apiKey;

    @Bean
    public RequestInterceptor requestInterceptor() {
        return requestTemplate -> {
            requestTemplate.header(AUTH_SCHEMA, authSchema);
            requestTemplate.header(API_KEY, apiKey);
        };
    }

    @Bean
    public Retryer retryer(){
        // we can implement our custom retryer
        return new Retryer.Default();
    }
}
