package heuristica.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public abstract class Prim {

    private static boolean[] initializeVisitados(int cantidadCiudades) {

        boolean[] v = new boolean[cantidadCiudades];

        for (int i = 0; i < cantidadCiudades; i++) {
            v[i] = false;
        }

        return v;
    }

    public static List<Arista> getMST(double[][] distancias, int ciudadComienzo) {

        List<Arista> mst = new ArrayList<>();

        /* Algoritmo de Prim */

        boolean[] visitado = initializeVisitados(distancias.length);

        visitado[ciudadComienzo] = true;

        PriorityQueue<Arista> h = new PriorityQueue<>(
                (Arista a1, Arista a2) -> {
                    if (a1.getWeight() > a2.getWeight()) return 1;
                    if (a1.getWeight() < a2.getWeight()) return -1;
                    return 0;
                }
        );

        for (int i = 0; i < distancias.length; i++) {

            if (distancias[ciudadComienzo][i] != 0.0) {
                h.add(new Arista(ciudadComienzo, i, distancias[ciudadComienzo][i]));
            }
        }

        while (!h.isEmpty() && (mst.size() < (distancias.length-1))) {

            Arista a = h.poll();

            int y = a.getEndVertex();

            if (!visitado[y]) {

                mst.add(a);
                visitado[y] = true;

                for (int w = 0; w < distancias.length; w++) {

                    if ((distancias[y][w] != 0.0) && (!visitado[w])) {
                        h.add(new Arista(y, w, distancias[y][w]));
                    }
                }
            }
        }

        return mst;
    }
}
