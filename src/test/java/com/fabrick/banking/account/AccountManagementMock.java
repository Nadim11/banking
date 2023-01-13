package com.fabrick.banking.account;

import com.fabrick.banking.feign.constant.APIFeignConstants;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.springframework.http.HttpStatus;

import java.io.IOException;

import static java.nio.charset.Charset.defaultCharset;
import static org.springframework.util.StreamUtils.copyToString;


public class AccountManagementMock {

    public static void setupMockAccountBalanceResponse(WireMockServer wireMockServer) throws IOException {
        wireMockServer
                .stubFor(
                        WireMock.get(
                                WireMock.urlEqualTo(APIFeignConstants.AccountManagement.ACCOUNT_BALANCE_URL)
                                )
                                .willReturn(WireMock.aResponse()
                                        .withStatus(HttpStatus.OK.value())
                                        .withBody(
                                                copyToString(
                                                        AccountManagementMock.class.getClassLoader().getResourceAsStream("account/balance.json"),
                                                        defaultCharset()
                                                )
                                        )
                                )
                );

    }
}
