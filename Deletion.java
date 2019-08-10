package doublylinkedlist;

public class Deletion {
	
	Node head;
	
	public static void main(String[] args) {
		Deletion d1 = new Deletion();
		
		d1.deleteNode(d1.head);
		PrintList.printList(d1.head);
		
		d1.push(5);
		d1.push(4);
		d1.push(3);
		d1.push(2);
		
		PrintList.printList(d1.head);
		d1.deleteNode(d1.head.next.next.next);
		PrintList.printList(d1.head);
	}
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
	
	public void deleteNode( Node del) {
			
		if(head == null || del == null) {
			System.out.println("Either Head or Del is null.");
			return;
		}
		
		if(head == del) {
			head = del.next;
		}
		
		if(del.next!= null) {
			del.next.prev = del.prev;
		}
		if(del.prev != null) {
			del.prev.next = del.next;
		}
		
	}
}
