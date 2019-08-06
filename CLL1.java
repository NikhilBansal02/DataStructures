package circularlinkedlist;

import linkedlist.Node;


public class CLL1 {

	public static void main(String[] args) {
		
		Node last = null;
		last = addEnd(last,6);
		
		last = addAfter(last, 7, 6);
		PrintList.printList(last);
		
		last = addToEmpty(last, 12);
		last = addEnd(last,20);
		last = addBegin(last, 11);
		last = addToEmpty(last, 10);
		last = addBegin(last, 9);
		last = addEnd(last,13);
		
		PrintList.printList(last);
		
		last = addAfter(last, 12, 11);
		PrintList.printList(last);
		
		last = addAfter(last, 14, 13);
		PrintList.printList(last);
		
		last = addAfter(last, 10, 9);
		PrintList.printList(last);
	}
	
	
	public static Node addToEmpty(Node last, int new_data) {
		
		if(last!= null) {
			return last;
		}
		
		Node new_node = new Node(new_data);
		
				 last = new_node;
		new_node.next = new_node;
		return last;
		
	}
	
	public static Node addBegin(Node last, int new_data) {
		
		if(last == null) {
			return addToEmpty(last, new_data);
		}
		
		Node new_node = new Node(new_data);
		new_node.next = last.next;
		last.next     = new_node;
		return last;
		
	}
	
	public static Node addEnd(Node last, int new_data) {
		
		if(last == null) {
			return addToEmpty(last, new_data);
		}
		
		Node new_node = new Node(new_data);
		new_node.next = last.next;
		    last.next = new_node;
				 last = new_node;
				 
		return last;
		
	}
	
	public static Node addAfter(Node last, int new_data, int item) {
		
		if(last == null) {
			System.out.println("List does not exist");
			return null;
		}
		
		Node temp = last.next;
		Node new_node = null;
		
		do {
			
			if(temp.data == item) {
				new_node = new Node(new_data);
				new_node.next = temp.next;
				temp.next = new_node;
				
				if(temp == last) {
					last = new_node;
				}
				return last;
			}
			temp = temp.next;
			
		}while(temp != last.next);
		System.out.println(item +" is not present in List");
		return last;
		
	}
}