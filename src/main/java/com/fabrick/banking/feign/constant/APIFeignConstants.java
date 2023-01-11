package com.fabrick.banking.feign.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class APIFeignConstants {

    public static final String AUTH_SCHEMA = "Auth-Schema";
    public static final String API_KEY = "Api-Key";

    private static final String BASE_URL = "/api/gbs/banking/v4.0/accounts/{accountId}";
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class AccountManagement {

        public static final String ACCOUNT_BALANCE_URL = BASE_URL + "/balance";

        public static final String ACCOUNT_TRANSACTIONS_URL = BASE_URL + "/transactions";

        public static final String CLIENT_NAME = "accountManagement";
    }

    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class PaymentsMoneyTransfer{
        public static final String CREATE_MONEY_TRANSFER = BASE_URL + "/payments/money-transfers";
        public static final String CLIENT_NAME = "payment";

        public static final String X_TIME_ZONE = "X-Time-Zone";
    }
}
