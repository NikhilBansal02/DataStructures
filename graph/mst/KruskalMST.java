package graph.mst;

import java.util.*;
//Time Complexity: O(ElogE) or O(ElogV).
public class KruskalMST {

    int V;
    int E;
    WeightedEdge Edges[];

    KruskalMST(int V, int E){
        this.V = V;
        this.E = E;
        Edges = new WeightedEdge[E];

        for(int i=0;i<E;i++){
            Edges[i] = new WeightedEdge();
        }
    }

    public void generateMST(){

        //Create an array which will hold the resultant graph.
        WeightedEdge result[] = new WeightedEdge[V-1];

        //Generate initial representative of elements/vertices.
        int parent[] = new int[V];
        for(int i=0;i<V;i++){
            parent[i] = i;
        }

        //Generate Rank of each element, initially it will be zero, meaning height of tree is zero.
        //This will be used during Union for union by rank operation.
        int rank[] = new int[V];

        //Sort the Edges in non-decreasing order.
        Arrays.sort(Edges);

        /**
         * We have to include V-1 edges to create MST.
         * Hence, running loop to include only V-1 edges.
         */
        int e=0;
        int i=0;
        while(e<V-1){//Since, loop started at zero hence it will go just before V-1, total will be V-1 edges.

            WeightedEdge edge = Edges[i++];
            int xroot = find(parent,edge.src);
            int yroot = find(parent,edge.dest);

            if(xroot == yroot){
                continue;
            }else{
                result[e++] = edge;
                union(parent,rank,xroot,yroot);
            }
        }

        printMST(result);
    }

    //find() uses path compression where every vertex stores its representative directly to minimize the hops to reach to its representative.
    public int find(int parent[], int x){

        if(parent[x] !=x){
            parent[x] = find(parent,parent[x]);
        }
        return parent[x];
    }

    //Merging two sets by checking the rank aka height or size of two sets.
    public void union(int parent[], int rank[],int xroot, int yroot){

        if(rank[xroot] < rank[yroot]){
            parent[xroot] = yroot;
        }else if(rank[yroot] < rank[xroot]){
            parent[yroot] = xroot;
        }else{
            parent[yroot] = xroot;
            rank[xroot] = rank[xroot]+1;
        }

    }

    public void printMST(WeightedEdge[] result){
        System.out.println("MST is - ");
        int sum=0;
        for(WeightedEdge e : result){
            System.out.println(e.src +" => " +e.dest +" : "+e.weight);
            sum = sum +e.weight;
        }
        System.out.println("Total weight of MST - "+sum);
    }
}
