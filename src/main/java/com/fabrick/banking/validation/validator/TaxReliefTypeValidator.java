package com.fabrick.banking.validation.validator;

import com.fabrick.banking.enumerable.TaxReliefType;
import com.fabrick.banking.validation.annotation.ValidTaxReliefType;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TaxReliefTypeValidator implements ConstraintValidator<ValidTaxReliefType, String> {

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = true;

        if(s != null){
            isValid = TaxReliefType.contains(s);
        }

        return isValid;
    }
}
