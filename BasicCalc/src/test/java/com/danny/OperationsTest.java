package com.danny;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

public class OperationsTest {

    private Operations operations;

    @BeforeEach
    void setUp() {
        operations = new Operations ();
    }

    @org.junit.jupiter.api.Test
    public void simpleSumTest() {
        Double n1 = 2.0;
        Double n2 = 4.0;
        Double r;
        r = operations.sum (n1, n2);
        assertNotNull(r, "The result cannot be null");
        assertEquals(6.0, r, 0, "The result was not expected");
    }

    @org.junit.jupiter.api.Test
    public void simpleDivisionTest() {
        Double n1 = 2.0;
        Double n2 = 4.0;
        simpleDivisionTest (n1, n2, 0.5);
        simpleDivisionTest (456.0, 345.0, 1.32);
    }

    @org.junit.jupiter.api.Test
    private void simpleDivisionTest(Double x, Double y, Double r) {
        Double result = null;
        try {
            result = operations.divide (x, y);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        assertEquals (r, result, 0.01);
    }

    @org.junit.jupiter.api.Test
    public void divisionByZeroTest() {
        Assertions.assertThrows (NumberFormatException.class, () -> operations.divide (4.0, 0.0));
    }

    @org.junit.jupiter.api.Test
    public void multiplyTest() {
        assertEquals (12.0, operations.multiply (4.0, 3.0));
    }

    @org.junit.jupiter.api.Test
    public void subtractTest() {
        assertEquals (10.0, operations.subtract (6.0, -4.0));
        assertNotNull(operations.subtract (6.0, null));
    }

    @ParameterizedTest
    @CsvSource ({"-4.0, -3.0",
                "4.0, -3.0",
                "-4.0, 3.0",
                "4.0, 3.0",
                "0.0, 0.0"})
    public void multiplyNegativeNumbersTest(Double n1, Double n2) {
        if (((n1 < 0) && (n2 < 0)) || ((n1 > 0) && (n2 > 0))) {
            assertEquals (12.0, operations.multiply (n1, n2));
        } else if (((n1 < 0) || (n2 < 0)) || ((n1 > 0) || (n2 > 0))) {
            assertEquals (-12.0, operations.multiply (n1, n2));
        } else {
            assertEquals (0.0, operations.multiply (n1, n2));
        }
    }

    @org.junit.jupiter.api.Test
    public void multiplyTestByZero() {
        assertEquals (0.0, operations.multiply (4.0, 0.0));
    }

    @org.junit.jupiter.api.Test
    public void multiplyWithNull() {
        assertNotNull (operations.multiply (4.0, null));
        assertNotNull (operations.multiply (null, 2.0));
    }
}
