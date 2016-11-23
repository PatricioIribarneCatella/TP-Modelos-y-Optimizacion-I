package heuristica.modelo;

import heuristica.utilitarios.CiudadesUtilitario;
import heuristica.utilitarios.Parametros;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class HeuristicaConVT extends Heuristica {

    private double distanciaRecorrida; /*En kilómetros*/
    private double distanciaParaHorasExtras;
    private double tiempoConsumido; /*En horas*/

    public HeuristicaConVT() {

        super();

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

    private double calcularNuevoTiempo(int ciudadAVisitar, int ciudadActual, double tiempo) {

        double d = this.distancias[ciudadActual][ciudadAVisitar];

        return tiempo + d * Parametros.HORAS_POR_KILOMETRO;
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

    private boolean ciudadEsValida(int ciudadAVisitar, int ciudadActual, double tiempo) {

        if ((ciudadAVisitar != Parametros.LIMA) && (ciudadAVisitar != Parametros.BRASILIA)) {

            return true;

        } else {

            double tiempoAux;

            if (ciudadAVisitar == Parametros.BRASILIA) {
            /*Va a caer dentro del mes de Febrero*/

                tiempoAux = this.calcularNuevoTiempo(ciudadAVisitar, ciudadActual, tiempo);

                if (tiempoAux > 672 && tiempoAux < 1344) return true;
            }

            if (ciudadAVisitar == Parametros.LIMA) {
            /*No va a caer dentro del mes de Febrero*/

                tiempoAux = this.calcularNuevoTiempo(ciudadAVisitar, ciudadActual, tiempo);

                if (tiempoAux < 672 || tiempoAux > 1344) return true;
            }
        }

        return false;
    }

    @Override
    protected Recorrido recorridoDFS(List<List<Double>> g) {

        LinkedList<Integer> dfs = new LinkedList<>();

        int ciudadActual = this.ciudadComienzo;

        boolean[] visitados = initializeVisitados(this.distancias.length);

        this.distanciaRecorrida = 0; /*En kilómetros*/
        this.distanciaParaHorasExtras = 0;
        this.tiempoConsumido = 0; /*En horas*/

        /* Algoritmo DFS */

        Stack<Integer> s = new Stack<>();

        LinkedList<Integer> q = new LinkedList<>();

        s.push(ciudadActual);

        while (!s.isEmpty()) {

            this.actualizarHorasExtrasDeEstadia();

            int w;

            if (!q.isEmpty()) {

                int aux = q.getFirst();

                if (ciudadEsValida(aux, ciudadActual, this.tiempoConsumido)) {
                    w = q.removeFirst();
                } else {
                    w = s.pop();
                }

            } else {
                w = s.pop();
            }

            if (!visitados[w]) {

                if (ciudadEsValida(w, ciudadActual, this.tiempoConsumido)) {

                    this.tiempoConsumido = this.tiempoConsumido + Parametros.HORAS_DE_ESTADIA;

                    this.actualizarDistanciasYTiempos(ciudadActual, w);

                    ciudadActual = w;

                    visitados[w] = true;

                    dfs.addLast(w);

                } else {
                    q.addLast(w);
                }

                List<Double> adyacentes = g.get(w);

                for (int v = 0; v < adyacentes.size(); v++) {

                    double weight = adyacentes.get(v);

                    if ((weight != 0.0)) s.push(v);
                }
            }
        }

        if (!q.isEmpty()) {

            tiempoConsumido = tiempoConsumido + Parametros.HORAS_DE_ESTADIA;

            this.actualizarDistanciasYTiempos(ciudadActual, Parametros.BRASILIA);

            this.actualizarHorasExtrasDeEstadia();

            dfs.addLast(Parametros.BRASILIA);
        }

        this.actualizarDistanciasYTiempos(dfs.getLast(), dfs.getFirst());

        dfs.addLast(dfs.getFirst());

        String recorrido;

        if (this.distancias.length == Parametros.CANTIDAD_CIUDADES_AMERICA_DEL_SUR) {
            recorrido = CiudadesUtilitario.transformarCiudadesDeAmerica(dfs);
        } else {
            recorrido = CiudadesUtilitario.transformarCiudadesDeAmericaABCU(dfs);
        }

        return new Recorrido(recorrido, Double.toString(distanciaRecorrida), Double.toString(tiempoConsumido));
    }
}
