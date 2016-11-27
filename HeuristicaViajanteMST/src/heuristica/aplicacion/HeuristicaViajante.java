package heuristica.aplicacion;

import heuristica.modelo.AmericaDelSur;
import heuristica.modelo.Europa;
import heuristica.modelo.Recorrido;

public class HeuristicaViajante {

    public static void main(String[] args) {

        AmericaDelSur americaDelSur = new AmericaDelSur();
        Europa europa = new Europa();

        Recorrido rAmericaDelSurABCU = americaDelSur.getRecorridoABCU();
        System.out.println("América del Sur (Paises: Argentina-Brasil-Chile-Uruguay)");
        System.out.printf("El recorrido es: %s%n", rAmericaDelSurABCU.getCiudades());
        System.out.printf("La distancia recorrida es: %s [km]%n", rAmericaDelSurABCU.getDistancia());
        System.out.printf("El tiempo total utilizado es: %s [hs]%n", rAmericaDelSurABCU.getTiempo());

        System.out.println();

        Recorrido rAmericaDelSur = americaDelSur.getRecorrido();
        System.out.println("América del Sur (Con ventanas de tiempo)");
        System.out.printf("El recorrido es: %s%n", rAmericaDelSur.getCiudades());
        System.out.printf("La distancia recorrida es: %s [km]%n", rAmericaDelSur.getDistancia());
        System.out.printf("El tiempo total utilizado es: %s [hs]%n", rAmericaDelSur.getTiempo());

        System.out.println();

        Recorrido rAmericaDelSurSinVT = americaDelSur.getRecorridoSinVT();
        System.out.println("América del Sur (Sin ventanas de tiempo)");
        System.out.printf("El recorrido es: %s%n", rAmericaDelSurSinVT.getCiudades());
        System.out.printf("La distancia recorrida es: %s [km]%n", rAmericaDelSurSinVT.getDistancia());
        System.out.printf("El tiempo total utilizado es: %s [hs]%n", rAmericaDelSurSinVT.getTiempo());

        System.out.println();

        Recorrido rEuropa = europa.getRecorrido();
        System.out.println("Europa");
        System.out.printf("El recorrido es: %s%n", rEuropa.getCiudades());
        System.out.printf("La distancia recorrida es: %s [km]%n", rEuropa.getDistancia());
        System.out.printf("El tiempo total utilizado es: %s [hs]%n", rEuropa.getTiempo());
    }
}
