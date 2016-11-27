package heuristica.modelo;

public class AmericaDelSur {

    private double[][] distancias;
    private double[][] distanciasABCU;
    private Heuristica heuristicaSinVT;
    private Heuristica heuristica;

    /*Se empieza el recorrido en Montevideo(Uruguay) que es la ciudad número 10 en la tabla*/
    private static final int CIUDAD_COMIENZO = 10;
    private static final int CIUDAD_COMIENZO_ABCU = 3;

    public AmericaDelSur() {

        this.distancias = new double[][]{{0.0, 1861.0, 2340.0, 1137.0, 4662.0, 4360.0, 4606.0, 1038.0, 3139.0, 4515.0, 204.0, 5096.0},
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

        this.distanciasABCU = new double[][]{{0.0, 1137.0, 2340.0, 204.0},
                                            {1137.0, 0.0, 3011.0, 1340.0},
                                            {2340.0, 3011.0, 0.0, 2273.0},
                                            {204.0, 1340.0, 2273.0, 0.0}};

        this.heuristicaSinVT = new HeuristicaSinVT(this.distancias, CIUDAD_COMIENZO);
        this.heuristica = new HeuristicaConVT();
    }

    public Recorrido getRecorridoABCU() {

        this.heuristica.setCiudadComienzo(CIUDAD_COMIENZO_ABCU);
        this.heuristica.setDistancias(this.distanciasABCU);

        return this.heuristica.getRecorrido();
    }

    public Recorrido getRecorrido() {

        this.heuristica.setCiudadComienzo(CIUDAD_COMIENZO);
        this.heuristica.setDistancias(this.distancias);

        return this.heuristica.getRecorrido();
    }

    public Recorrido getRecorridoSinVT() {

        return this.heuristicaSinVT.getRecorrido();
    }
}
