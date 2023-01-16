package com.fabrick.banking.validation.validator;

import com.fabrick.banking.dto.request.payment.TaxReliefDTO;
import com.fabrick.banking.enumerable.BeneficiaryType;
import com.fabrick.banking.validation.annotation.ValidTaxRelief;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TaxReliefValidator implements ConstraintValidator<ValidTaxRelief, TaxReliefDTO> {
    @Override
    public void initialize(ValidTaxRelief constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(TaxReliefDTO taxReliefDTO, ConstraintValidatorContext constraintValidatorContext) {
        boolean isValid = false;

        if(taxReliefDTO.getBeneficiaryType().equals(BeneficiaryType.NATURAL_PERSON.name())){
            NaturalPersonBeneficiaryValidator naturalPersonBeneficiaryValidator = new NaturalPersonBeneficiaryValidator();
            isValid = taxReliefDTO.getNaturalPersonBeneficiary() != null && naturalPersonBeneficiaryValidator.isValid(taxReliefDTO.getNaturalPersonBeneficiary(), constraintValidatorContext);
        }else if(taxReliefDTO.getBeneficiaryType().equals(BeneficiaryType.LEGAL_PERSON.name())){
            LegalPersonBeneficiaryValidator legalPersonBeneficiaryValidator = new LegalPersonBeneficiaryValidator();
            isValid = taxReliefDTO.getLegalPersonBeneficiary() != null && legalPersonBeneficiaryValidator.isValid(taxReliefDTO.getLegalPersonBeneficiary(), constraintValidatorContext);
        }

        return isValid;
    }
}
