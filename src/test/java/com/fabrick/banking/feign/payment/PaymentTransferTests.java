package com.fabrick.banking.feign.payment;

import com.fabrick.banking.feign.WireMockConfig;
import com.fabrick.banking.feign.client.PaymentTransferClient;
import com.fabrick.banking.feign.model.request.payment.PaymentTransferClientRequest;
import com.fabrick.banking.feign.model.response.payment.PaymentTransferClientResponse;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;

import static com.fabrick.banking.constant.Constants.ACCOUNT_ID;

@SpringBootTest
@ActiveProfiles("test")
@ContextConfiguration(classes = {WireMockConfig.class})
class PaymentTransferTests {

    private static final String X_TIME_ZONE = "Europe/Rome";
    @Autowired
    private WireMockServer mockClientService;

    @Autowired
    private PaymentTransferClient paymentTransferClient;

    @BeforeEach
    void setUp() throws IOException {
        PaymentTransferMocks.setUpPaymentMoneyTrasferRequest(mockClientService);
    }

    @Test
    void test_create_money_transfer(){
        PaymentTransferClientResponse paymentTransfer = paymentTransferClient.createPaymentTransfer(X_TIME_ZONE, ACCOUNT_ID, PaymentTransferClientRequest.builder().build());
        Assertions.assertNotNull(paymentTransfer);
    }
}
