package com.fabrick.banking.controller;

import com.fabrick.banking.dto.request.payment.PaymentTransferRequest;
import com.fabrick.banking.dto.response.payment.PaymentTransferResponse;
import com.fabrick.banking.feign.constant.APIFeignConstants;
import com.fabrick.banking.service.payment.PaymentTransferServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/banking/v1/payments")
@RequiredArgsConstructor
public class PaymentTransferController {

    private final PaymentTransferServiceImpl paymentTransferService;

    @PostMapping("/{accountId}/money-transfers")
    public ResponseEntity<PaymentTransferResponse> createPaymentTransfer(
            @RequestHeader(APIFeignConstants.PaymentsMoneyTransfer.X_TIME_ZONE) String xTimeZone,
            @PathVariable(name = "accountId") String accountId,
            @RequestBody PaymentTransferRequest request
            ){
        return ResponseEntity
                .ok()
                .body(paymentTransferService.createPaymentTransfer(xTimeZone, accountId, request));
    }
}
