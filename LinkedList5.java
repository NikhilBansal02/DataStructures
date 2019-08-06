//Searching element in LL Iteratively and recursively

package linkedlist;

public class LinkedList5 {
	
	Node head = null;
	
	public static void main(String[] args) {
		
		LinkedList5 list5 = new LinkedList5();
		//System.out.println(list5.searchI(5));
		//System.out.println(list5.searchR(5,list5.head));
		
		 list5.head  = new Node(20);
		Node second  = new Node(21);
		 Node third  = new Node(22);
		 Node fourth = new Node(23);
		 Node fifth  = new Node(24);
		 
		list5.head.next = second;
		    second.next = third;
		    third.next = fourth;
		    fourth.next = fifth;
		    
		    PrintList.printList(list5.head);
		    //System.out.println(list5.searchI(5));
		    /*System.out.println(list5.searchI(20));
		    System.out.println(list5.searchI(21));
		    System.out.println(list5.searchI(23));
		    System.out.println(list5.searchI(24));
		    System.out.println(list5.searchI(25));*/
		    
		   // System.out.println(list5.searchR(5,list5.head));
		     System.out.println(list5.searchR(20,list5.head));
		     System.out.println(list5.searchR(21,list5.head));
		     System.out.println(list5.searchR(23,list5.head));
		     System.out.println(list5.searchR(24,list5.head));
		     System.out.println(list5.searchR(25,list5.head));
	}
	
	public boolean searchI(int key) {
		
		Node temp = head;
		
		while(temp!=null) {
			
			if(temp.data == key) {
				System.out.println(key +" found");
				return true;
			}
			temp = temp.next;
			
		}
		return false;
	}
	
	public boolean searchR(int key, Node ref) {
		
		Node temp = ref;
		
		if(temp == null) {
			return false;
		}
		else {
			if(temp.data == key) {
			return true;
			}
			else{
				return searchR(key,temp.next);
			}	
		}
	}
}
