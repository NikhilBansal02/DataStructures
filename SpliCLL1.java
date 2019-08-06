//Same program as SplitCLL nut with lesser variables.
package circularlinkedlist;

import linkedlist.Node;

public class SpliCLL1 {
	
	static Node last  = null;
	static Node lastA = null;
	static Node lastB = null;
	
public static void main(String[] args) {
				
		PrintList.printList(last);
	
		splitInTwo();	
		System.out.println("ListA");
		PrintList.printList(lastA);
		System.out.println("ListB");
		PrintList.printList(lastB);
		System.out.println("*****************************************************");
		
		last = CLL1.addToEmpty(last, 12);
		PrintList.printList(last);
		splitInTwo();	
		System.out.println("ListA");
		PrintList.printList(lastA);
		System.out.println("ListB");
		PrintList.printList(lastB);
		System.out.println("*****************************************************");
		
		last = null;
		last = CLL1.addToEmpty(last, 12);
		last = CLL1.addEnd(last,20);
		PrintList.printList(last);
		splitInTwo();	
		System.out.println("ListA");
		PrintList.printList(lastA);
		System.out.println("ListB");
		PrintList.printList(lastB);
		System.out.println("*****************************************************");
		
		last = null;
		last = CLL1.addToEmpty(last, 12);
		last = CLL1.addEnd(last,20);
		last = CLL1.addBegin(last, 11);
		PrintList.printList(last);
		splitInTwo();	
		System.out.println("ListA");
		PrintList.printList(lastA);
		System.out.println("ListB");
		PrintList.printList(lastB);
		System.out.println("*****************************************************");
		
		last = null;
		last = CLL1.addToEmpty(last, 12);
		last = CLL1.addEnd(last,20);
		last = CLL1.addBegin(last, 11);
		last = CLL1.addEnd(last,13);
		PrintList.printList(last);
		splitInTwo();	
		System.out.println("ListA");
		PrintList.printList(lastA);
		System.out.println("ListB");
		PrintList.printList(lastB);
		System.out.println("*****************************************************");
	}

public static void splitInTwo() {
	
	int count = 0;
	Node temp = null;
	int countA = 0;
	Node tempA = null;
	
	if(last == null) { // Handles empty node test case
		System.out.println("No List Exist to Split");
		return;
		}
	
	temp = last.next;
	if(temp == last) { // handles one node test case.
		lastA = last;
		lastB = null;
		return;
		}
	
	do { 							// counting number of nodes in CLL.
		count++;
		temp = temp.next;
	}while(temp!= last.next);
	
	System.out.println(count);
	
	if(count%2 == 1) {//allocating number of nodes to sub lists
		countA = count/2 +1;
	}
	else {
		countA = count/2;	
	}
	
	count = 1;
	while(count < countA) {
		count++;
		temp = temp.next;
	}
	tempA     = temp.next; // holding the pointer to node which is currently pointed by temp.next
	lastA     = temp;      // placing lastA i.e. last of sub-list A.
	temp.next = last.next; // making sub-list A circular
	
	last.next = tempA;    //making sub-list B circular
	lastB     = last;
	return;
	}
}
