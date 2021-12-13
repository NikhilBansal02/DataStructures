package PriorityQueue;

public class Driver_PQ {

    public static void main(String[] args) {

        PriorityQueue q = new PriorityQueue(10);
        Item a = new Item("Nikhil-1",1);
        Item b = new Item("Nikhil-2",2);
        Item c = new Item("Nikhil-3",3);
        Item d = new Item("Nikhil-4",4);
        Item e = new Item("Nikhil-5",5);

        q.insert(a,b,c,d,e);
        q.getHighestPriority();
        q.print();
        System.out.println("Size of queue is : "+q.size);
        q.deleteHighestPriority();
        q.print();
        q.getHighestPriority();
    }
}
