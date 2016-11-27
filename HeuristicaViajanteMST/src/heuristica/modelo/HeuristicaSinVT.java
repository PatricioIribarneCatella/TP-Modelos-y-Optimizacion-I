package heuristica.modelo;

import heuristica.utilitarios.CiudadesUtilitario;
import heuristica.utilitarios.Parametros;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class HeuristicaSinVT extends Heuristica {

    private double distanciaRecorrida; /*En kilómetros*/
    private double distanciaParaHorasExtras;
    private double tiempoConsumido; /*En horas*/

    public HeuristicaSinVT(double[][] distancias, int ciudad) {

        super(distancias, ciudad);

        this.distanciaRecorrida = 0;
        this.distanciaParaHorasExtras = 0;
        this.tiempoConsumido = 0;
    }

    private boolean[] initializeVisitados(int cantidadCiudades) {

        boolean[] v = new boolean[cantidadCiudades];

        for (int i = 0; i < cantidadCiudades; i++) {
            v[i] = false;
        }

        return v;
    }

    private void actualizarDistanciasYTiempos(int ciudadActual, int w) {

        double d = this.distancias[ciudadActual][w];

        this.distanciaRecorrida = this.distanciaRecorrida + d;
        this.distanciaParaHorasExtras = this.distanciaParaHorasExtras + d;

        this.tiempoConsumido = this.tiempoConsumido + d * Parametros.HORAS_POR_KILOMETRO;
    }

    private void actualizarHorasExtrasDeEstadia() {

        if (this.distanciaParaHorasExtras >= 3000) {
            this.tiempoConsumido = this.tiempoConsumido + Parametros.HORAS_EXTRAS_DE_ESTADIA;
            this.distanciaParaHorasExtras = 0;
        }
    }

    private Recorrido crearRecorrido(LinkedList<Integer> dfs) {

        this.distanciaRecorrida = 0; /*En kilómetros*/
        this.distanciaParaHorasExtras = 0;
        this.tiempoConsumido = 0; /*En horas*/

        for (int v = 0; v < (dfs.size()-1); v++) {

            this.actualizarHorasExtrasDeEstadia();

            this.tiempoConsumido = this.tiempoConsumido + Parametros.HORAS_DE_ESTADIA;

            this.actualizarDistanciasYTiempos(dfs.get(v), dfs.get(v+1));
        }

        this.actualizarDistanciasYTiempos(dfs.getLast(), dfs.getFirst());

        dfs.addLast(dfs.getFirst());

        String recorrido;

        if (this.distancias.length == Parametros.CANTIDAD_CIUDADES_EUROPA) {
            recorrido = CiudadesUtilitario.transformarCiudadesEuropeas(dfs);
        } else {
            recorrido = CiudadesUtilitario.transformarCiudadesDeAmerica(dfs);
        }

        return new Recorrido(recorrido, Double.toString(distanciaRecorrida), Double.toString(tiempoConsumido));
    }

    @Override
    protected Recorrido recorridoDFS(List<List<Double>> g) {

        LinkedList<Integer> dfs = new LinkedList<>();

        int verticeOrigen = this.ciudadComienzo;

        boolean[] visitados = initializeVisitados(this.distancias.length);

        /* Algoritmo DFS */

        Stack<Integer> s = new Stack<>();

        s.push(verticeOrigen);

        while (!s.isEmpty()) {

            int w = s.pop();

            if (!visitados[w]) {

                visitados[w] = true;

                dfs.addLast(w);

                List<Double> adyacentes = g.get(w);

                for (int v = 0; v < adyacentes.size(); v++) {

                    double weight = adyacentes.get(v);

                    if (weight != 0.0) s.push(v);
                }
            }
        }

        return this.crearRecorrido(dfs);
    }
}
