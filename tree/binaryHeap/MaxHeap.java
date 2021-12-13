package binaryHeap;

/**
 * This class provides the implementation of Max heap.
 * Below are the operations and their time complexity.
 * insert() - O(logn)
 * extractMax() - Removing the maximum element from the heap - O(logn)
 * getMax() - Get the maximum element or FRONT element from the heap - O(1)
 * print() - prints heap elements - O(n)
 * search(item) - This can be easily done by doing a search over heap array - O(logn)
 * delete(item) - search(item) first, if found then called call extractMax(pos) on that pos.
 *  We need to have one simple implementation of extractMax(pos) which accpets pos, a clone of extractMax() method.
 *  This will then to maxHeapify() on that pos to maintain max heap property. - O(logn)
 */
public class MaxHeap {

    int size = 0;
    int maxSize;
    int Heap[];
    static final int FRONT =1;

    MaxHeap(int maxSize){
        this.maxSize = maxSize;
        size = 0;
        Heap = new int[maxSize +1];
        Heap[0] = Integer.MAX_VALUE;
    }

    public void insert(int key){

        if(size>=maxSize){
            System.out.println("Heap is full!!!!");
            return;
        }

        Heap[++size] = key;
        int current = size;

        while(Heap[current] > Heap[parent(current)]){
            swap(current,parent(current));
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

    public int getMax(){
        return Heap[FRONT];
    }

    public int extractMax(){

        int poppedItem = Heap[FRONT];
        Heap[FRONT] = Heap[size];
        Heap[size] = Integer.MIN_VALUE;
        size--;

        maxHeapify(FRONT);
        return poppedItem;

    }

    public void maxHeapify(int pos){

        if(!isLeaf(pos)){

            if(Heap[leftChild(pos)] > Heap[pos]  ||
                    Heap[rightChild(pos)] > Heap[pos]){

                if(Heap[leftChild(pos)] > Heap[rightChild(pos)]){
                    swap(pos,leftChild(pos));
                    maxHeapify(leftChild(pos));
                }else{
                    swap(pos,rightChild(pos));
                    maxHeapify(rightChild(pos));
                }

            }
        }
    }

    public boolean isLeaf(int pos){

        if(pos > size/2 && pos<=size){
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
}
