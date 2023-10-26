package com.camilomorales.app;

import com.camilomorales.joptionpane.Guayabita;

public class Main {
    public static void main(String[] args) {
        Guayabita juego = new Guayabita();
        int opcion = juego.mostrarMenu();

        if (opcion == 1) {
            juego.jugar();
        } else if (opcion == 2) {
            juego.mostrarInstrucciones();
        }
    }
}

