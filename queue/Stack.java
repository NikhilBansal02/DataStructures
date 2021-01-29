package queue;

import queue.Node;

public class Stack {
	
	Node root;
	
	public boolean isEmpty() {
		
		return root == null;
	}
	
	public void push(int data) {
		
		Node new_node = new Node(data);
		
		if(root == null) {
			root = new_node;
		}
		else {
		Node temp = root;
			 root = new_node;
		root.next = temp;
		}
		//System.out.println(data +" Pushed");
	}
	
	public int pop() {
		
		if(root == null) {
			System.out.println("Stack Underflow");
			return -1;
		}
		
		int x = root.data;
		root  = root.next;
		return x;
	}
	public int peek() {
		
		if(root == null) {
			System.out.println("Stack Underflow");
			return -1;
		}
		return root.data;
	}

}
