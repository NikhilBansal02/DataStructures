//Number of nodes in LL counted Iteratively and Recursively
package linkedlist;

public class LinkedList4 {
	
	Node head = null;

	public static void main(String args[]) {
		
		LinkedList4 list4 = new LinkedList4();
		
		//System.out.println("Number of nodes in LL :"+list4.getCountI());
		System.out.println("Number of nodes in LL :"+list4.getCountR(list4.head));
		
		 list4.head  = new Node(10);
		Node second  = new Node(11);
		 Node third  = new Node(12);
		 Node fourth = new Node(13);
		 Node fifth  = new Node(14);
		 
		list4.head.next = second;
		    second.next = third;
		    third.next = fourth;
		    fourth.next = fifth;
		    
		    PrintList.printList(list4.head);
		   // System.out.println("Number of nodes in LL :"+list4.getCountI());
		    System.out.println("Number of nodes in LL :"+list4.getCountR(list4.head));
	}
	
	public int getCountI() {
		
		int count = 0;
		Node temp = head;

			while(temp !=null) {
				count++;
				temp = temp.next;
			}
			return count;		
	}
	
public int getCountR(Node ref) {
		
		//int count = 0;
		Node temp = ref;

			if(temp == null) {
				return  0;
			}
			else {
				//return (++count) + getCountR(temp.next);
				return 1 + getCountR(temp.next);//more optimized as count variable is not used.
			}
	}

}
