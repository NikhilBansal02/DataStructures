package dequeue;

import java.util.Deque;
import java.util.LinkedList;

public class PallindromeCheckUsingDequeue {

	private static Deque<String> dq = new LinkedList<String>();

	public static void pallindromeCheckUsingDequeue(String input_String) {

		if(input_String.isEmpty()) {
			System.out.println("Empty String");
			return;
		}

		fillDeque(input_String);
		System.out.println(dq);
		int size = dq.size();

		if (size % 2 == 0) {
			System.out.println("even");
			while (!dq.isEmpty()) {

				if (!(dq.removeFirst().equalsIgnoreCase(dq.removeLast()))) {
					System.out.println("Not Pallindrome");
					return;
				}

			}
			System.out.println("Pallindrome");

		} else {
			System.out.println("odd");
			int index = 1;
			
			while (index <= (size - 1) / 2) {
				if (!(dq.removeFirst().equalsIgnoreCase(dq.removeLast()))) {
					System.out.println("Not Pallindrome");
					return;
				}
				index++;
			}
			System.out.println("Pallindrome");
		}
	}

	private static void fillDeque(String input_String) {

		dq.clear();
		char ch[] = input_String.toCharArray();

		for(char c : ch) {
			dq.addLast(Character.toString(c));
		}
	}

	public static void main(String[] args) {

		String input = "rmdar";

		pallindromeCheckUsingDequeue(input);

	}

}
