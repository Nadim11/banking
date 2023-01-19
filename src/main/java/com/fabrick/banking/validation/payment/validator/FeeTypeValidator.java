package com.fabrick.banking.validation.payment.validator;

import com.fabrick.banking.enumerable.FeeType;
import com.fabrick.banking.validation.payment.annotation.ValidFeeType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FeeTypeValidator implements ConstraintValidator<ValidFeeType, String> {

    @Override
    public boolean isValid(String feeType, ConstraintValidatorContext constraintValidatorContext) {
        return FeeType.contains(feeType);
    }
}
