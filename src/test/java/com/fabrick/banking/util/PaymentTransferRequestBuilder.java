package com.fabrick.banking.util;

import com.fabrick.banking.dto.request.payment.PaymentTransferRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;

public class PaymentTransferRequestBuilder {

    private static final String BASE_PATH = "/payment/money-transfer/request";

    private static final ObjectMapper mapper = new ObjectMapper().registerModule(new JavaTimeModule());

    public static PaymentTransferRequest getValidRequest() throws IOException {
        File resource = ResourceUtil.getFile(BASE_PATH + "/valid.json");
        return mapper.readValue(resource, PaymentTransferRequest.class);
    }

    public static PaymentTransferRequest getRequestWithInvalidCreditor() throws IOException {
        File resource = ResourceUtil.getFile(BASE_PATH + "/invalid-creditor.json");
        return mapper.readValue(resource, PaymentTransferRequest.class);
    }

    public static PaymentTransferRequest getRequestWithInvalidExecutionDateAndDescriptionAndAmountAndCurrency() throws IOException {
        File resource = ResourceUtil.getFile(BASE_PATH + "/invalid.json");
        return mapper.readValue(resource, PaymentTransferRequest.class);
    }
}
