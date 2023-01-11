package com.fabrick.banking.service;

import com.fabrick.banking.dto.request.AccountTransactionRequest;
import com.fabrick.banking.dto.response.account.AccountBalanceResponse;
import com.fabrick.banking.dto.response.account.AccountTransactionResponse;

public interface AccountManagementService {

    AccountBalanceResponse getAccountBalance(String accountId);

    AccountTransactionResponse getAccountTransactions(String accountId, AccountTransactionRequest request);
}
