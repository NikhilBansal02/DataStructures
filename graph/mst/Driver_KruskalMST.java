package graph.mst;

public class Driver_KruskalMST {

    public static void main(String[] args) {
        /* Let us create following weighted graph
                 10
            0--------1
            |  \     |
           6|   5\   |15
            |      \ |
            2--------3
                4       */

        int V = 4; // Number of vertices in graph
        int E = 5; // Number of Edgess in graph
        KruskalMST graph = new KruskalMST(V, E);

        // add Edges 0-1
        graph.Edges[0].src = 0;
        graph.Edges[0].dest = 1;
        graph.Edges[0].weight = 10;

        // add Edges 0-2
        graph.Edges[1].src = 0;
        graph.Edges[1].dest = 2;
        graph.Edges[1].weight = 6;

        // add Edges 0-3
        graph.Edges[2].src = 0;
        graph.Edges[2].dest = 3;
        graph.Edges[2].weight = 5;

        // add Edges 1-3
        graph.Edges[3].src = 1;
        graph.Edges[3].dest = 3;
        graph.Edges[3].weight = 15;

        // add Edges 2-3
        graph.Edges[4].src = 2;
        graph.Edges[4].dest = 3;
        graph.Edges[4].weight = 4;

        // Function call
        graph.generateMST();
    }
}
