package com.danny;

public class Main {

    public static void main(String[] args) {

        Operations o = new Operations ();
        try {
            o.divide (5.0, 0.0);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        System.out.println (o.sum (3.0, 14.67));
        System.out.println (o.subtract (7.4, -4.6));
        System.out.println (o.multiply (6.0, 12.0));
    }
}
