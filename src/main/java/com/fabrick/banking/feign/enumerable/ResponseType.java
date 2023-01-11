package com.fabrick.banking.feign.enumerable;

import com.fabrick.banking.feign.response.account.AccountBalanceClientResponse;
import com.fabrick.banking.feign.response.account.AccountTransactionClientResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseType {

    ACCOUNT_BALANCE_CLIENT_RESPONSE(AccountBalanceClientResponse.class.getName()),
    ACCOUNT_TRANSACTION_CLIENT_RESPONSE(AccountTransactionClientResponse.class.getName());


    private String name;
}
