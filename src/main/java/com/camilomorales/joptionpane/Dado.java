package com.camilomorales.joptionpane;

import java.util.Random;

class Dado {
    private Random random = new Random();

    public int lanzarDado() {
        return random.nextInt(6) + 1;
    }
}

