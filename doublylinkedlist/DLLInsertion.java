package doublylinkedlist;

public class DLLInsertion {
	
	Node head;

	public static void main(String[] args) {
		
		DLLInsertion DLL1 = new DLLInsertion(); 
		
		
		/*//DLL1.insertAfter(DLL1.head,6);
		//PrintList.printList(DLL1.head);
		//DLL1.push(5);
		//PrintList.printList(DLL1.head);
		//DLL1.push(4);
		DLL1.push(3);
		DLL1.push(2);
		PrintList.printList(DLL1.head);
		
		DLL1.insertAfter(DLL1.head.next,4);
		PrintList.printList(DLL1.head);
		DLL1.push(1);
		PrintList.printList(DLL1.head);
		DLL1.insertAfter(null,4);*/
		
		DLL1.append(5);
		DLL1.insertBefore(DLL1.head, 4);
		PrintList.printList(DLL1.head);
		DLL1.append(8);
		DLL1.append(9);
		PrintList.printList(DLL1.head);
		
		DLL1.insertBefore(DLL1.head.next, 7);
		DLL1.insertBefore(DLL1.head.next, 6);
		PrintList.printList(DLL1.head);
	}
	//At the beginning
	public void push(int data) {
		
		Node new_node = new Node(data);
		
		
		if (head == null) {
			System.out.println("Push Method called");
			head = new_node;
				return;
		}
		
			head.prev = new_node;
		new_node.next = head;
				 head = new_node;
			
	}
	// After a given node;
	public void insertAfter(Node prev_node, int data) {
		
		if(head == null) {
			push(data);
			return;
		}
		
		if (prev_node == null) {
			System.out.println("previous node cannot be null");
			return;
		}
	
		
		Node new_node = new Node(data);
		new_node.next = prev_node.next;
		new_node.prev = prev_node;
		
		prev_node.next= new_node;
		
		if(new_node.next != null) {
			new_node.next.prev = new_node;
		}
		
	}
	
	// At the End.
	public void append(int data) {
		
		if(head == null) {
			push(data);
			return;
			
		}
		
		Node temp = head;
		Node new_node = new Node(data);
		while(temp.next!= null) {
			
			temp = temp.next;
		}
		
		new_node.prev = temp;
		temp.next     = new_node;
	
	}
	
	//Before a given node
	
	public void insertBefore(Node next_node, int data) {
		
		if(next_node == null) {
			System.out.println("next node cannot be null");
			return;
		}
		
		Node new_node = new Node(data);
		new_node.next = next_node;
		new_node.prev = next_node.prev;
		
		if(next_node.prev!=null) {
			next_node.prev.next = new_node;
		}
		next_node.prev= new_node;
	}

}
