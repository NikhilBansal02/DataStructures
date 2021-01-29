package circularlinkedlist;

import linkedlist.Node;

public class Deletion {

	public static void main(String[] args) {
		

		Node last = null;
		
		last = CLL1.addToEmpty(last, 12);
		PrintList.printList(last);
		
		last = deleteNode(last, 12);
		PrintList.printList(last);
		
		last = CLL1.addEnd(last,20);
		last = CLL1.addBegin(last, 11);
		last = CLL1.addEnd(last,13);
		PrintList.printList(last);
		
		last = deleteNode(last, 25);
		last = deleteNode(last, 13);
		PrintList.printList(last);
		
		last = deleteNode(last, 13);
		PrintList.printList(last);
		
		last = deleteNode(last, 11);
		PrintList.printList(last);
		
		last = deleteNode(last, 21);
		PrintList.printList(last);
		
		last = deleteNode(last, 20);
		PrintList.printList(last);

	}
	
	public static Node deleteNode(Node last, int key) {
		
		if (last == null) {
			System.out.println("No List Exist");
			return null;
		}
		if(last == last.next && last.data == key) {
			System.out.println(key +" is the only one node present in list and which is deleted");
			last = null;
			return last;
		}
		Node curr = last.next;
		Node prev = last;
		
		do {
			if(curr.data == key) {
				prev.next = curr.next;
				if(curr == last) {
					last = prev;
				}
				return last;
			}
			prev = curr;
			curr = curr.next;
			
		}while(curr != last.next);
		System.out.println(key +" is not present in List");
		return last;
		
	}

}
