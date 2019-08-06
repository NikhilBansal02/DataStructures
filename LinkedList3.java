//Linked List Deletion using position

package linkedlist;

import linkedlist.PrintList;
import linkedlist.Node;

public class LinkedList3 {

	Node head;
	
	public static void main(String[] args) {
		LinkedList3 list3 = new LinkedList3();
		
		list3.deleteNodeUsingPosition(1);//Tests the no list present scenario
		
		 list3.head  = new Node(10);
		Node second  = new Node(11);
		 Node third  = new Node(12);
		 Node fourth = new Node(13);
		 Node fifth  = new Node(14);
		 
		list3.head.next = second;
		    second.next = third;
		     third.next = fourth;
		    fourth.next = fifth;
		    
		    PrintList.printList(list3.head);
		    list3.deleteNodeUsingPosition(5);// Tests the no position present scenario
		    list3.deleteNodeUsingPosition(8);// Tests the no position present scenario
		    list3.deleteNodeUsingPosition(15);// Tests the no position present scenario
		    PrintList.printList(list3.head);
		    
		    list3.deleteNodeUsingPosition(0);// position to be deleted is at the head node
		    PrintList.printList(list3.head);
		    
		    list3.deleteNodeUsingPosition(2);// Intermediate position to be deleted 
		    PrintList.printList(list3.head);
		    
		    list3.deleteNodeUsingPosition(2);// Last position to be deleted 
		    PrintList.printList(list3.head);
		    
		    list3.deleteNodeUsingPosition(2);// No position to be deleted 
		    PrintList.printList(list3.head);
		    
		    
	}
	//delete node using position
	public void deleteNodeUsingPosition(int pos) {
		int count = 0;
		
		Node prev = null;
		Node temp = head;
		
		if(head == null) {
			System.out.println("No List Exists");
			return;
		}
		
		if(pos == 0) {
			head = head.next;
			return;
		}
		
		while(temp !=null && count != pos) {
			
			count++;
			prev = temp;
			temp = temp.next;
		}
		
		if(temp == null) {
			System.out.println("Given position does not exist");
			return;
		}
		
		prev.next = temp.next;
		temp.next = null;
		
	}
}