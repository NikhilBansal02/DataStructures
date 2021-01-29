package stack;

public class StackImplementationUsingArray {
	
	static final int MAX = 100;
	int top;
	int a[] = new int[MAX];
	
	StackImplementationUsingArray() {
		top = -1;
	}
	
	public boolean isEmpty() {
		
		return top<0;
	}
	
	public void push(int x) {
		
		if(top>=(MAX-1)) {
			System.out.println("Stack Overflow");
			return;
		}
		a[++top] = x;
		System.out.println(x  +" pushed");
	}
	
	public int pop() {
		
		if(top<0) {
			System.out.println("Stack Underflow");
			return -1;
		}
		int x = a[top--];
		return x;
	}
	
	public int peek() {
		
		if(top<0) {
			System.out.println("Stack Underflow");
			return -1;
		}
		int x = a[top];
		return x;
	}
	

	public static void main(String[] args) {
		
		StackImplementationUsingArray s = new StackImplementationUsingArray();
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
