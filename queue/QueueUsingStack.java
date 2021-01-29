//The program demonstrates queue functionality using stack.
//Program uses two stacks S1 and S2.
/*enQueue(x)
  1) Push x to stack1 (assuming size of stacks is unlimited).
Here time complexity will be O(1)

deQueue()
  1) If both stacks are empty then error.
  2) If stack2 is empty
       While stack1 is not empty, push everything from stack1 to stack2.
  3) Pop the element from stack2 and return it.
Here time complexity will be O(n)*/

//The stack class is the one implemented by me not the one provided by Java.

package queue;


public class QueueUsingStack {
	
	Stack s1;
	Stack s2;
	
	public void enqueue(int x) {
		
		s1.push(x);
	}
	public void dequeue() {
		
		if(s1.isEmpty() && s2.isEmpty()) {
			System.out.println("Queue is empty");
			return;
		}
		if(s2.isEmpty()) {
			
			while(!s1.isEmpty()) {
				s2.push(s1.pop());
			}
			
		}
		System.out.println(s2.pop()+" is dequeued");
	}


	public static void main(String[] args) {
		
		QueueUsingStack q1 = new QueueUsingStack();
		
		q1.s1 = new Stack();
		q1.s2 = new Stack();
		
		q1.dequeue();
		q1.enqueue(10);
		q1.enqueue(20);
		q1.enqueue(30);
		//System.out.println(q1.s1.peek());
		q1.dequeue();
		q1.dequeue();
		q1.dequeue();
		q1.dequeue();

		
	}

}
