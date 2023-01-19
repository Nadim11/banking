package com.fabrick.banking.service.account;

import com.fabrick.banking.dto.request.account.AccountTransactionRequest;
import com.fabrick.banking.dto.response.account.AccountBalanceResponse;
import com.fabrick.banking.dto.response.account.AccountTransactionResponse;
import com.fabrick.banking.dto.response.account.AccountTransactionResponseDTO;
import com.fabrick.banking.entity.account.AccountTransaction;
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

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountManagementServiceImpl implements AccountManagementService{

    private static final String TRANSACTIONS_CACHE_NAME = "transactions";
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
    @Cacheable(value = TRANSACTIONS_CACHE_NAME, key = "#accountId") // for this use case default cache is used (ConcurrentHashMap)
    public AccountTransactionResponse getAccountTransactions(String accountId, AccountTransactionRequest request) {
        AccountTransactionResponse response = accountTransactionResponseMapper.toDTO(accountManagementClient.getAccountTransactions(accountId, accountTransactionRequestMapper.fromDTO(request)));

        Optional<AccountTransaction> account = accountTransactionRepository.findByAccountId(accountId);

        List<AccountTransactionResponseDTO> list =  response.getPayload().getList();
        if(account.isEmpty() && !CollectionUtils.isEmpty(list)){
            List<Transaction> transactions = accountTransactionDBResponseMapper.fromDTOList(list);

            AccountTransaction accountToSave = AccountTransaction.builder()
                    .accountId(accountId)
                    .transactions(new HashSet<>(transactions))
                    .build();

            accountTransactionRepository.save(accountToSave);
        }

        return response;
    }
}
