package com.fabrick.banking.constant;

public class SwaggerConstant {

    public static final String TITLE                                = "FABRICK";
    public static final String DESCRIPTION                          = "Available APIs are described below";

    public static class AccountManagement{
        public static final String BALANCE_OPERATION_SUMMARY        = "Get Account Balance for an accountId";
        public static final String TRANSACTIONS_OPERATION_SUMMARY   = "Get List of Transactions for an accountId";
    }
    public static class PaymentTransfer{
        public static final String OPERATION_SUMMARY                = "Create Money Transfer";
    }
}
