package heuristica.modelo;

public class Heuristica {

    private HeuristicaEuropa heuristicaEuropa;
    private HeuristicaAmerica heuristicaAmerica;

    public Heuristica() {

        this.heuristicaAmerica = new HeuristicaAmerica();
        this.heuristicaEuropa = new HeuristicaEuropa();
    }

    public Recorrido getRecorridoAmericaDelSur() {

        return this.heuristicaAmerica.getRecorrido();
    }

    public Recorrido getRecorridoEuropa() {

        return this.heuristicaEuropa.getRecorrido();
    }
}
