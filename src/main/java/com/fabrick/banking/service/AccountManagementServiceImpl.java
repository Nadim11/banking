package com.fabrick.banking.service;

import com.fabrick.banking.dto.request.AccountTransactionRequest;
import com.fabrick.banking.dto.response.account.AccountBalanceResponse;
import com.fabrick.banking.dto.response.account.AccountTransactionResponse;
import com.fabrick.banking.feign.client.AccountManagementClient;
import com.fabrick.banking.mapper.request.AccountTransactionRequestMapperImpl;
import com.fabrick.banking.mapper.response.AccountBalanceResponseMapperImpl;
import com.fabrick.banking.mapper.response.AccountTransactionResponseMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountManagementServiceImpl implements AccountManagementService{

    private final AccountManagementClient               accountManagementClient;
    private final AccountBalanceResponseMapperImpl      accountBalanceResponseMapper;
    private final AccountTransactionRequestMapperImpl   accountTransactionRequestMapper;
    private final AccountTransactionResponseMapperImpl  accountTransactionResponseMapper;

    @Override
    public AccountBalanceResponse getAccountBalance(String accountId) {
        return accountBalanceResponseMapper.toDTO(accountManagementClient.getAccountBalance(accountId));
    }

    @Override
    public AccountTransactionResponse getAccountTransactions(String accountId, AccountTransactionRequest request) {
        return accountTransactionResponseMapper.toDTO(accountManagementClient.getAccountTransactions(accountId, accountTransactionRequestMapper.fromDTO(request)));
    }
}
