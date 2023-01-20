package com.fabrick.banking.controller;

import com.fabrick.banking.constant.APIConstant;
import com.fabrick.banking.constant.SwaggerConstant;
import com.fabrick.banking.dto.request.payment.PaymentTransferRequest;
import com.fabrick.banking.dto.response.payment.PaymentTransferResponse;
import com.fabrick.banking.feign.constant.APIFeignConstants;
import com.fabrick.banking.service.payment.PaymentTransferServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(APIConstant.PaymentMoneyTransfer.BASE_URL)
@RequiredArgsConstructor
public class PaymentTransferController {

    private final PaymentTransferServiceImpl paymentTransferService;

    @Operation(summary = SwaggerConstant.PaymentTransfer.OPERATION_SUMMARY)
    @PostMapping(APIConstant.PaymentMoneyTransfer.MONEY_TRANSFER)
    public ResponseEntity<PaymentTransferResponse> createPaymentTransfer(
            @RequestHeader(APIFeignConstants.PaymentsMoneyTransfer.X_TIME_ZONE) String xTimeZone,
            @PathVariable(name = "accountId") String accountId,
            @RequestBody @Valid PaymentTransferRequest request
            ){
        return ResponseEntity
                .ok()
                .body(paymentTransferService.createPaymentTransfer(xTimeZone, accountId, request));
    }
}
