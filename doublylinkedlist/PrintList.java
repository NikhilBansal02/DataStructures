package doublylinkedlist;


public class PrintList {
	
	public static void printList(Node head) {
		
		Node temp;
		if (head == null) {
			System.out.println("List is empty");
			return;
		}
		
		temp = head;
		
		while(temp!= null) {
			System.out.print(temp.data +" ");
			temp = temp.next;
		}
		
		System.out.println();
	}

}
