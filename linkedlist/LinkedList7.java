//Reverse linked list
package linkedlist;

public class LinkedList7 {

	Node head;

	public static void main(String[] args) {
		
		LinkedList7 list7 = new LinkedList7();
		
		list7.reverse();
		
		 list7.head  = new Node(20);
		 PrintList.printList(list7.head);
		 
		 list7.reverse();
		 PrintList.printList(list7.head);
		 
		Node second  = new Node(21);
		 Node third  = new Node(22);
		 Node fourth = new Node(23);
		 Node fifth  = new Node(24);
		 
		list7.head.next = second;
		    second.next = third;
		     third.next = fourth;
		    fourth.next = fifth;
		    
		    PrintList.printList(list7.head);
		    
		    list7.reverse();
		    PrintList.printList(list7.head);
		    
		    list7.reverse();
		    PrintList.printList(list7.head);
	}
	
	public void reverse() {
		
		Node prev = null;
		Node next = null;
		Node curr = head;
		
		while(curr!=null) {
			
			next = curr.next;
		curr.next= prev;
		     prev= curr;
		     curr=next;
		}
		head = prev;
	}
}