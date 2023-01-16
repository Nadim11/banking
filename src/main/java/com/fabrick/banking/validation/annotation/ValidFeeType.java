package com.fabrick.banking.validation.annotation;

import com.fabrick.banking.validation.validator.FeeTypeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Constraint(validatedBy = FeeTypeValidator.class)
@Documented
@Target(ElementType.FIELD)
public @interface ValidFeeType {

    String message() default "Invalid Fee Type";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
