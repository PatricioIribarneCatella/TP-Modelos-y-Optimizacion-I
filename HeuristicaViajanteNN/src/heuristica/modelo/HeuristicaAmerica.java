package heuristica.modelo;

import heuristica.utilitarios.CiudadesUtilitario;
import java.util.LinkedList;
import java.util.List;

public abstract class HeuristicaAmerica {

    protected static final int CANTIDAD_CIUDADES = 12;
    /*Se empieza el recorrido en Montevideo(Uruguay) que es la ciudad número 10 en la tabla*/
    private static final int CIUDAD_COMIENZO = 10;
    protected static final double HORAS_POR_KILOMETRO = 0.006; /*1000 km son 6 horas*/
    private static final int HORAS_DE_ESTADIA = 168;
    private static final int HORAS_EXTRAS_DE_ESTADIA = 120;

    private double[][] distanciasAmerica;
    protected boolean[] visitadas;

    public HeuristicaAmerica() {

        this.distanciasAmerica = new double[][]{{0.0, 1861.0, 2340.0, 1137.0, 4662.0, 4360.0, 4606.0, 1038.0, 3139.0, 4515.0, 204.0, 5096.0},
                                                {1861.0, 0.0, 1874.0, 1692.0, 2801.0, 2543.0, 2977.0, 1049.0, 1481.0, 2982.0, 1973.0, 3288.0},
                                                {2340.0, 1874.0, 0.0, 3011.0, 3665.0, 3777.0, 2753.0, 1463.0, 3167.0, 2537.0, 2273.0, 3591.0},
                                                {1137.0, 1692.0, 3011.0, 0.0, 4250.0, 3786.0, 4668.0, 1551.0, 2469.0, 4669.0, 1340.0, 4905.0},
                                                {4662.0, 2801.0, 3665.0, 4250.0, 0.0, 730.0, 1779.0, 3771.0, 1880.0, 2099.0, 4771.0, 1028.0},
                                                {4360.0, 2543.0, 3777.0, 3786.0, 730.0, 0.0, 2391.0, 3579.0, 1324.0, 2680.0, 4494.0, 1755.0},
                                                {4606.0, 2977.0, 2753.0, 4668.0, 1779.0, 2391.0, 0.0, 3571.0, 2958.0, 346.0, 4635.0, 1043.0},
                                                {1038.0, 1049.0, 1463.0, 1551.0, 3771.0, 3579.0, 3571.0, 0.0, 2514.0, 3477.0, 1069.0, 4105.0},
                                                {3139.0, 1481.0, 3167.0, 2469.0, 1880.0, 1324.0, 2958.0, 2514.0, 0.0, 3133.0, 3295.0, 2745.0},
                                                {4515.0, 2982.0, 2537.0, 4669.0, 2099.0, 2680.0, 346.0, 3477.0, 3133.0, 0.0, 4528.0, 1387.0},
                                                {204.0, 1973.0, 2273.0, 1340.0, 4771.0, 4494.0, 4635.0, 1069.0, 3295.0, 4528.0, 0.0, 5166.0},
                                                {5096.0, 3288.0, 3591.0, 4905.0, 1028.0, 1755.0, 1043.0, 4105.0, 2745.0, 1387.0, 5166.0, 0.0}};

    }

    private double[] getCiudadesAdyacentes(int ciudad) {

        double[] ciudades = new double[CANTIDAD_CIUDADES];

        System.arraycopy(this.distanciasAmerica[ciudad], 0, ciudades, 0, this.distanciasAmerica.length);

        return ciudades;
    }

    protected abstract int calcularPosicion(List<DistanciaPocision> ciudades, double tiempo);

    private int getCiudadAMinimaDistancia(double[] ciudadesAdyacentes, double tiempo) {

        List<DistanciaPocision> ciudades = new LinkedList<>();

        for (int i = 0; i < CANTIDAD_CIUDADES; i++) {
            if (ciudadesAdyacentes[i] != 0.0){
                DistanciaPocision dp = new DistanciaPocision(ciudadesAdyacentes[i], i);
                ciudades.add(dp);
            }
        }

        return this.calcularPosicion(ciudades, tiempo);
    }

    public Recorrido getRecorrido() {

        int cantidadCiudadesVisitadas = 0;
        int ciudadConDistanciaMinima;
        LinkedList<Integer> ciudades = new LinkedList<>();
        ciudades.addLast(CIUDAD_COMIENZO);
        this.visitadas[CIUDAD_COMIENZO] = true;

        double distanciaRecorrida = 0; /*En kilómetros*/
        double distanciaParaHorasExtras = 0;
        double tiempoConsumido = 0; /*En horas*/

        double[] ciudadesAdyacentes = this.getCiudadesAdyacentes(CIUDAD_COMIENZO);

        int ciudadActual = CIUDAD_COMIENZO;

        while (cantidadCiudadesVisitadas < (CANTIDAD_CIUDADES - 1)) {

            if (distanciaParaHorasExtras >= 3000) {
                tiempoConsumido = tiempoConsumido + HORAS_EXTRAS_DE_ESTADIA;
                distanciaParaHorasExtras = 0;
            }

            tiempoConsumido = tiempoConsumido + HORAS_DE_ESTADIA;

            ciudadConDistanciaMinima = this.getCiudadAMinimaDistancia(ciudadesAdyacentes, tiempoConsumido);

            this.visitadas[ciudadConDistanciaMinima] = true;

            ciudades.addLast(ciudadConDistanciaMinima);

            double d = this.distanciasAmerica[ciudadActual][ciudadConDistanciaMinima];

            distanciaRecorrida = distanciaRecorrida + d;
            distanciaParaHorasExtras = distanciaParaHorasExtras + d;

            tiempoConsumido = tiempoConsumido + d * HORAS_POR_KILOMETRO;

            ciudadActual = ciudadConDistanciaMinima;

            ciudadesAdyacentes = this.getCiudadesAdyacentes(ciudadActual);

            cantidadCiudadesVisitadas++;
        }

        double distanciaFinal = this.distanciasAmerica[ciudades.getLast()][CIUDAD_COMIENZO];

        distanciaRecorrida = distanciaRecorrida + distanciaFinal;

        tiempoConsumido = tiempoConsumido + distanciaFinal * HORAS_POR_KILOMETRO;

        ciudades.addLast(CIUDAD_COMIENZO);

        String recorrido = CiudadesUtilitario.transformarCiudadesDeAmerica(ciudades);

        return new Recorrido(recorrido, Double.toString(distanciaRecorrida), Double.toString(tiempoConsumido));
    }
}
