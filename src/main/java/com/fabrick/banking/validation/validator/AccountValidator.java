package com.fabrick.banking.validation.validator;

import com.fabrick.banking.dto.request.payment.AccountDTO;
import com.fabrick.banking.validation.annotation.ValidAccount;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AccountValidator implements ConstraintValidator<ValidAccount, AccountDTO> {


    @Override
    public boolean isValid(AccountDTO accountDTO, ConstraintValidatorContext constraintValidatorContext) {
        // TODO check if accountCode is SWIFT
            // TODO check bicCode if null/empty -> return false

        // TODO accountCode is IBAN; bicCode is optional

        return true;
    }
}
