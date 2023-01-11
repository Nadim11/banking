package com.fabrick.banking.feign.client;

import com.fabrick.banking.feign.config.FeignConfig;
import com.fabrick.banking.feign.config.PaymentClientConfig;
import com.fabrick.banking.feign.constant.APIFeignConstants;
import com.fabrick.banking.feign.model.request.payment.PaymentTransferClientRequest;
import com.fabrick.banking.feign.model.response.payment.PaymentTransferClientResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        value = APIFeignConstants.PaymentsMoneyTransfer.CLIENT_NAME,
        url = "${api.feign.base-url}",
        configuration = {FeignConfig.class, PaymentClientConfig.class}
)
public interface PaymentClient {

    @PostMapping(APIFeignConstants.PaymentsMoneyTransfer.CREATE_MONEY_TRANSFER)
    PaymentTransferClientResponse createPaymentTransfer(
                @RequestHeader(name = APIFeignConstants.PaymentsMoneyTransfer.X_TIME_ZONE) String xTimeZone,
                @PathVariable("accountId") String accountId,
                @RequestBody PaymentTransferClientRequest request
            );
}
