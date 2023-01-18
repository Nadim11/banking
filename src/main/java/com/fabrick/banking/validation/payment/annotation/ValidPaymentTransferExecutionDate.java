package com.fabrick.banking.validation.payment.annotation;

import com.fabrick.banking.validation.payment.validator.PaymentTransferExecutionDateValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = PaymentTransferExecutionDateValidator.class)
@Documented
public @interface ValidPaymentTransferExecutionDate {

    String message() default "Execution Date is required";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    @Target({TYPE, ANNOTATION_TYPE})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        ValidPaymentTransferExecutionDate[] value();
    }
}
