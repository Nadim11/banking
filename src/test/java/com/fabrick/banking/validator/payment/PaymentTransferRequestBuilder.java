package com.fabrick.banking.validator.payment;

import com.fabrick.banking.dto.request.payment.PaymentTransferRequest;
import com.fabrick.banking.util.ResourceUtil;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class PaymentTransferRequestBuilder {

    private static final String BASE_PATH = "/payment/money-transfer";

    private final ObjectMapper mapper = new ObjectMapper();

    public PaymentTransferRequest getValidRequest() throws IOException {
        File resource = ResourceUtil.getFile(BASE_PATH + "/valid.json");
        return mapper.readValue(resource, PaymentTransferRequest.class);
    }

    public PaymentTransferRequest getRequestWithInvalidCreditor() throws IOException {
        File resource = ResourceUtil.getFile(BASE_PATH + "/invalid-creditor.json");
        return mapper.readValue(resource, PaymentTransferRequest.class);
    }

    public PaymentTransferRequest getRequestWithInvalidExecutionDateAndDescriptionAndAmountAndCurrency() throws IOException {
        File resource = ResourceUtil.getFile(BASE_PATH + "/invalid.json");
        return mapper.readValue(resource, PaymentTransferRequest.class);
    }
}
