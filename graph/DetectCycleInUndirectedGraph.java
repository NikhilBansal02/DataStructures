package graph;

/**
 * We will be using Dis-joint set (or union-find) data structure to check if cycle exits in graph.
 */
public class DetectCycleInUndirectedGraph {

    int V;
    int E;
    Edge edge[];

    DetectCycleInUndirectedGraph(int v,int e){
        V=v;
        E=e;
        edge = new Edge[E];

        for(int i=0;i<e;i++){
            edge[i] = new Edge();
        }
    }

    public static void main(String[] args) {

        /* Let us create the following graph
        0
        | \
        |  \
        1---2 */

        int V=3;
        int E=3;
        DetectCycleInUndirectedGraph graph =  new DetectCycleInUndirectedGraph(V,E);
        graph.edge[0].src  =0;
        graph.edge[0].dest =1;

        graph.edge[1].src  =0;
        graph.edge[1].dest =2;

        graph.edge[2].src  =1;
        graph.edge[2].dest =2;

        if(graph.isCycle(graph))
            System.out.println("Cycle Exits");
        else
            System.out.println("No Cycle Exits");

    }

    public boolean isCycle(DetectCycleInUndirectedGraph graph){

        int parent[] = new int[V];
        for(int i=0;i<V;i++){
            parent[i] = -1;
        }

        for(int i=0;i<E;i++){

            int x  = find(parent,graph.edge[i].src);
            int y  = find(parent,graph.edge[i].dest);

            //Check if src and dest subsets are same.
            //src belongs to x subset and dest belongs to y subset.
            if(x==y)
                return true;

            union(parent,x,y);
        }
        return false;
    }

    public int find(int parent[], int i){

        if(parent[i] == -1)
            return i;
        return find(parent,parent[i]);

    }

    public void union(int parent[], int x,int y){
        parent[x] = y;
    }

}