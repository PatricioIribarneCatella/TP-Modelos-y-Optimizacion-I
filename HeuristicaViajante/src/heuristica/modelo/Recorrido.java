package heuristica.modelo;

public class Recorrido {

    private String ciudades;
    private String tiempo;
    private String distancia;

    public Recorrido(String ciudades, String distancia, String tiempo) {

        this.ciudades = ciudades;
        this.distancia = distancia;
        this.tiempo = tiempo;
    }

    public String getCiudades() {
        return this.ciudades;
    }

    public String getDistancia() {
        return this.distancia;
    }

    public String getTiempo() {
        return this.tiempo;
    }
}
