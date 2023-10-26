package com.camilomorales.app;

import com.camilomorales.joptionpane.Guayabita;

public class Main {
    public static void main(String[] args) {
        Guayabita juego = new Guayabita();
        int opcion1 = juego.mostrarMenu();

        if (opcion1 == 1) {
            juego.jugar();
        } else if (opcion1 == 2) {
            juego.mostrarInstrucciones();
        }
    }
}

