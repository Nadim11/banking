package com.fabrick.banking.validation.validator;

import com.fabrick.banking.dto.request.payment.PaymentTransferRequest;
import com.fabrick.banking.validation.annotation.ValidPaymentTransfer;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PaymentTransferValidator implements ConstraintValidator<ValidPaymentTransfer, PaymentTransferRequest> {

    @Override
    public boolean isValid(PaymentTransferRequest paymentTransferRequest, ConstraintValidatorContext constraintValidatorContext) {
        return paymentTransferRequest.getIsInstant() || paymentTransferRequest.getExecutionDate() != null;
    }
}
