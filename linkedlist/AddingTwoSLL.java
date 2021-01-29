package linkedlist;


public class AddingTwoSLL {

	Node head;

	public static Node addTwoNumbers(Node l1, Node l2) {
		Node resHead = new Node(0);
		Node res = resHead;
		
		int intermediate_result = 0;
		int carry=0;
		int x, y ;
		
		while(l1!=null || l2!=null) {
			
			x = (l1!= null) ? l1.data :0;
			y = (l2!= null) ? l2.data :0;
			
			intermediate_result = x + y + carry;
			
			carry = intermediate_result/10;
			intermediate_result = intermediate_result%10;
			
			res.next  = new Node(intermediate_result);
			res = res.next;	
				
			if(l1!=null)  l1= l1.next;
			if(l2!=null)  l2 = l2.next;
		}
		if (carry>0) {
			res.next  = new Node(carry);
		}
		
		
		return resHead.next;
	}

	public static void main(String[] args) {

		AddingTwoSLL list1 = new AddingTwoSLL();

		list1.head = new Node(7); // 7 ->8 ->9
		Node second = new Node(8);
		Node  third = new Node(9);

		list1.head.next = second;
		second.next =  third;

		AddingTwoSLL list2 = new AddingTwoSLL();

		list2.head = new Node(5); // 5 -> 4
		Node second2 = new Node(4);
	//	Node  third2 = new Node(9);

		list2.head.next = second2;
		//second2.next =  third2;
		
		Node result = addTwoNumbers(list1.head, list2.head);
		PrintList.printList(result); //->   1032 --> 2->3->0->1

	}

}
