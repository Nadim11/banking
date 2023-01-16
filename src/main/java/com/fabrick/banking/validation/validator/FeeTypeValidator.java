package com.fabrick.banking.validation.validator;

import com.fabrick.banking.enumerable.FeeType;
import com.fabrick.banking.validation.annotation.ValidFeeType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class FeeTypeValidator implements ConstraintValidator<ValidFeeType, String> {

    @Override
    public boolean isValid(String feeType, ConstraintValidatorContext constraintValidatorContext) {
       //TODO validate also if non-SEPA bank
        return FeeType.contains(feeType);
    }
}
