package com.fabrick.banking.validation.payment.annotation;

import com.fabrick.banking.validation.payment.validator.LegalPersonBeneficiaryValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Constraint(validatedBy = LegalPersonBeneficiaryValidator.class)
@Documented
@Target(ElementType.FIELD)
public @interface ValidLegalPersonBeneficiary {

    String message() default "Invalid Legal Person Beneficiary";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
