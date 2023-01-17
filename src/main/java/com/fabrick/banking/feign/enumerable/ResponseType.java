package com.fabrick.banking.feign.enumerable;

import com.fabrick.banking.feign.model.response.account.AccountBalanceClientResponse;
import com.fabrick.banking.feign.model.response.account.AccountTransactionClientResponse;
import com.fabrick.banking.feign.model.response.payment.PaymentTransferClientResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseType {

    ACCOUNT_BALANCE_CLIENT_RESPONSE(AccountBalanceClientResponse.class.getName()),
    ACCOUNT_TRANSACTION_CLIENT_RESPONSE(AccountTransactionClientResponse.class.getName()),

    PAYMENT_CREATE_MONEY_TRANSFER_RESPONSE(PaymentTransferClientResponse.class.getName());


    private final String name;
}
