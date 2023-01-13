package com.fabrick.banking.account;

import com.fabrick.banking.config.WireMockConfig;
import com.fabrick.banking.feign.client.AccountManagementClient;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ActiveProfiles("test")
@EnableConfigurationProperties
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = { WireMockConfig.class })
class AccountManagementTests {

    @Autowired
    private WireMockServer feignMockServer;

    @Autowired
    private AccountManagementClient accountManagementClient;

    @BeforeEach
    void setUp() throws IOException {
        AccountManagementMock.setupMockAccountBalanceResponse(feignMockServer);
    }

    @Test
    void whenGetBooks_thenBooksShouldBeReturned() {
        assertNotNull(accountManagementClient.getAccountBalance("14537780"));
    }
}
