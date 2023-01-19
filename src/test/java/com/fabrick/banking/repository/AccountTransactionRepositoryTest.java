package com.fabrick.banking.repository;

import com.fabrick.banking.dto.response.account.AccountTransactionResponse;
import com.fabrick.banking.entity.account.AccountTransaction;
import com.fabrick.banking.entity.account.Transaction;
import com.fabrick.banking.mapper.response.account.AccountTransactionDBResponseMapperImpl;
import com.fabrick.banking.repository.account.AccountTransactionRepository;
import com.fabrick.banking.util.ResourceUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;

import static com.fabrick.banking.constant.Constants.ACCOUNT_ID;


@DataJpaTest
class AccountTransactionRepositoryTest {

    private static final String                           PATH = "account/response/transactions.json";
    private final ObjectMapper                            mapper = new ObjectMapper();
    @Autowired
    private AccountTransactionRepository                  accountTransactionRepository;


    private final AccountTransactionDBResponseMapperImpl  accountTransactionDBResponseMapper = new AccountTransactionDBResponseMapperImpl();

    private AccountTransaction                            accountTransaction;

    @BeforeEach
    void setup() throws IOException {
        File file = ResourceUtil.getFile(PATH);
        AccountTransactionResponse accountTransactionResponse = mapper.readValue(
                file, AccountTransactionResponse.class);

        List<Transaction> transactions = accountTransactionDBResponseMapper.fromDTOList(accountTransactionResponse.getPayload().getList());

        accountTransaction = new AccountTransaction();
        accountTransaction.setAccountId(ACCOUNT_ID);
        accountTransaction.setTransactions(new HashSet<>(transactions));
    }

    @Test
    void test_save_account_transaction(){
        AccountTransaction accountTransactionDB = accountTransactionRepository.save(accountTransaction);
        Assertions.assertNotNull(accountTransactionDB);
    }

    @Test
    void test_get_account_transaction_by_accountId(){
        accountTransactionRepository.save(accountTransaction);

        Assertions.assertTrue(accountTransactionRepository.findByAccountId(ACCOUNT_ID).isPresent());
    }
}
