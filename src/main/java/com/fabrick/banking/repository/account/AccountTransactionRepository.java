package com.fabrick.banking.repository.account;

import com.fabrick.banking.entity.account.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Integer> {

    Optional<AccountTransaction> findByAccountId(String accountId);
}
