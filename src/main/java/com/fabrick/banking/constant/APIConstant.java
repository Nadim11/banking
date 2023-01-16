package com.fabrick.banking.constant;

public class APIConstant {

    public static class AccountManagement{
        public static final String BASE_URL = "/api/banking/v1/accounts";
        public static final String ACCOUNT_BALANCE = "/{accountId}/balance";
        public static final String ACCOUNT_TRANSACTIONS = "/{accountId}/transactions";
    }

    public static class PaymentMoneyTransfer{
        public static final String BASE_URL = "/api/banking/v1/payments";
        public static final String MONEY_TRANSFER = "/{accountId}/money-transfers";
    }
}
