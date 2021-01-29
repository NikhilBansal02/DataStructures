package queue;


public class QueueImplementationUsingArray {
	
	int front, rear, size, capacity;
	int a[];
	
	QueueImplementationUsingArray(int capacity){
		this.capacity = capacity;
				front = 0;
				 size = 0;
				 rear = capacity - 1;
				    a = new int[capacity];
	}
	
	public boolean isEmpty() {
		return (size==0);
	}
	
	public boolean isFull() {
		
		return (size == capacity);
	}
	
	public void frontItem() {
		
		if(isEmpty()) {
			System.out.println("Queue is Empty");
			return ;
		}
		System.out.println("Front item is :" +a[front] );
	}
	
	public void rearItem() {
		
		if(isEmpty()) {
			System.out.println("Queue is Empty");
			return ;
		}
		
		System.out.println("Rear item is :" +a[rear] );
	}
	
	public void enqueue(int item) {
		
		if(isFull()) {
			System.out.println("Queue is Full");
			return;
		}
		
		   rear = (rear+1)%capacity; 
		a[rear] = item;
		   size++;
		   System.out.println(item +" item is enqueued");
	}

	
	public void dequeue() {
		
		if(isEmpty()) {
			System.out.println("Queue is Empty");
			return;
		}
		
		System.out.println(a[front]+" is dequeued");
		front = (front+1)%capacity;
		size--;
	}
	public static void main(String[] args) {
		
		QueueImplementationUsingArray q1 = new QueueImplementationUsingArray(5);
		
		System.out.println("Empty? "+ q1.isEmpty());
		System.out.println("Full? " +q1.isFull());
		
		q1.enqueue(10);
		q1.enqueue(20);
		q1.enqueue(30);
		
		q1.frontItem();
		q1.rearItem();
		
		q1.enqueue(40);
		q1.enqueue(50);
		q1.enqueue(60);
		q1.enqueue(70);
		
		System.out.println("Empty? "+ q1.isEmpty());
		System.out.println("Full? " +q1.isFull());
		
		q1.frontItem();
		q1.rearItem();
		
		q1.dequeue();
		q1.dequeue();
		q1.dequeue();
		
		q1.frontItem();
		q1.rearItem();
		
		q1.dequeue();
		q1.dequeue();
		q1.dequeue();
		
		
	}

}
