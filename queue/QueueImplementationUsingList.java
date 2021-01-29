package queue;

class Node{
	
	int data;
	Node next;
	
	Node(int data){
		
		this.data = data;
			next  = null;	
	}
}


public class QueueImplementationUsingList {
	
		Node front;
		Node rear;
	
	public void enqueue(int data) {
		
		Node new_node = new Node(data);
		
		if(front == null) {
			front = new_node;
			rear  = new_node;
			System.out.println(data +" is enqueued");
			return;
		}
//		Node temp = rear;
//			 rear = new_node;
//		temp.next = rear;
		rear.next = new_node;
			 rear  = new_node;
		System.out.println(data +" is enqueued");
	}
	
	public void dequeue() {
		
		if(front == null) {
			System.out.println("Queue is empty");
			return;
		}
		System.out.println(front.data +" is dequeued");
		front = front.next;
	}	
	
	public void frontItem() {
		
		if(front == null) {
			System.out.println("Queue is empty");
			return;
		}
		System.out.println("Front item is :" +front.data);
		
	}
	public void rearItem() {
		
		if(front == null) {
			System.out.println("Queue is empty");
			return;
		}
		System.out.println("Rear item is :" +rear.data);
		
	}
	public static void main(String[] args) {
		
		QueueImplementationUsingList q1 = new QueueImplementationUsingList();
		q1.frontItem();
		q1.rearItem();
		q1.enqueue(10);
		q1.enqueue(20);
		q1.enqueue(30);
		q1.enqueue(40);
		q1.frontItem();
		q1.rearItem();
		
		q1.dequeue();
		q1.frontItem();
		q1.rearItem();
		q1.dequeue();
		q1.frontItem();
		q1.rearItem();

		q1.enqueue(50);
		q1.frontItem();
		q1.rearItem();
		q1.dequeue();
		q1.dequeue();
		q1.dequeue();
		q1.dequeue();
		
		q1.enqueue(60);
	}

}
