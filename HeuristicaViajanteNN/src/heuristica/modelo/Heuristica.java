package heuristica.modelo;

public class Heuristica {

    private HeuristicaEuropa heuristicaEuropa;
    private HeuristicaAmerica heuristicaAmerica;

    public Heuristica() {

        this.heuristicaEuropa = new HeuristicaEuropa();
    }

    public Recorrido getRecorridoAmericaDelSurCVT() {

        this.heuristicaAmerica = new HeuristicaAmericaCVT();

        return this.heuristicaAmerica.getRecorrido();
    }

    public Recorrido getRecorridoAmericaDelSurSVT() {

        this.heuristicaAmerica = new HeuristicaAmericaSVT();

        return this.heuristicaAmerica.getRecorrido();
    }

    public Recorrido getRecorridoEuropa() {

        return this.heuristicaEuropa.getRecorrido();
    }
}
