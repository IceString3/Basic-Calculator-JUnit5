package com.danny;

import java.util.ArrayList;
import java.util.List;

public class Operations {
    /*double[] numbers;
    public double sum(double[] numbers) {
        double r = 0;
        for (int i = 0; i < numbers.length; i++) {
            r += numbers[i];
        }
        return r;
    }*/

    public Double sum(Double n1, Double n2) {
        if ((n1 != null) && (n2 != null)) {
            return n1 + n2;
        } else {
            System.out.println ("Numbers cannot be null");
            return 0.0;
        }
    }
    public Double subtract(Double n1, Double n2) {
        if ((n1 != null) && (n2 != null)) {
            return n1 - n2;
        } else {
            System.out.println ("Numbers cannot be null");
            return 0.0;
        }
    }
    public Double multiply(Double n1, Double n2) {
        if ((n1 != null) && (n2 != null)) {
            return n1 * n2;
        } else {
            System.out.println ("Numbers cannot be null");
            return 0.0;
        }
    }
    public Double divide(Double n1, Double n2) throws Exception {
        if (n1 == null || n2 == null) {
            throw new NullPointerException ("Number cannot be null");
        } else if (n2 <= 0) {
            throw new NumberFormatException ("Divisor cannot be less than zero or zero");
        }
        return n1 / n2;
    }

}
