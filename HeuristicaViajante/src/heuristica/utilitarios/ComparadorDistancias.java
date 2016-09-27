package heuristica.utilitarios;

import heuristica.modelo.DistanciaPocision;
import java.util.Comparator;

public class ComparadorDistancias implements Comparator<DistanciaPocision> {

    @Override
    public int compare(DistanciaPocision d1, DistanciaPocision d2) {

        if (d1.getDistancia() < d2.getDistancia()) return 1;
        if (d1.getDistancia() > d2.getDistancia()) return -1;
        return 0;
    }
}
