package com.camilomorales.joptionpane;

import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

public class Guayabita {
    private List<Jugador> jugadores;
    private int pote;
    private Dado dado;

    public Guayabita() {
        jugadores = new ArrayList<>();
        dado = new Dado();
    }

    public static void main(String[] args) {
        Guayabita juego = new Guayabita();
        int opcion = juego.mostrarMenu();

        if (opcion == 1) {
            juego.jugar();
        } else if (opcion == 2) {
            juego.mostrarInstrucciones();
        }
    }

    public void jugar() {
        int numJugadores = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el número de jugadores:"));
        int apuestaMinima = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la apuesta mínima:"));

        for (int i = 0; i < numJugadores; i++) {
                String nombre = JOptionPane.showInputDialog("Ingrese el nombre del jugador " + (i + 1) + ":");
                int dinero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el dinero inicial para " + nombre + ":"));
                jugadores.add(new Jugador(nombre, dinero));
        }

        pote = numJugadores * apuestaMinima;

        while (pote > 0 && jugadores.size() > 1) {
            for (Jugador jugador : jugadores) {
                if (!jugador.tieneDinero()) {
                    continue;
                }

                int resultadoDado = dado.lanzarDado();
                int opcion = JOptionPane.showConfirmDialog(null, jugador.getNombre() + ", ¿desea lanzar el dado?");

                if (opcion == JOptionPane.YES_OPTION) {
                    int montoApostado = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el monto a apostar:"));
                    jugador.realizarApuesta(montoApostado);

                    int nuevoResultadoDado = dado.lanzarDado();
                    JOptionPane.showMessageDialog(null, jugador.getNombre() + " sacó un " + nuevoResultadoDado);

                    if (nuevoResultadoDado > resultadoDado) {
                        jugador.ganarApuesta(pote);
                        pote = 0;
                        break;
                    } else if (nuevoResultadoDado <= resultadoDado) {
                        pote += montoApostado;
                    }
                    } else {
                        jugador.perderApuesta();
                    }
                }

                jugadores.removeIf(jugador -> !jugador.tieneDinero());
            }

            mostrarResultadoFinal();
        }


    public int mostrarMenu() {
        String[] opciones = { "Jugar", "Ver Instrucciones" };
        return JOptionPane.showOptionDialog(null, "¿Qué desea hacer?", "Bienvenidos al juego de la Guayabita",
                JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]) + 1;
    }

    public void mostrarInstrucciones() {
        String instrucciones = "Instrucciones del juego:\n\n" +
                "1. Cada jugador tira el dado y el resultado determina si puede apostar o no.\n" +
                "2. Si saca 1 o 6, no puede apostar y cede el turno al siguiente jugador.\n" +
                "3. Si saca un número del 2 al 5, puede optar por apostar una cantidad de dinero al pote.\n" +
                "4. El jugador que saque un número mayor en la segunda tirada gana el dinero del pote.\n" +
                "5. El juego continúa hasta que no quede dinero en el pote o todos los jugadores estén fuera.\n";

        JOptionPane.showMessageDialog(null, instrucciones, "Instrucciones", JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarResultadoFinal() {
        StringBuilder mensaje = new StringBuilder("Resultados finales:\n");

        for (Jugador jugador : jugadores) {
            mensaje.append(jugador.getNombre()).append(": $").append(jugador.getDinero()).append("\n");
        }

        JOptionPane.showMessageDialog(null, mensaje.toString(), "Resultados Finales", JOptionPane.INFORMATION_MESSAGE);
    }
}
