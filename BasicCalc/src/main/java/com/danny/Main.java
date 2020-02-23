package com.danny;

public class Main {

    public static void main(String[] args) {

        Operations o = new Operations ();
        try {
            o.divide (5.0, 0.0);
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }
}
