package com.fabrick.banking.enumerable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class FeeTypeTests {


    @Test
    void test_valid_SHA(){
        Assertions.assertTrue(FeeType.contains("SHA"));
    }
    @Test
    void test_valid_OUR(){
        Assertions.assertTrue(FeeType.contains("OUR"));
    }
    @Test
    void test_valid_BEN(){
        Assertions.assertTrue(FeeType.contains("BEN"));
    }

    @Test
    void test_invalid(){
        Assertions.assertFalse(FeeType.contains("INVALID"));
    }
}
