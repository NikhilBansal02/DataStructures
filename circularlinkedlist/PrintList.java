package circularlinkedlist;

import linkedlist.Node;

public class PrintList {
	
	public static void printList(Node last) {
		
		Node temp;
		if (last == null) {
			System.out.println("List is empty");
			return;
		}
		
		temp = last.next;
		
		
		do {
			System.out.print(temp.data +" ");
			temp = temp.next;
			
		}while(temp!= last.next);
		System.out.println();
	}

}
