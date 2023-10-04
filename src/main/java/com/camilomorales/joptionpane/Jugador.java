package com.camilomorales.joptionpane;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

class Jugador {
    private String nombre;
    private int dinero;
    private int apuesta;

    public Jugador(String nombre, int dinero) {
        this.nombre = nombre;
        this.dinero = dinero;
        this.apuesta = 0;
    }



    public void realizarApuesta(int monto) {
        if (monto <= dinero) {
            apuesta += monto;
            dinero -= monto;
        } else {
            JOptionPane.showMessageDialog(null, "No tienes suficiente dinero para apostar.");
        }
    }

    public void ganarApuesta(int monto) {
        dinero += monto;
        apuesta = 0;
    }

    public void perderApuesta() {
        apuesta = 0;
    }

    public boolean tieneDinero() {
        return dinero > 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDinero() {
        return dinero;
    }

    public int getApuesta() {
        return apuesta;
    }
}
