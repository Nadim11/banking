package com.fabrick.banking.feign.account;

import com.fabrick.banking.feign.WireMockConfig;
import com.fabrick.banking.feign.client.AccountManagementClient;
import com.fabrick.banking.feign.model.request.account.AccountTransactionClientRequest;
import com.fabrick.banking.feign.model.response.account.AccountBalanceClientResponse;
import com.fabrick.banking.feign.model.response.account.AccountTransactionClientResponse;
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
class AccountManagementTests {


    @Autowired
    private WireMockServer mockClientService;

    @Autowired
    private AccountManagementClient accountManagementClient;

    @BeforeEach
    void setUp() throws IOException {
        AccountManagementMocks.setUpAccountBalanceMockResponse(mockClientService);
        AccountManagementMocks.setUpAccountTransactionsMockResponse(mockClientService);
    }
    @Test
    void test_get_account_balance(){
        AccountBalanceClientResponse accountBalance = accountManagementClient.getAccountBalance(ACCOUNT_ID);
        Assertions.assertNotNull(accountBalance);
    }

    @Test
    void test_get_account_transactions(){
        AccountTransactionClientResponse accountTransactions = accountManagementClient.getAccountTransactions(
                ACCOUNT_ID,
                AccountTransactionClientRequest.builder().build()
                );
        Assertions.assertNotNull(accountTransactions);
    }
}
