//Move last element of SLL to front.
//This program works fine in case of no list, 1 node list and more than 1 node list scenarios.
package linkedlist;

public class LinkedList8 {

	Node head;

	public static void main(String[] args) {
		
		LinkedList8 list8 = new LinkedList8();

		 list8.head  = new Node(20);
		Node second  = new Node(21);
		 Node third  = new Node(22);
		 Node fourth = new Node(23);
		 Node fifth  = new Node(24);
		 
		list8.head.next = second;
		    second.next = third;
		     third.next = fourth;
		    fourth.next = fifth;
		    
		    PrintList.printList(list8.head);
		    
		    list8.moveLastToFirst();
		    PrintList.printList(list8.head);
	}
	
	public void moveLastToFirst(){
		
		if(head == null || head.next == null) {
			return;
		}
		
		Node prev = null;
		Node curr = head;
		
		while(curr.next != null) {
			
			prev = curr;
			curr = curr.next;
		}
		
		prev.next = null;
		curr.next = head;
			 head = curr;
		
		
	}
}