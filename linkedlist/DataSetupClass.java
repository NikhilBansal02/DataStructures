//Linked List Insertion 

package linkedlist;

import linkedlist.PrintList;
import linkedlist.Node;

public class DataSetupClass {
	
	Node head;
	
	public static void main(String[] args) {
		DataSetupClass list1 = new DataSetupClass();
		
		 list1.head = new Node(7);
		Node second = new Node(8);
		Node  third = new Node(9);
		
		list1.head.next = second;
		    second.next =  third;
		    
		    //PrintList.printList(list1.head);
		    
		    list1.push(4);
		    //PrintList.printList(list1.head);
		    
		    list1.insertAfter(list1.head,5 );
		    //PrintList.printList(list1.head);
		    
		    list1.insertAfter(list1.head.next,6 );
		    //PrintList.printList(list1.head);
		    list1.append(10);
		    //PrintList.printList(list1.head);
		    list1.append(11);
		    PrintList.printList(list1.head);
		    
		    DataSetupClass list2 = new DataSetupClass();
		    
		    list2.head = new Node(1);
			Node list2second = new Node(2);
			Node list2third = new Node(3);
			
			list2.head.next = list2second;
			list2second.next =  list2third;
			
			System.out.println("List2 Starts");
			PrintList.printList(list2.head);
			
			list2third.next = list1.head.next;
			PrintList.printList(list2.head);
			ifIntersect.checkIntersection(list1.head,list2.head);
	}
	
	// Adding a node in the beginning
	public void push(int new_data) {
		
		Node new_node = new Node(new_data);
		new_node.next = head;
		         head = new_node;
		System.out.println(new_data +" is pushed to the list");
	}
	
	//Adding a node in between
	public void insertAfter(Node prev_node,int new_data) {
		
		if(prev_node == null) {
			System.out.println("Previous Node cannot be Null");
			return;
		}
		
		Node new_node = new Node(new_data);
		new_node.next = prev_node.next;
		prev_node.next = new_node;
		
	}
	//Insert node in the end
	public void append(int new_data) {
		
		Node new_node = new Node(new_data);
		
		if(head == null) {
			head = new_node;
			return;
		}
		
		Node last = head;
		while(last.next!=null) {
			last = last.next;
		}
		
		last.next = new_node;
		
	}
}
