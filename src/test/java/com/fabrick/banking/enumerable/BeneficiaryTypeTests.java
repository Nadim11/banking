package com.fabrick.banking.enumerable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class BeneficiaryTypeTests {

    @Test
    void test_valid_NATURAL_PERSON(){
        Assertions.assertTrue(BeneficiaryType.contains("NATURAL_PERSON"));
    }

    @Test
    void test_valid_LEGAL_PERSON(){
        Assertions.assertTrue(BeneficiaryType.contains("LEGAL_PERSON"));
    }

    @Test
    void test_invalid(){
        Assertions.assertFalse(BeneficiaryType.contains("INVALID"));
    }
}
