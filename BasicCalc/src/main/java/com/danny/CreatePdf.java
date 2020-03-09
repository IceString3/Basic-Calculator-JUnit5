package com.danny;

import com.itextpdf.io.font.constants.StandardFonts;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.*;
import com.itextpdf.layout.property.UnitValue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class CreatePdf {

    public static final String DATA = "methods.csv";

    public void createPdfFile () throws IOException {

        PdfWriter writer = new PdfWriter ("hello_world.pdf");
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document (pdf);
        document.add(new Paragraph ("Hello World!"));

        PdfFont font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        Image calc = new Image(ImageDataFactory.create("calculadora.png"));
        Paragraph p = new Paragraph("")
                .add(calc);
        document.add(p);
// Add a Paragraph
        document.add(new Paragraph("Calculadora básica").setFont(font));
// Create a List
        List list = new List()
                .setSymbolIndent(12)
                .setListSymbol("\u2022")
                .setFont(font);
        List list2 = new List()
                .setSymbolIndent(16)
                .setListSymbol(" - ")
                .setFont(font);
// Add ListItem objects
        list.add(new ListItem ("Métodos"));
        document.add (list);
        list2.add(new ListItem ("sum(): Este método permite sumar 2 números"));
        list2.add(new ListItem ("subtract(): Este método permite restar 2 números"));
        list2.add(new ListItem ("multiply(): Este método permite multiplicar 2 números"));
        list2.add(new ListItem ("divide(): Este método permite dividir 2 números"));
        document.add(list2);

        document.add(new Paragraph("").setFont(font));

        document.setMargins(20, 20, 20, 20);
        font = PdfFontFactory.createFont(StandardFonts.HELVETICA);
        PdfFont bold = PdfFontFactory.createFont(StandardFonts.HELVETICA_BOLD);
        Table table = new Table(UnitValue.createPercentArray(new float[]{1, 5, 1, 1, 1, 3, 1, 2, 4}))
                .useAllAvailableWidth();
        table.setWidth(UnitValue.createPercentValue(100));
        BufferedReader br = new BufferedReader(new FileReader (DATA));
        String line = br.readLine();
        process (table, line, bold, true);
        while ((line = br.readLine()) != null) {
            process (table, line, font, false);
        }
        br.close();
        document.add(table);

        document.close();
    }

    private void process(Table table, String line, PdfFont font, boolean isHeader) {
        StringTokenizer tokenizer = new StringTokenizer(line, ";");
        while (tokenizer.hasMoreTokens()) {
            if (isHeader) {
                table.addHeaderCell(
                        new Cell().add(
                                new Paragraph(tokenizer.nextToken()).setFont(font).setFontSize (9)));
            } else {
                table.addCell(
                        new Cell().add(
                                new Paragraph(tokenizer.nextToken()).setFont(font).setFontSize (8)));
            }
        }
    }
}

