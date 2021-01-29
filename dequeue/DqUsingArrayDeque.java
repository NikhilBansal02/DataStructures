package dequeue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class DqUsingArrayDeque {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Deque<String> dq = new ArrayDeque<String>();

		// dq.getFirst();
		// Retrieves, but does not remove, the first element of this
		// deque. This method differs from peekFirst only in that it throws an exception
						// if this deque is empty.


		// dq.getLast();
		// Retrieves, but does not remove, the last element of this
		// deque. This method differs from peekLast only in that it throws an exception
		// if this deque is empty.

		dq.peekFirst();// No exception but null if dq is empty
		dq.peekLast();// No exception but null if dq is empty
		dq.peek();// No exception but null if dq is empty

		dq.add("A");// adds from rear
		dq.add("B");
		dq.add("C");
		dq.addFirst("Z");
		dq.addLast("D");
		System.out.println(dq);

		System.out.println(dq.getFirst());
		System.out.println(dq.getLast());
		dq.offer("E");// adds from rear
		dq.offerLast("F");
		dq.offerFirst("Y");

		System.out.println(dq);
		dq.poll();
		System.out.println(dq);
		dq.pollFirst();
		System.out.println(dq);
		dq.pollLast();
		System.out.println(dq);

		Iterator<String> itr = dq.iterator();
		System.out.println("Printing Elements of DQ from Front to Rear");
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		System.out.println("Printing Elements of DQ from Rear to Front");
		Iterator<String> descendingIterator = dq.descendingIterator();
		while (descendingIterator.hasNext()) {
			System.out.println(descendingIterator.next());
		}
		dq.add("A");
		System.out.println(dq);
		dq.removeFirstOccurrence("A");
		System.out.println(dq);
		dq.removeLastOccurrence("A");
		System.out.println(dq);


	}

}
