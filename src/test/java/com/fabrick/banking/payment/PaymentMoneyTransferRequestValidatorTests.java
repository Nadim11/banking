package com.fabrick.banking.payment;

import com.fabrick.banking.dto.request.payment.PaymentTransferRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.io.IOException;
import java.util.Set;

@SpringBootTest
@ActiveProfiles("test")
class PaymentMoneyTransferRequestValidatorTests {

    private static final int EXPECTED_0 = 0;
    private static final int EXPECTED_1 = 1;
    private static final int EXPECTED_2 = 2;

    private static final int EXPECTED_4 = 4;

    private static final String RANDOM_LONG_STRING_80_CHARS = "NaHOXJKEyoUmGVHLNSvpNaHOXJKEyoUmGVHLNSvpNaHOXJKEyoUmGVHLNSvpNaHOXJKEyoUmGVHLNSvp";
    private ValidatorFactory validatorFactory;
    private Validator validator;

    private final PaymentTransferRequestBuilder builder = new PaymentTransferRequestBuilder();
    @BeforeEach
    public void createValidator() {
        validatorFactory = Validation.buildDefaultValidatorFactory();
        validator = validatorFactory.getValidator();
    }

    @Test
    void test_payment_money_transfer_valid_request() throws IOException {
        PaymentTransferRequest request = builder.getValidRequest();

        Set<ConstraintViolation<PaymentTransferRequest>> violations = validator.validate(request);

        Assertions.assertEquals(EXPECTED_0, violations.size());

    }

    @Test
    void test_payment_money_transfer_invalid_creditor() throws IOException {
        PaymentTransferRequest request = builder.getRequestWithInvalidCreditor();

        Set<ConstraintViolation<PaymentTransferRequest>> violations = validator.validate(request);

        Assertions.assertEquals(EXPECTED_2, violations.size());

    }

    @Test
    void test_payment_money_transfer_invalid_creditor_name_length() throws IOException {
        PaymentTransferRequest request = builder.getValidRequest();

        request.getCreditor().setName(RANDOM_LONG_STRING_80_CHARS);

        Set<ConstraintViolation<PaymentTransferRequest>> violations = validator.validate(request);

        Assertions.assertEquals(EXPECTED_1, violations.size());

    }

    @Test
    void test_payment_money_transfer_invalid_creditor_address_address_length() throws IOException {
        PaymentTransferRequest request = builder.getValidRequest();

        request.getCreditor().getAddress().setAddress(RANDOM_LONG_STRING_80_CHARS);

        Set<ConstraintViolation<PaymentTransferRequest>> violations = validator.validate(request);

        Assertions.assertEquals(EXPECTED_1, violations.size());

    }

    @Test
    void test_payment_money_transfer_invalid_description_length() throws IOException {
        PaymentTransferRequest request = builder.getValidRequest();

        request.setDescription(RANDOM_LONG_STRING_80_CHARS + RANDOM_LONG_STRING_80_CHARS);

        Set<ConstraintViolation<PaymentTransferRequest>> violations = validator.validate(request);

        Assertions.assertEquals(EXPECTED_1, violations.size());

    }

    @Test
    void test_payment_money_transfer_invalid_executionDate_and_description_and_amount_currency() throws IOException {
        PaymentTransferRequest request = builder.getRequestWithInvalidExecutionDateAndDescriptionAndAmountAndCurrency();

        Set<ConstraintViolation<PaymentTransferRequest>> violations = validator.validate(request);

        Assertions.assertEquals(EXPECTED_4, violations.size());

    }

    @Test
    void test_invalid_taxRelief_BeneficiaryType_NATURAL_PERSON_BUT_NATURAL_PERSON_BENEFICIARY_IS_NULL() throws IOException {
        PaymentTransferRequest request = builder.getValidRequest();

        request.getTaxRelief().setNaturalPersonBeneficiary(null);

        Set<ConstraintViolation<PaymentTransferRequest>> violations = validator.validate(request);

        Assertions.assertEquals(EXPECTED_1, violations.size());

    }

    @Test
    void test_invalid_taxRelief_BeneficiaryType_LEGAL_PERSON_BUT_LEGAL_PERSON_BENEFICIARY_IS_NULL() throws IOException {
        PaymentTransferRequest request = builder.getValidRequest();

        request.getTaxRelief().setBeneficiaryType("LEGAL_PERSON");
        request.getTaxRelief().setLegalPersonBeneficiary(null);

        Set<ConstraintViolation<PaymentTransferRequest>> violations = validator.validate(request);

        Assertions.assertEquals(EXPECTED_1, violations.size());

    }

}
