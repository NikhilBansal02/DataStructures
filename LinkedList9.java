//Counts the number of times a given int occurs in a Linked List
package linkedlist;

public class LinkedList9 {

	Node head;

	public static void main(String[] args) {
		
		LinkedList9 list9 = new LinkedList9();

		 list9.head  = new Node(20);
		 Node second  = new Node(21);
		 Node third  = new Node(22);
		 Node fourth = new Node(23);
		 Node fifth  = new Node(24);
		 Node sixth  = new Node(24);
		 Node seven  = new Node(24);
		 
		list9.head.next = second;
		    second.next = third;
		     third.next = fourth;
		    fourth.next = fifth;
		    fifth.next  = sixth;
		    sixth.next  = seven;
		    
		    PrintList.printList(list9.head);
		    list9.count(24);
	}
	
	public void count(int key) {
		
		int count = 0;
		Node temp = head;
		
		while(temp != null) {
			
			if(temp.data == key) {
				count++;
			}
			temp = temp.next;	
		}
		System.out.println("Number of occurences of "+key +" is : "+count);
	}
}