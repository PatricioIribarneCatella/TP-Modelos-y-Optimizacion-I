package heuristica.modelo;

public class DistanciaPocision {

    private double distancia;
    private int posicion;

    public DistanciaPocision(double distancia, int posicion) {
        this.distancia = distancia;
        this.posicion = posicion;
    }

    public double getDistancia() {
        return this.distancia;
    }

    public int getPosicion() {
        return this.posicion;
    }
}
