package stack;

import java.util.ArrayList;

public class StackImplementationUsingArrayList {
	
	
	Integer top;
	ArrayList<Integer> a = new ArrayList<Integer>(100);
	
	StackImplementationUsingArrayList() {
		top = -1;
	}
	
	public boolean isEmpty() {
		
		return top<0;
	}
	
	public void push(int x) {
		top++;
		a.add(top, x);
		System.out.println(x  +" pushed");
	}
	
	public int pop() {
		
		if(top<0) {
			System.out.println("Stack Underflow");
			return -1;
		}
		int x = a.get(top);
		top--;
		return x;
	}
	
	public int peek() {
		
		if(top<0) {
			System.out.println("Stack Underflow");
			return -1;
		}
		int x = a.get(top);
		return x;
	}
	

	public static void main(String[] args) {
		
		StackImplementationUsingArrayList s = new StackImplementationUsingArrayList();
		System.out.println("Stack Empty? "+s.isEmpty());
		
		s.push(10);
		System.out.println("Stack Empty? "+s.isEmpty());
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println("Stack Empty? "+s.isEmpty());
		s.push(20);
		s.push(30);
		s.push(40);
		s.push(50);
		System.out.println("Stack Empty? "+s.isEmpty());
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println("Stack Empty? "+s.isEmpty());
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}

}
