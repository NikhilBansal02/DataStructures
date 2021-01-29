package linkedlist;

import java.util.Collection;

public class MultiplyStrings {
	
	Node head;

	public static String multiply(String num1, String num2) {
		
		Node list1 =  createListFromStrin(num1);
		Node list2 =  createListFromStrin(num2);
		
		return " ";
	}

	public static void main(String[] args) {

		String num1 = "123";
		String num2 = "456";
		System.out.println(multiply(num1,num2));

	}

	public static Node createListFromStrin(String num) {
		
		Node head = null, temp = null;
		
		char ch[] = num.toCharArray();
		
		for(char c : ch) {
			Node new_node = new Node(Character.getNumericValue(c));
			if(head == null) {
				head = new_node;
				temp = new_node;
			}else {
				temp.next = new_node;
				temp = new_node;
			}
		}
		return head;
	}

}
