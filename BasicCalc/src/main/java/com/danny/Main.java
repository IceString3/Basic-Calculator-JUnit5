package com.danny;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        CreatePdf pdf = new CreatePdf ();

        CalcWindow calc = new CalcWindow ();
        calc.setVisible(true);

        Operations o = new Operations ();
        try {
            o.divide (5.0, 2.0);
        } catch (Exception e) {
            e.printStackTrace ();
        }
        System.out.println (o.sum (3.0, 14.67));
        System.out.println (o.subtract (7.4, -4.6));
        System.out.println (o.multiply (6.0, 12.0));

        //pdf.createPdfFile ();

    }
}
