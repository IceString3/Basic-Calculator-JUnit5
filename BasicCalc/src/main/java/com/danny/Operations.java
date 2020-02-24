package com.danny;

/**
 * <h1>Calculadora básica</h1>
 * Esta calculadora puede hacer las operaciones básicas
 * de suma, resta, multiplicación y división
 * <p>
 *
 * @author  Daniel
 * @version 1.0
 * @since   24-02-2020
 */

public class Operations {

    /**
     * <p>Suma dos números n1 y n2
     * </p>
     * @param n1 Número doble 1
     * @param n2 Número doble 2
     * @return Devuelve la suma de los dos números
     * @since 1.0
     */
    public Double sum(Double n1, Double n2) {
        if ((n1 != null) && (n2 != null)) {
            return n1 + n2;
        } else {
            System.out.println ("Numbers cannot be null");
            return 0.0;
        }
    }
    /**
     * <p>Resta dos números n1 y n2
     * </p>
     * @param n1 Número doble 1
     * @param n2 Número doble 2
     * @return Devuelve la resta de los dos números
     * @since 1.0
     */
    public Double subtract(Double n1, Double n2) {
        if ((n1 != null) && (n2 != null)) {
            return n1 - n2;
        } else {
            System.out.println ("Numbers cannot be null");
            return 0.0;
        }
    }

    /**
     * <p>Multiplica dos números n1 y n2
     * </p>
     * @param n1 Número doble 1
     * @param n2 Número doble 2
     * @return Devuelve la multiplicación de los dos números
     * @since 1.0
     */
    public Double multiply(Double n1, Double n2) {
        if ((n1 != null) && (n2 != null)) {
            return n1 * n2;
        } else {
            System.out.println ("Numbers cannot be null");
            return 0.0;
        }
    }
    /**
     * <p>Divide dos números n1 y n2
     * </p>
     * @param n1 Número doble 1
     * @param n2 Número doble 2
     * @return Devuelve la división de los dos números
     * @throws NullPointerException Si uno de los números es nulo
     * @throws NumberFormatException Si el segundo número es 0 o menor que 0
     * @since 1.0
     */
    public Double divide(Double n1, Double n2) {
        if (n1 == null || n2 == null) {
            throw new NullPointerException ("Number cannot be null");
        } else if (n2 <= 0) {
            throw new NumberFormatException ("Divisor cannot be less than zero or zero");
        }
        return n1 / n2;
    }

}
