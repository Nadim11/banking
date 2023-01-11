package com.fabrick.banking.feign.client;

import com.fabrick.banking.feign.config.AccountManagementClientConfig;
import com.fabrick.banking.feign.config.FeignConfig;
import com.fabrick.banking.feign.constant.APIFeignConstants;
import com.fabrick.banking.feign.model.request.account.AccountTransactionClientRequest;
import com.fabrick.banking.feign.model.response.account.AccountBalanceClientResponse;
import com.fabrick.banking.feign.model.response.account.AccountTransactionClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.SpringQueryMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
        value = APIFeignConstants.AccountManagement.CLIENT_NAME,
        url = "${api.feign.base-url}",
        configuration = {FeignConfig.class, AccountManagementClientConfig.class}
)
public interface AccountManagementClient {
    @GetMapping(APIFeignConstants.AccountManagement.ACCOUNT_BALANCE_URL)
    AccountBalanceClientResponse getAccountBalance(@PathVariable("accountId") String accountId);

    @GetMapping(APIFeignConstants.AccountManagement.ACCOUNT_TRANSACTIONS_URL)
    AccountTransactionClientResponse getAccountTransactions(@PathVariable("accountId") String accountId, @SpringQueryMap AccountTransactionClientRequest request);
}
