package com.camilomorales.joptionpane;

import java.util.Random;

public class Dado {
    private Random random;

    public Dado() {
        random = new Random();
    }

    public int lanzarDado() {
        return random.nextInt(6) + 1; // Genera un número aleatorio entre 1 y 6.
    }
}
