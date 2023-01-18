package com.fabrick.banking.feign.account;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.http.HttpStatus;

import java.io.IOException;
import java.nio.charset.Charset;

import static com.fabrick.banking.constant.Constants.BASE_URL_MOCK;
import static org.springframework.util.StreamUtils.copyToString;

public class AccountManagementMocks {

    private static final String BASE_PATH = "account/response";
    public static void setUpAccountBalanceMockResponse(WireMockServer mockService) throws IOException {
        mockService
                .stubFor(
                        WireMock.get(WireMock.urlEqualTo(BASE_URL_MOCK + "/balance")
                        )
                                .willReturn(WireMock.aResponse()
                                        .withStatus(
                                                HttpStatus.OK.value())
                                                .withBody(
                                                        copyToString(
                                                                AccountManagementMocks.class.getClassLoader().getResourceAsStream(BASE_PATH + "/balance.json"),
                                                                Charset.defaultCharset()
                                                        )
                                                )
                                        )
                                );
    }

    public static void setUpAccountTransactionsMockResponse(WireMockServer mockService) throws IOException {
        mockService
                .stubFor(
                        WireMock.get(WireMock.urlEqualTo(BASE_URL_MOCK + "/transactions")
                                )
                                .willReturn(WireMock.aResponse()
                                        .withStatus(
                                                HttpStatus.OK.value())
                                        .withBody(
                                                copyToString(
                                                        AccountManagementMocks.class.getClassLoader().getResourceAsStream(BASE_PATH + "/transactions.json"),
                                                        Charset.defaultCharset()
                                                )
                                        )
                                )
                );
    }
}
