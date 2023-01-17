package com.fabrick.banking.validation.payment.validator;

import com.fabrick.banking.dto.request.payment.LegalPersonBeneficiaryDTO;
import com.fabrick.banking.validation.payment.annotation.ValidLegalPersonBeneficiary;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LegalPersonBeneficiaryValidator implements ConstraintValidator<ValidLegalPersonBeneficiary, LegalPersonBeneficiaryDTO> {

    @Override
    public boolean isValid(LegalPersonBeneficiaryDTO legalPersonBeneficiaryDTO, ConstraintValidatorContext constraintValidatorContext) {
        return legalPersonBeneficiaryDTO.getFiscalCode() != null;
    }
}
