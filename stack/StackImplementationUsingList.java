package stack;

class Node{
	
	int data;
	Node next;
	
	Node(int data){
		this.data = data;
			 next = null;
	}
}

public class StackImplementationUsingList {
	
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
		System.out.println(data +" Pushed");
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
	
	public static void main(String[] args) {
		StackImplementationUsingList s1 =  new StackImplementationUsingList();
		
		System.out.println(s1.isEmpty());
		s1.push(10);
		s1.push(20);
		s1.push(30);
		s1.push(40);
		System.out.println(s1.isEmpty());
		System.out.println(s1.peek());
		System.out.println(s1.peek());
		System.out.println(s1.pop() +" is popped out");
		System.out.println(s1.peek());
		System.out.println(s1.pop() +" is popped out");
		System.out.println(s1.pop() +" is popped out");
		System.out.println(s1.pop() +" is popped out");
		System.out.println(s1.pop() +" is popped out");
		System.out.println(s1.peek());

	}

}
