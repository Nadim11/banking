package com.fabrick.banking.feign.config;

import com.fabrick.banking.feign.decoder.AccountManagementDecoder;
import com.fabrick.banking.feign.decoder.AccountManagementErrorDecoder;
import feign.codec.Decoder;
import org.springframework.context.annotation.Bean;

public class AccountManagementClientConfig {


    @Bean
    public AccountManagementErrorDecoder accountManagementErrorDecoder(){
        return new AccountManagementErrorDecoder();
    }

    @Bean
    public Decoder accountManagementDecoder(){
        return new AccountManagementDecoder();
    }

}
