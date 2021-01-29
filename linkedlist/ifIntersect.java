package linkedlist;

public class ifIntersect {

	public static void checkIntersection(Node head1, Node head2) {
		
		if(head1==null || head2 == null) {
			System.out.println("One of the list is Empty");
			return;
		}
		Node temp = head2;
		while(head1!=null) {
				while(head2!=null) {
					if(head1 == head2) {
						System.out.println(head1.data);
						return;
					}
					head2 = head2.next;
				}
				head1 = head1.next;
				head2 = temp;
		}
		System.out.println("No Intersection Found");
		
	}

}
