package com.fabrick.banking.feign;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class WireMockConfig {

    @Value("${feign.port}")
    private int port;
    @Bean(initMethod = "start", destroyMethod = "stop")
    public WireMockServer mockClientService(){
        return new WireMockServer(port);
    }

}
