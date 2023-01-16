package com.fabrick.banking.validation.validator;

import com.fabrick.banking.dto.request.payment.LegalPersonBeneficiaryDTO;
import com.fabrick.banking.dto.request.payment.NaturalPersonBeneficiaryDTO;
import com.fabrick.banking.validation.annotation.ValidLegalPersonBeneficiary;
import com.fabrick.banking.validation.annotation.ValidNaturalPersonBeneficiary;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class LegalPersonBeneficiaryValidator implements ConstraintValidator<ValidLegalPersonBeneficiary, LegalPersonBeneficiaryDTO> {

    @Override
    public boolean isValid(LegalPersonBeneficiaryDTO legalPersonBeneficiaryDTO, ConstraintValidatorContext constraintValidatorContext) {
        return legalPersonBeneficiaryDTO.getFiscalCode() != null;
    }
}
