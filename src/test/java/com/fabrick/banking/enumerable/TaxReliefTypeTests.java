package com.fabrick.banking.enumerable;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class TaxReliefTypeTests {

    @Test
    void test_valid_INTERVENTI_SUPER_BONUS(){
        Assertions.assertTrue(TaxReliefType.contains("119R"));
    }

    @Test
    void test_valid_BONUS_FACCIATE(){
        Assertions.assertTrue(TaxReliefType.contains("L027"));
    }

    @Test
    void test_valid_INTERVENTI_ANTISISMICI(){
        Assertions.assertTrue(TaxReliefType.contains("DL50"));
    }

    @Test
    void test_valid_AQUISTO_MOBILIO_PER_RISTRUTTURAZIONE(){
        Assertions.assertTrue(TaxReliefType.contains("L090"));
    }

    @Test
    void test_valid_RISPARMIO_ENERGETICO(){
        Assertions.assertTrue(TaxReliefType.contains("L296"));
    }

    @Test
    void test_valid_RISTRUTTURAZIONE(){
        Assertions.assertTrue(TaxReliefType.contains("L449"));
    }

    @Test
    void test_valid_BARRIERE_ARCHITETTONICHE(){
        Assertions.assertTrue(TaxReliefType.contains("L234"));
    }

    @Test
    void test_invalid(){
        Assertions.assertFalse(TaxReliefType.contains("INVALID"));
    }
}
