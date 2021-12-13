package PriorityQueue;

/**
 * @author Nikhil Bansal
 * This calls prvides the implemention of priority queue using Max-Heap Data structure.
 * Below are the supported operations along with their time-complexity -
 * ----------------------------------------
 *    Operation                   TC
 *   insert()                   O(logn)
 *   getHighestPriority()       O(1)
 *   deleteHighestPriority      O(logn)
 * ----------------------------------------
 */
public class PriorityQueue {

    int size=0;
    int maxSize=0;
    Item Heap[];
    final int FRONT =0;

    PriorityQueue(int maxSize){
        this.maxSize = maxSize;
        Heap = new Item[maxSize];
    }
    public void insert(Item ...a){
        for(Item i:a){
            insert(i);
        }
    }
    public void insert(Item item){

        if(size >=maxSize){
            System.out.println("Heap is full..!!");
            return;
        }

        Heap[size] = item;
        int current = size;
        size++;

        while(Heap[current].getPriority() > Heap[parent(current)].getPriority()){

            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int parent(int pos){
        return Math.abs(pos-1)/2;
    }

    public void swap(int child, int parent){

        Item temp = Heap[child];
        Heap[child] = Heap[parent];
        Heap[parent] = temp;
    }

    public void print() {

        int l = 0;
        int r = 0;

        for (int i = 0; i < size / 2; i++) {

            l = 2 * i + 1;
            r = 2 * i + 2;

            System.out.print("Root - (" + Heap[i].getPriority() + "," + Heap[i].getKey() + "), ");

            if(Heap[l]!=null)
                System.out.print("Left Child - (" + Heap[l].getPriority() + "," + Heap[l].getKey() + "), ");

            if(Heap[r]!=null )
                System.out.println("Right Child - (" + Heap[r].getPriority() + "," + Heap[r].getKey()+")");
        }
        System.out.println();
    }

    public void getHighestPriority(){

        if(size == 0){
            System.out.println("No item found");
            return;
        }
        System.out.println("Highest Priority Element - Key: "+Heap[FRONT].getKey() +", Priority: "+Heap[FRONT].getPriority());
    }

    public void deleteHighestPriority(){

        if(size <=0){
            System.out.println("No item to delete");
            return;
        }

        Item itemDeleted = Heap[FRONT];
        Heap[FRONT] = Heap[--size];
        Heap[size] = null;

        maxHeapify(FRONT);
        System.out.println("Item Deleted - "+ itemDeleted);
    }

    public void maxHeapify(int pos){
        int largestIndex =-1;
        if(!isLeaf(pos)){

            if(Heap[leftChild(pos)]!=null)
                if (Heap[leftChild(pos)].getPriority() > Heap[pos].getPriority())
                    largestIndex = leftChild(pos);

            if(Heap[rightChild(pos)]!=null)
                if (Heap[rightChild(pos)].getPriority() > Heap[largestIndex].getPriority())
                    largestIndex = rightChild(pos);


            if(largestIndex!= -1){
                swap(pos,largestIndex);
                maxHeapify(largestIndex);
            }
        }
    }

    public boolean isLeaf(int pos){

        if(pos > (size)/2 && pos <=size){
            return true;
        }
        return false;
    }

    public int leftChild(int pos){
        return (2*pos)+1;
    }

    public int rightChild(int pos){
        return (2*pos)+2;
    }
}
