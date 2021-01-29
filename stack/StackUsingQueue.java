/*Method 1 (By making push operation costly)
This method makes sure that newly entered element is always at the front of ‘q1’, so that pop operation just dequeues from ‘q1’. 
‘q2’ is used to put every new element at front of ‘q1’.

push(s,x) operation’s step are described below:
Enqueue x to q2
One by one dequeue everything from q1 and enqueue to q2.
Swap the names of q1 and q2
pop(s) operation’s function are described below:
Dequeue an item from q1 and return it.*/

package stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueue {

	Queue<Integer> q1 = new LinkedList<Integer>();
	Queue<Integer> q2 = new LinkedList<Integer>();
	//LinkedList<Integer> l1 = new  LinkedList<Integer>();
	
	int size;

	StackUsingQueue(){
		size = 0;
	}
	
	public void push(int x) {
		
		size++;
		
		q2.add(x);
		
		while(!q1.isEmpty()) {
			q2.add(q1.poll());
		}
		Queue<Integer> q=q1;
		
		q1=q2;
		q2=q;
	}
	
	public void pop() {
		
		if(q1.isEmpty()) {
			System.out.println("Stack is empty");
			return;
		}
		
		System.out.println("Popped out item "+q1.poll());
		size--;
	}
	
	public void top() {
		if(q1.isEmpty()) {
			System.out.println("Stack is empty");
			return;
		}
		
		System.out.println("Item on top "+ q1.peek());
		
	}
	
	public static void main(String[] args) {
		
		StackUsingQueue s1 = new StackUsingQueue();
		
		s1.top();
		s1.push(10);
		s1.push(20);
		s1.top();
		s1.push(30);
		s1.top();
		s1.pop();
		s1.pop();
		s1.pop();
		s1.pop();
		s1.top();
		
		

	}

}
