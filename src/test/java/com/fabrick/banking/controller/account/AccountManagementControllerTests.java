package com.fabrick.banking.controller.account;

import com.fabrick.banking.controller.AccountManagementController;
import com.fabrick.banking.dto.response.account.AccountTransactionResponse;
import com.fabrick.banking.service.account.AccountManagementServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static com.fabrick.banking.constant.APIConstant.AccountManagement.*;
import static com.fabrick.banking.constant.Constants.ACCOUNT_ID;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AccountManagementController.class)
class AccountManagementControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountManagementServiceImpl accountManagementService;

    @Test
    void test_get_balance_should_return_success() throws Exception {
        when(
                accountManagementService.getAccountBalance(Mockito.anyString())
        ).thenReturn(Mockito.any());

        this.mockMvc.perform(
                get(BASE_URL + ACCOUNT_BALANCE, ACCOUNT_ID)
        )
                .andExpect(
                        status().isOk()
                );
    }

    @Test
    void test_get_transactions_should_return_success() throws Exception {
        when(
                accountManagementService.getAccountTransactions(Mockito.anyString(), Mockito.any())
        ).thenReturn(new AccountTransactionResponse());

        this.mockMvc.perform(
                        get(BASE_URL + ACCOUNT_TRANSACTIONS, ACCOUNT_ID)
                                .queryParam("fromAccountingDate", "2019-01-01")
                                .queryParam("toAccountingDate", "2020-01-01")
                )
                .andExpect(
                        status().isOk()
                );
    }

    @Test
    void test_get_transactions_should_return_badRequest_invalid_date() throws Exception {
        when(
                accountManagementService.getAccountTransactions(Mockito.anyString(), Mockito.any())
        ).thenReturn(new AccountTransactionResponse());

        this.mockMvc.perform(
                        get(BASE_URL + ACCOUNT_TRANSACTIONS, ACCOUNT_ID)
                                .queryParam("fromAccountingDate", "2019-01-01")
                                .queryParam("toAccountingDate", "2020/01-01")
                )
                .andExpect(
                        status().isBadRequest()
                );
    }

    @Test
    void test_get_transactions_should_return_badRequest_missing_date() throws Exception {
        when(
                accountManagementService.getAccountTransactions(Mockito.anyString(), Mockito.any())
        ).thenReturn(new AccountTransactionResponse());

        this.mockMvc.perform(
                        get(BASE_URL + ACCOUNT_TRANSACTIONS, ACCOUNT_ID)
                                .queryParam("fromAccountingDate", "2019-01-01")
                )
                .andExpect(
                        status().isBadRequest()
                );
    }
}
