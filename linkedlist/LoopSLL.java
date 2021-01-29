package linkedlist;

public class LoopSLL {

	Node head;

	public static void main(String[] args) {

		LoopSLL list = new LoopSLL();
		list.head   = new Node(1);
		Node second = new Node(2);
		Node third 	= new Node(3);
		Node fourth = new Node(4);
		Node fifth  = new Node(5);

		list.head.next = second;
		   second.next = third;
		   third.next  = fourth;
		   fourth.next = fifth;
		   
		   PrintList.printList(list.head);
		   
		   fifth.next = second;
		   
		   detectAndRemoveLoop(list.head);
		   PrintList.printList(list.head);

	}

	private static void detectAndRemoveLoop(Node head) {
		
		Node slow = head;
		Node fast = head;
		boolean flag = false;
		
		while(slow!=null && fast!=null && fast.next !=null) {
			
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast) {
				flag = true;
				break;
			}
		}
		if(flag) {
			System.out.println("Loop");
			removeLoop(slow,head);
			System.out.println("Loop Removed");
		}
		else
			System.out.println("No Loop");
		
	}

	private static void removeLoop(Node slow, Node head) {
		
		Node ptr1 = head;
		Node ptr2 = slow;
		
		while(true) {
			
			while(ptr2.next!= slow && ptr2.next != ptr1) {
				ptr2 = ptr2.next;
			}
			
			if(ptr2.next == ptr1) 
				break;
			
			ptr1 = ptr1.next;
			ptr2 = slow;
		}
		ptr2.next = null;
		
	}

}
