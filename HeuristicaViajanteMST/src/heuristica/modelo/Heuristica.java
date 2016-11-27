package heuristica.modelo;

import java.util.ArrayList;
import java.util.List;

public abstract class Heuristica {

    protected double[][] distancias;
    protected int ciudadComienzo;

    public Heuristica() {}

    public Heuristica(double[][] distancias, int ciudadComienzo) {
        this.distancias = distancias;
        this.ciudadComienzo = ciudadComienzo;
    }

    protected abstract Recorrido recorridoDFS(List<List<Double>> g);

    /* Convierte un conjunto de aristas en una lista de adyacencias */
    private List<List<Double>> pasarAFormatoGrafo(List<Arista> mst) {

        List<List<Double>> l = new ArrayList<>(this.distancias.length);

        for (int i = 0; i < this.distancias.length; i++) {

            List<Double> a = new ArrayList<>(this.distancias.length);

            for (int j = 0; j < this.distancias.length; j++) {
                a.add(j, 0.0);
            }

            l.add(i, a);
        }

        for (Arista a : mst) {

            int sv = a.getStartVertex();
            int ev = a.getEndVertex();
            double w = a.getWeight();

            l.get(sv).set(ev, w);
            l.get(ev).set(sv, w);
        }

        return l;
    }

    public Recorrido getRecorrido() {

        List<Arista> mst = Prim.getMST(this.distancias, this.ciudadComienzo);

        List<List<Double>> g = this.pasarAFormatoGrafo(mst);

        return this.recorridoDFS(g);
    }

    public void setDistancias(double[][] distancias) {
        this.distancias = distancias;
    }

    public void setCiudadComienzo(int ciudad) { this.ciudadComienzo = ciudad; }
}
