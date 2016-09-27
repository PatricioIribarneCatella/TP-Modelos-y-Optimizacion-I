package heuristica.aplicacion;

import heuristica.modelo.Heuristica;
import heuristica.modelo.Recorrido;

public class HeuristicaViajante {

    public static void main(String[] args) {

        Heuristica heuristica = new Heuristica();

        Recorrido americaDelSur = heuristica.getRecorridoAmericaDelSur();
        Recorrido europa = heuristica.getRecorridoEuropa();

        System.out.println("América del Sur");
        System.out.printf("El recorrido es: %s%n", americaDelSur.getCiudades());
        System.out.printf("La distancia recorrida es: %s [km]%n", americaDelSur.getDistancia());
        System.out.printf("El tiempo total utilizado es: %s [hs]%n", americaDelSur.getTiempo());

        System.out.println();

        System.out.println("Europa");
        System.out.printf("El recorrido es: %s%n", europa.getCiudades());
        System.out.printf("La distancia recorrida es: %s [km]%n", europa.getDistancia());
        System.out.printf("El tiempo total utilizado es: %s [hs]%n", europa.getTiempo());
    }
}
