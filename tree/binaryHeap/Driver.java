package binaryHeap;

public class Driver {

    public static void main(String[] args) {

        MinHeap minHeap = new MinHeap(10);
        minHeap.insert(5);
        minHeap.insert(3);
        minHeap.insert(17);
        minHeap.insert(10);
        minHeap.insert(84);
        minHeap.insert(19);
        minHeap.insert(6);
        minHeap.insert(8);
        minHeap.insert(11);

        minHeap.print();

        int min = minHeap.remove();
        System.out.println("Minimum value is : "+min);
        minHeap.print();

        minHeap.insert(3);
        minHeap.print();
    }

}
