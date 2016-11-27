package heuristica.modelo;

import java.util.List;

public class HeuristicaAmericaSVT extends HeuristicaAmerica {

    public HeuristicaAmericaSVT() {

        super();

        this.visitadas = new boolean[CANTIDAD_CIUDADES];

        for (int i = 0; i < CANTIDAD_CIUDADES; i++) {
            this.visitadas[i] = false;
        }
    }

    @Override
    protected int calcularPosicion(List<DistanciaPocision> ciudades, double tiempo) {

        ciudades.sort((DistanciaPocision d1, DistanciaPocision d2) -> {
            if (d1.getDistancia() > d2.getDistancia()) return 1;
            if (d1.getDistancia() < d2.getDistancia()) return -1;
            return 0;
        });

        for (DistanciaPocision dp : ciudades) {

            if (!this.visitadas[dp.getPosicion()]) {
                return dp.getPosicion();
            }
        }

        return 0;
    }
}
