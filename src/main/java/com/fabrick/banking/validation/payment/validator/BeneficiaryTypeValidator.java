package com.fabrick.banking.validation.payment.validator;

import com.fabrick.banking.enumerable.BeneficiaryType;
import com.fabrick.banking.validation.payment.annotation.ValidBeneficiaryType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class BeneficiaryTypeValidator implements ConstraintValidator<ValidBeneficiaryType, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return BeneficiaryType.contains(s);
    }
}
