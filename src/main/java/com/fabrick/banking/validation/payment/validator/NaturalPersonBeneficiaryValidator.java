package com.fabrick.banking.validation.payment.validator;

import com.fabrick.banking.dto.request.payment.NaturalPersonBeneficiaryDTO;
import com.fabrick.banking.validation.payment.annotation.ValidNaturalPersonBeneficiary;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NaturalPersonBeneficiaryValidator implements ConstraintValidator<ValidNaturalPersonBeneficiary, NaturalPersonBeneficiaryDTO> {

    @Override
    public boolean isValid(NaturalPersonBeneficiaryDTO naturalPersonBeneficiaryDTO, ConstraintValidatorContext constraintValidatorContext) {
        return naturalPersonBeneficiaryDTO.getFiscalCode1() != null;
    }
}
