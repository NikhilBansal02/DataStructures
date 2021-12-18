package graph.mst;

public class WeightedEdge implements Comparable<WeightedEdge> {

    int src;
    int dest;
    int weight;

    @Override
    public int compareTo(WeightedEdge other) {
        return this.weight - other.weight;
    }
}
