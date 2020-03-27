package com.danny;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;

public class CalcWindow extends JFrame {
    /*
     * generado
     */
    private static final long serialVersionUID = 1583724102189855698L;
    Operations operations = new Operations ();

    /* numero tecleado */
    JTextField pantalla;

    /* guarda el resultado de la operacion anterior o el número tecleado */
    double n1;
    double n2;
    double r = 0;
    Double ans;

    /* para guardar la operacion a realizar */
    String operacion;

    /* Los paneles donde colocaremos los botones */
    JPanel panelNumeros, panelOperaciones;

    /* Indica si estamos iniciando o no una operación */
    boolean nuevaOperacion = true;

    /*
     * Constructor. Crea los botones y componentes de la calculadora
     */
    public CalcWindow() {
        super();
        setSize(300, 350);
        setTitle("Calculadora Simple");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        // Vamos a dibujar sobre el panel
        JPanel panel = (JPanel) this.getContentPane();
        panel.setLayout(new BorderLayout ());

        pantalla = new JTextField("0", 20);
        pantalla.setBorder(new EmptyBorder (4, 4, 4, 4));
        pantalla.setFont(new Font("Arial", Font.BOLD, 25));
        pantalla.setHorizontalAlignment(JTextField.RIGHT);
        pantalla.setEditable(false);
        pantalla.setBackground(Color.WHITE);
        panel.add("North", pantalla);

        panelNumeros = new JPanel();
        panelNumeros.setLayout(new GridLayout(4, 3));
        panelNumeros.setBorder(new EmptyBorder(4, 4, 4, 4));

        for (int n = 9; n >= 0; n--) {
            nuevoBotonNumerico("" + n);
        }

        nuevoBotonNumerico(".");
        nuevoBotonPdf ("PDF");

        panel.add("Center", panelNumeros);

        panelOperaciones = new JPanel();
        panelOperaciones.setLayout(new GridLayout(6, 1));
        panelOperaciones.setBorder(new EmptyBorder(4, 4, 4, 4));

        nuevoBotonOperacion("+");
        nuevoBotonOperacion("-");
        nuevoBotonOperacion("*");
        nuevoBotonOperacion("/");
        nuevoBotonOperacion("=");
        nuevoBotonOperacion("CE");

        panel.add("East", panelOperaciones);

        validate();
    }

    private void nuevoBotonNumerico(String digito) {
        JButton btn = new JButton();
        btn.setText(digito);
        btn.addMouseListener(new MouseAdapter () {

            @Override
            public void mouseReleased(MouseEvent evt) {
                JButton btn = (JButton) evt.getSource();
                try {
                    numeroPulsado(btn.getText());
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }
        });

        panelNumeros.add(btn);
    }

    private void nuevoBotonPdf(String digito) {
        JButton btn = new JButton();
        btn.setText(digito);
        btn.addMouseListener(new MouseAdapter () {

            @Override
            public void mouseReleased(MouseEvent evt) {
                try {
                    Desktop.getDesktop ().open (new File ("hello_world.pdf"));
                } catch (IOException e) {
                    e.printStackTrace ();
                }
            }
        });

        panelNumeros.add(btn);
    }

    private void nuevoBotonOperacion(String operacion) {
        JButton btn = new JButton(operacion);
        btn.setForeground(Color.RED);

        btn.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseReleased(MouseEvent evt) {
                JButton btn = (JButton) evt.getSource();
                operacionPulsado(btn.getText());
            }
        });

        panelOperaciones.add(btn);
    }

    /*
     * Gestiona las pulsaciones de teclas numéricas
     *
     * @param digito
     *            tecla pulsada
     */
    private void numeroPulsado(String digito) throws IOException {
        if (pantalla.getText().equals("0") || nuevaOperacion) {
            pantalla.setText(digito);
        } else {
            pantalla.setText(pantalla.getText() + digito);
        }
        nuevaOperacion = false;
    }

    private void operacionPulsado(String tecla) {
        if (tecla.equals("=")) {
            n2 = Double.parseDouble (pantalla.getText ());
            calcularResultado();
        } else if (tecla.equals("CE")) {
            n1 = 0;
            n2 = 0;
            r = 0;
            ans = null;
            pantalla.setText("");
            nuevaOperacion = true;
        } else {
            operacion = tecla;
            if ((n1 > 0) && !nuevaOperacion) {
                n2 = Double.parseDouble (pantalla.getText ());
                calcularResultado();
            } else {
                n1 = Double.parseDouble (pantalla.getText ());
            }
        }

        nuevaOperacion = true;
    }


    private void calcularResultado() {
        switch (operacion) {
            case "+":
                if (ans == null) {
                    r += operations.sum (n1, n2);
                } else {
                    r += operations.sum (0.0, n2);
                }
                ans = r;
                break;
            case "-":
                if (ans == null) {
                    r += operations.subtract (n1, n2);
                } else {
                    r += operations.subtract (0.0, n2);
                }
                ans = r;
                break;
            case "/":
                if (ans == null) {
                    r += operations.divide (n1, n2);
                } else {
                    r *= operations.divide (1.0, n2);
                }
                ans = r;
                break;
            case "*":
                if (ans == null) {
                    r += operations.multiply (n1, n2);
                } else {
                    r *= operations.multiply (1.0, n2);
                }
                ans = r;
                break;
        }

        pantalla.setText("" + r);
        operacion = "";
    }
}
