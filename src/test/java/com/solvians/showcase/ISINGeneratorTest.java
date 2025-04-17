package com.solvians.showcase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ISINGeneratorTest {

    @Test
    void testGenerateISINFormat() {
        String isin = ISINGenerator.generateISIN();
        assertTrue(isin.matches("[A-Z]{2}[A-Z0-9]{9}\\d"), "ISIN format is invalid: " + isin);
    }

    @Test
    void testCheckDigitCalculation() {
        String rawIsin = "DE123456789";
        char expected = '6'; // pre-calculated correct check digit
        char actual = ISINGenerator.calculateCheckDigit(rawIsin);
        assertEquals(expected, actual, "Check digit mismatch for input: " + rawIsin);
    }
}
