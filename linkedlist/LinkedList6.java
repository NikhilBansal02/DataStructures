//Program for n’th node from the end of a Linked List
/*Maintain two pointers – reference pointer and main pointer. 
Initialize both reference and main pointers to head.
 First, move reference pointer to n nodes from head. 
Now move both pointers one by one until the reference pointer reaches the end. 
Now the main pointer will point to nth node from the end. */

package linkedlist;

public class LinkedList6 {
	
	Node head;

	public static void main(String[] args) {
		
		LinkedList6 list6 = new LinkedList6();
		list6.printNthFromLast(2);
		
		 list6.head  = new Node(20);
		Node second  = new Node(21);
		 Node third  = new Node(22);
		 Node fourth = new Node(23);
		 Node fifth  = new Node(24);
		 
		list6.head.next = second;
		    second.next = third;
		     third.next = fourth;
		    fourth.next = fifth;
		    
		    PrintList.printList(list6.head);
		    list6.printNthFromLast(2);
		    list6.printNthFromLast(10);
		    list6.printNthFromLast(0);
		    list6.printNthFromLast(1);
		    list6.printNthFromLast(5);
		    list6.printNthFromLast(6);
		    PrintList.printList(list6.head);
		   
	}
	
	public void printNthFromLast(int n) {
		
		if(n<=0 || head == null) {
			System.out.println("Eithe no list exits or invalid value entered");
			return;
		}
		
		Node main = head;
		Node ref  = head;
		
		for(int i=1; i<=n;i++) {
			if(ref == null) {
				System.out.println("Entered number is more than number of nodes present");
				return;
			}
			ref = ref.next;
		}
		
		while(ref!=null) {
			ref = ref.next;
		   main = main.next;	
		}
		System.out.println(main.data);
		
	}

}








