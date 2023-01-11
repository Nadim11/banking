package com.fabrick.banking.service.payment;

import com.fabrick.banking.dto.request.payment.PaymentTransferRequest;
import com.fabrick.banking.dto.response.payment.PaymentTransferResponse;

public interface PaymentTransferService {

    PaymentTransferResponse createPaymentTransfer(String xTimeZone, String accountId, PaymentTransferRequest request);
}
