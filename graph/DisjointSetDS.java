package graph;

/**
 * The Dis-joint set data structure maintains sets of data in non-overlapping way.
 * Each set is represented by its representative which defines that a member belongs to this particular set.
 * If two elements has same representative it means they are already reachable to each other via directly or indirectly.
 *      Direct - Means like a direct node was added like some edge in tree.
 *      Indirectly - Means they are reachable via edge of edge and if we add these two elements then a cycle will result.
 *          Hence, this can be used to detect if cycle is present or not among given data.
 *          Also, if we need to find that if there is any relationship between members or not like mutual friends.
 * We use find by path compression - which is each element know its leader/representative directly.
 * & union by rank - which is used to merge two set by add smaller set under large one and uses larger set representative as its leader.
 *https://www.geeksforgeeks.org/disjoint-set-data-structures/
 */
public class DisjointSetDS {

    int parent[];
    int rank[];
    int n;

    DisjointSetDS(int n){
        parent = new int[n];
        rank = new int[n];
        this.n = n;
        initLeaders();
    }

    //Initially,every element is represented by itself.
    public void initLeaders(){

        for(int i=0;i<n;i++){
            parent[i]=i;
        }
    }

    public void union(int x,int y){

        int xroot = find(x);//Holds representative of x.
        int yroot = find(y);//Holds representative of y.

        if(xroot == yroot) //if x and y have same representative, it means they already belong to same set and there is no meaning to add them.
            return;

        //This is union by rank menaing we will always add smaller height leader under larger height leader to
        //ensure number of hops will be less to find the representative by any element.
        if(rank[xroot] < rank[yroot]){
            parent[xroot] = yroot;
        }else if(rank[yroot] < rank[xroot]){
            parent[yroot] = xroot;
        }else{ // Both xroot & yroot have same rank, meaning both have tree of same height.
                parent[yroot] = xroot;
                rank[xroot] = rank[xroot] +1;
        }
    }

    //This method will return the representative of the element.
    public int find(int x){

        if(parent[x]!=x){
            parent[x] = find(parent[x]);//This is path compression as we are saving the leader at every element.
        }

        return parent[x];

    }
    public static void main(String[] args) {
        int n = 5; //this defines the element which is 0-4.
        DisjointSetDS ds = new DisjointSetDS(n);

        ds.union(0,2);
        ds.union(4,2);
        ds.union(3,1);

        // Check if 4 is a friend of 0
        if (ds.find(4) == ds.find(0))
            System.out.println("Yes");
        else
            System.out.println("No");

        // Check if 1 is a friend of 0
        if (ds.find(1) == ds.find(0))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

}
