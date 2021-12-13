package binaryHeap;

/**
 * @author Nikhil Bansal
 * Class provides the basic opetions on minHeap like insertion and rempoval of elements.
 * TC - O(logn)
 *
 * Operations -
 * Insertion - O(logn)
 * Deletion or Removing the front element - O(logn)
 * getMin() - O(1)
 * Searching - This is simply looking into array for particular element - O(logn)
 * Removing a particular element - This can simply be implemented by first searching for element and if present then
 *  replacing it with last element in array and then call minHeapify in that paricular index/node where element is found
 *  to maintain min heap property - O(logn)
 */
public class MinHeap {

    int size = 0;
    int maxSize;
    int Heap[];
    static final int FRONT =1;

    MinHeap(int maxSize){
        this.maxSize = maxSize;
        size = 0;
        Heap = new int[maxSize +1];
        Heap[0] = Integer.MIN_VALUE;
    }

    //For insertion, element is inserted at the last and recursivley checked if it is greater than its parent.
    //If yes then it is swapped with its parent and then parent is set as current node and checked with its parent.
    //Hence, for insertion we go from bottom to top of tree.
    public void insert(int key){

        if(size >= maxSize){
            System.out.println("Heap is completely filled");
            return;
        }

        Heap[++size] = key;
        int current = size;

        while(Heap[current] < Heap[parent(current)]){
            swap(current, parent(current));
            current = parent(current);
        }

    }

    public int parent(int pos){
        return pos/2;
    }

    public void swap(int child, int parent){

        int temp = Heap[child];
        Heap[child] = Heap[parent];
        Heap[parent] = temp;
    }

    public void print(){

        for(int i=1;i<=size/2;i++){

            System.out.println("Root : "+Heap[i]+" Left Child : "+Heap[2*i]+" Right Child : "+Heap[2*i+1]);
        }
        System.out.println();
    }

    /**
     * Removing the minimum element.
     * For remove, the first element is removed as it is being the minimum element.
     * Then Top element is being replaced with the last element at size.
     * MinHeapify is then called to maintain the min heap property.
     * Top element is then compared with its left and right child to satisfy the min heap property.
     * If this is smaller than any of its child then a swapping happens between the top and the smaller child.
     * minHeapify is then called on smaller child index.
     * This process contniues till we encounter any leaf or min heap propert is satisfied by node with children meaning
     * node has no smaller left and right child.
     */
    public int remove(){

        int popped = Heap[FRONT];
        Heap[FRONT] = Heap[size];
        Heap[size] = Integer.MAX_VALUE;
        size--;
        minHeapify(FRONT);
        return popped;
    }

    public void minHeapify(int pos){

        if(!leaf(pos)){
            if(Heap[pos] > Heap[leftChild(pos)] ||
                Heap[pos] > Heap[rightChild(pos)]){

                if(Heap[leftChild(pos)] <= Heap[rightChild(pos)]){
                    swap(pos, leftChild(pos));
                    minHeapify(leftChild(pos));
                }else{
                    swap(pos,rightChild(pos));
                    minHeapify(rightChild(pos));
                }

            }
        }
    }

    public boolean leaf(int pos){

        if(pos > size/2 && pos <=size){
            return true;
        }
        return false;
    }

    public int leftChild(int pos){
        return 2*pos;
    }

    public int rightChild(int pos){
        return (2*pos)+1;
    }

    /**
     * Getting the minimum element or first element.
     */
    public int getMin(){
        return Heap[FRONT];
    }

}
