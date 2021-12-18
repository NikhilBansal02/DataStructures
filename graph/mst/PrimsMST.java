package graph.mst;

import java.util.*;

/**
 * @author Nikhil Bansal
 * Progam - Finding Minimum spanning Tree using Prims Algorithm.
 * @implNote -
 * We iterate over all the vertices of graph.
 *  We start by finding the vertex with minimum value which initially be zeroth index with value of zero.
 *  Once found -
 *  We add this to mstSet
 *  And,we mark its adjacent vertex which are not yet included in mstSet with edge's value if it's lesser than vertex value.
 *  And, we also mark this vertex as parent of these adjacent vertices.
 * At every iteration, vertex's value and its parent can change if it's reachable by any other vertex with lesser cost.
 * Time Complexity - O(V^2)
 */
public class PrimsMST {

    int V = 5;
    public static void main(String[] args) {

    /* Let us create the following graph
        2 3
        (0)--(1)--(2)
        | / \ |
        6| 8/ \5 |7
        | /     \ |
        (3)-------(4)
            9         */
    PrimsMST t = new PrimsMST();
    //Above graph is represented by Adjacency-matrix representation.
    int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
            { 2, 0, 3, 8, 5 },
            { 0, 3, 0, 0, 7 },
            { 6, 8, 0, 0, 9 },
            { 0, 5, 7, 9, 0 } };

    // Print the solution
        t.primMST(graph);

    }

    public void primMST(int graph[][]){

        //This will keep track of parent of node, needed for printing MST.
        int parent[] = new int[V];

        //This will hold the values or weight of edges for every node, needed for reaching it from a particular node.
        int key[] = new int[V];

        //Let's initialise this with INFINITE in beginning.
        Arrays.fill(key,Integer.MAX_VALUE);

        key[0] =0; //As this will be the first vertex to be picked up in MST.
        parent[0] = -1;//Root will not be having any parent.

        //Keeps track of which are vertex are included in mst set.
        boolean mstSet[] = new boolean[V];

        for(int i=0;i<V;i++){

            int u = findKeyWithMinValue(key,mstSet);
            //Add it to mstSet
            mstSet[u] = true;

            for(int v=0;v<V;v++){

                if(graph[u][v] !=0 && mstSet[v] == false && graph[u][v] < key[v]){
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        printMST(parent,graph);
    }

    public int findKeyWithMinValue(int key[], boolean mstSet[]){

        int min = Integer.MAX_VALUE;
        int minIndex=-1;

        for(int v=0;v<V;v++){

            if(mstSet[v] == false && key[v] < min){
                min = key[v];
                minIndex=v;
            }
        }
        return minIndex;
    }

    public void printMST(int parent[],int graph[][]){

        int sum=0;
        System.out.println("MST is - ");

        //Why loop starts from 1,as there is no parent of root.
        for(int i=1;i<V;i++){

            System.out.println(parent[i] +" - " +i +" : "+graph[parent[i]][i]);
            sum = sum + graph[parent[i]][i];
        }
        System.out.println("Total weight of MST - "+sum);
    }
}