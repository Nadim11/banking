package com.fabrick.banking.repository.account;

import com.fabrick.banking.entity.account.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountTransactionRepository extends JpaRepository<Transaction, Integer> {
}
