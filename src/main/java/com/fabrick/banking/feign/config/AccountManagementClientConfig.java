package com.fabrick.banking.feign.config;

import com.fabrick.banking.feign.decoder.AccountManagementDecoder;
import com.fabrick.banking.feign.decoder.AccountManagementErrorDecoder;
import feign.Retryer;
import feign.codec.Decoder;
import org.springframework.context.annotation.Bean;

public class AccountManagementClientConfig {


    @Bean
    public AccountManagementErrorDecoder accountManagementRestErrorDecoder(){
        return new AccountManagementErrorDecoder();
    }

    @Bean
    public Decoder decoder(){
        return new AccountManagementDecoder();
    }

    @Bean
    public Retryer retryer(){
        // we can implement our custom retryer
        return new Retryer.Default();
    }
}
