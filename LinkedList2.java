//Linked List Deletion using key

package linkedlist;

import linkedlist.PrintList;
import linkedlist.Node;

public class LinkedList2 {

	Node head;
	
	public static void main(String[] args) {
		LinkedList2 list2 = new LinkedList2();
		
		list2.deleteNode(15);//Tests the no list present scenario
		
		 list2.head  = new Node(10);
		Node second  = new Node(11);
		 Node third  = new Node(12);
		 Node fourth = new Node(13);
		 Node fifth  = new Node(14);
		 
		list2.head.next = second;
		    second.next = third;
		     third.next = fourth;
		    fourth.next = fifth;
		    
		    PrintList.printList(list2.head);
		    list2.deleteNode(15);// Tests the no key present scenario
		    
		    list2.deleteNode(10);// Key to be deleted is at the head node
		    PrintList.printList(list2.head);
		    
		    list2.deleteNode(12);// Intermediate Key to be deleted 
		    PrintList.printList(list2.head);
		    
		    list2.deleteNode(14);// Last key to be deleted 
		    PrintList.printList(list2.head);
		    
		    
	}
	//delete node using key value
	public void deleteNode(int key) {
		
		Node temp = head;
		Node prev = null;
		
		if(head == null) {
			System.out.println("No List Exists");
			return;
		}
		
		if(temp.data == key) {
				 head = temp.next;
			temp.next = null;
			return;
		}	
		
		while(temp !=null && temp.data != key) {
			prev = temp;
			temp = temp.next;
		}
		
		if(temp == null) {
			System.out.println("Given key "+key +" is not present");
			return;
		}
		
		prev.next = temp.next;
		temp.next = null;
	}

}