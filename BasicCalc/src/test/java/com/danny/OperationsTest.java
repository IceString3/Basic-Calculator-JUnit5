package com.danny;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Clase para hacer tests con los métodos de la clase Operaciones
 *
 * Ve a la clase {@link com.danny.Operations} para ver los métodos que se chequean.
 * @author Daniel
 *
 */

public class OperationsTest {

    /**
     * Declaración de la variable, para poder ser usada en la clase
     */
    private Operations operations;

    /**
     * Inicia la variable operaciones antes de hacer un test
     */
    @BeforeEach
    void setUp() {
        operations = new Operations ();
    }

    /**
     * <p>Método sum (suma) para testar el método sum
     * </p>
     * @since 1.0
     */
    @org.junit.jupiter.api.Test
    public void simpleSumTest() {
        Double n1 = 2.0;
        Double n2 = 4.0;
        Double r;
        r = operations.sum (n1, n2);
        assertNotNull(r, "The result cannot be null");
        assertEquals(6.0, r, 0, "The result was not expected");
    }

    /**
     * <p>Método simpleDivisionTest para testar el método divide.
     * Devuelve la división de los dos números y lo
     *      compara con un valor esperado
     * </p>
     */
    @org.junit.jupiter.api.Test
    public void simpleDivisionTest() {
        Double n1 = 2.0;
        Double n2 = 4.0;
        simpleDivisionTest (n1, n2, 0.5);
        simpleDivisionTest (456.0, 345.0, 1.32);
    }

    /**
     * <p>Método simpleDivisionTest para testar el método divide.
     * Devuelve la división de los dos números
     * </p>
     * @param x Número doble 1
     * @param y Número doble 2
     * @param r Valor esperado
     */
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

    /**
     * <p>Verifica que se lanza una excepción NumberFormatException al intentar una división
     * entre cero
     * </p>
     * @throws NumberFormatException Si el segundo número es cero
     */
    @org.junit.jupiter.api.Test
    public void divisionByZeroTest() {
        Assertions.assertThrows (NumberFormatException.class, () -> operations.divide (4.0, 0.0));
    }

    /**
     * <p>Comprueba una multiplicación
     * </p>
     */
    @org.junit.jupiter.api.Test
    public void multiplyTest() {
        assertEquals (12.0, operations.multiply (4.0, 3.0));
    }

    /**
     * <p>Comprueba la resta
     * </p>
     */
    @org.junit.jupiter.api.Test
    public void subtractTest() {
        assertEquals (10.0, operations.subtract (6.0, -4.0));
        assertNotNull(operations.subtract (6.0, null));
    }

    /**
     * <p>Método multiplyNegativeNumbersTest para probar la multiplicación
     * con números negativos y de paso, si ambos son cero.
     * </p>
     * @param n1 Número doble 1
     * @param n2 Número doble 2
     * @since 1.0
     */
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

    /**
     * <p>Comprueba la multiplicación por 0
     * </p>
     */
    @org.junit.jupiter.api.Test
    public void multiplyTestByZero() {
        assertEquals (0.0, operations.multiply (4.0, 0.0));
    }

    /**
     * <p>Comprueba la multiplicación con valores nulos
     * </p>
     */
    @org.junit.jupiter.api.Test
    public void multiplyWithNull() {
        assertNotNull (operations.multiply (4.0, null));
        assertNotNull (operations.multiply (null, 2.0));
    }
}
