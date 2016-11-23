package heuristica.modelo;

public class Arista {

    private Integer startVertex;
    private Integer endVertex;
    private Double weight;

    public Arista(Integer sv, Integer ev, Double w) {

        this.startVertex = sv;
        this.endVertex = ev;
        this.weight = w;
    }

    public Double getWeight() {
        return this.weight;
    }

    public Integer getStartVertex() {
        return this.startVertex;
    }

    public Integer getEndVertex() {
        return this.endVertex;
    }
}
