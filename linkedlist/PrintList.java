package linkedlist;

import linkedlist.Node;

public class PrintList {
	
	public static void printList(Node temp) {
		
		Node n = temp;
		while(n!=null) {
			
			System.out.print(n.data + " ");
			n = n.next;
		}
		System.out.println();
	}

}
