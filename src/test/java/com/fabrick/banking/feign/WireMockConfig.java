package com.fabrick.banking.feign;

import com.github.tomakehurst.wiremock.WireMockServer;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@TestConfiguration
public class WireMockConfig {

    private static final int PORT = 7070;
    @Bean(initMethod = "start", destroyMethod = "stop")
    public WireMockServer mockClientService(){
        return new WireMockServer(PORT);
    }

}
