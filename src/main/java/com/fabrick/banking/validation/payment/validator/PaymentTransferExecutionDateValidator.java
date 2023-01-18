package com.fabrick.banking.validation.payment.validator;

import com.fabrick.banking.dto.request.payment.PaymentTransferRequest;
import com.fabrick.banking.validation.payment.annotation.ValidPaymentTransferExecutionDate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PaymentTransferExecutionDateValidator implements ConstraintValidator<ValidPaymentTransferExecutionDate, PaymentTransferRequest> {

    @Override
    public boolean isValid(PaymentTransferRequest paymentTransferRequest, ConstraintValidatorContext constraintValidatorContext) {
        return paymentTransferRequest.getIsInstant() || paymentTransferRequest.getExecutionDate() != null;
    }
}
