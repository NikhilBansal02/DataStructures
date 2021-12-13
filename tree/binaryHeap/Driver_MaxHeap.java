package binaryHeap;

public class Driver_MaxHeap {

    public static void main(String[] args) {

        MaxHeap maxHeap = new MaxHeap(10);
        maxHeap.insert(5);
        maxHeap.insert(3);
        System.out.println("Max element is : "+maxHeap.getMax());
        maxHeap.insert(17);
        System.out.println("Max element is : "+maxHeap.getMax());
        maxHeap.insert(10);
        maxHeap.insert(84);
        maxHeap.insert(19);
        maxHeap.insert(6);
        maxHeap.insert(22);
        maxHeap.insert(9);

        maxHeap.print();

        System.out.println("Max element is : "+maxHeap.getMax());
        System.out.println("Max element is : "+maxHeap.extractMax());

        maxHeap.print();
        maxHeap.insert(84);
        maxHeap.print();
    }
}
