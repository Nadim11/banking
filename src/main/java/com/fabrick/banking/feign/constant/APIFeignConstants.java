package com.fabrick.banking.feign.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class APIFeignConstants {

    public static final String AUTH_SCHEMA = "Auth-Schema";
    public static final String API_KEY = "Api-Key";
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class AccountManagement {

        private static final String BASE_URL = "/api/gbs/banking/v4.0/accounts/{accountId}";
        public static final String ACCOUNT_BALANCE_URL = BASE_URL + "/balance";

        public static final String ACCOUNT_TRANSACTIONS_URL = BASE_URL + "/transactions";

        public static final String CLIENT_NAME = "accountManagement";
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class PaymentsMoneyTransfer{
        public static final String CREATE_MONEY_TRANSFER = "";
    }
}
