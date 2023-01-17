package com.fabrick.banking.validation.payment.annotation;

import com.fabrick.banking.validation.payment.validator.BeneficiaryTypeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Constraint(validatedBy = BeneficiaryTypeValidator.class)
@Documented
@Target(ElementType.FIELD)
public @interface ValidBeneficiaryType {

    String message() default "Invalid Beneficiary Type";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
