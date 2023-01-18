package com.fabrick.banking.service.account;

import com.fabrick.banking.dto.request.account.AccountTransactionRequest;
import com.fabrick.banking.dto.response.account.AccountBalanceResponse;
import com.fabrick.banking.dto.response.account.AccountTransactionResponse;
import com.fabrick.banking.dto.response.account.AccountTransactionResponseDTO;
import com.fabrick.banking.entity.account.Transaction;
import com.fabrick.banking.feign.client.AccountManagementClient;
import com.fabrick.banking.mapper.request.account.AccountTransactionRequestMapperImpl;
import com.fabrick.banking.mapper.response.account.AccountBalanceResponseMapperImpl;
import com.fabrick.banking.mapper.response.account.AccountTransactionDBResponseMapperImpl;
import com.fabrick.banking.mapper.response.account.AccountTransactionResponseMapperImpl;
import com.fabrick.banking.repository.account.AccountTransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AccountManagementServiceImpl implements AccountManagementService{

    private final AccountManagementClient                   accountManagementClient;
    private final AccountBalanceResponseMapperImpl          accountBalanceResponseMapper;
    private final AccountTransactionRequestMapperImpl       accountTransactionRequestMapper;
    private final AccountTransactionResponseMapperImpl      accountTransactionResponseMapper;

    private final AccountTransactionDBResponseMapperImpl    accountTransactionDBResponseMapper;

    private final AccountTransactionRepository              accountTransactionRepository;

    @Override
    public AccountBalanceResponse getAccountBalance(String accountId) {
        return accountBalanceResponseMapper.toDTO(accountManagementClient.getAccountBalance(accountId));
    }

    @Override
    @Cacheable(value = "transactions", key = "#accountId")
    public AccountTransactionResponse getAccountTransactions(String accountId, AccountTransactionRequest request) {
        AccountTransactionResponse response = accountTransactionResponseMapper.toDTO(accountManagementClient.getAccountTransactions(accountId, accountTransactionRequestMapper.fromDTO(request)));

        List<AccountTransactionResponseDTO> list =  response.getPayload().getList();
        if(!CollectionUtils.isEmpty(list)){
            // map to entity and save to DB
            List<Transaction> transactions = accountTransactionDBResponseMapper.fromDTOList(list);

            accountTransactionRepository.saveAll(transactions);
        }

        return response;
    }
}
