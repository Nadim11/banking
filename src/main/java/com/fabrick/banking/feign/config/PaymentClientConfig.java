package com.fabrick.banking.feign.config;

import com.fabrick.banking.feign.decoder.PaymentDecoder;
import com.fabrick.banking.feign.decoder.PaymentErrorDecoder;
import feign.codec.Decoder;
import feign.codec.ErrorDecoder;
import org.springframework.context.annotation.Bean;

public class PaymentClientConfig {

    @Bean
    public Decoder paymentDecoder(){
        return new PaymentDecoder();
    }

    @Bean
    public ErrorDecoder paymentErrorDecoder(){
        return new PaymentErrorDecoder();
    }
}
