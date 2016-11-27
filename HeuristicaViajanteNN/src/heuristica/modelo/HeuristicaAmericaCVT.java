package heuristica.modelo;

import java.util.List;

public class HeuristicaAmericaCVT extends HeuristicaAmerica {

    private static final int BRASILIA = 2;
    private static final int LIMA = 8;

    public HeuristicaAmericaCVT() {

        super();

        this.visitadas = new boolean[CANTIDAD_CIUDADES];

        for (int i = 0; i < CANTIDAD_CIUDADES; i++) {
            this.visitadas[i] = false;
        }
    }

    private boolean ciudadEsValida(int ciudad, double tiempo) {

        if ((ciudad != LIMA) && (ciudad != BRASILIA)) {
            return true;
        }

        if (ciudad == 2) {
            /*Va a caer dentro del mes de Febrero*/
            if (tiempo > 672) return true;
        }

        if (ciudad == 8) {
            /*No va a caer dentro del mes de Febrero*/
            if (tiempo < 672 || tiempo > 1344) return true;
        }

        return false;
    }

    @Override
    protected int calcularPosicion(List<DistanciaPocision> ciudades, double tiempo) {

        ciudades.sort((DistanciaPocision d1, DistanciaPocision d2) -> {
            if (d1.getDistancia() < d2.getDistancia()) return 1;
            if (d1.getDistancia() > d2.getDistancia()) return -1;
            return 0;
        });

        int posicion = 0;
        double tiempoAux;

        for (DistanciaPocision dp : ciudades) {

            double aux = dp.getDistancia();
            tiempoAux = tiempo + aux * HORAS_POR_KILOMETRO;

            if (!this.visitadas[dp.getPosicion()] && ciudadEsValida(dp.getPosicion(), tiempoAux)) {
                posicion = dp.getPosicion();
            }
        }

        return posicion;
    }
}
