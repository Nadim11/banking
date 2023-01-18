package com.fabrick.banking.feign.payment;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.nio.charset.Charset;

import static com.fabrick.banking.constant.Constants.BASE_URL_MOCK;
import static org.springframework.util.StreamUtils.copyToString;

public class PaymentTransferMocks {

    private static final String BASE_PATH = "payment/money-transfer/response";
    public static void setUpPaymentMoneyTrasferRequest(WireMockServer mockService) throws IOException {
        mockService
                .stubFor(
                        WireMock.post(WireMock.urlEqualTo(BASE_URL_MOCK + "/payments/money-transfers")
                                )
                                .willReturn(WireMock.aResponse()
                                        .withStatus(
                                                HttpStatus.OK.value())
                                        .withBody(
                                                copyToString(
                                                        PaymentTransferMocks.class.getClassLoader().getResourceAsStream(BASE_PATH + "/create-money-transfer.json"),
                                                        Charset.defaultCharset()
                                                )
                                        )
                                )
                );

    }

}
