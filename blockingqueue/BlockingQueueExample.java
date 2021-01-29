package blockingqueue;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueExample {

	public static void main(String[] args) {
		Iterable t = null;
		Collection c = null;
		Queue q = null;

		// BlockingQueue<String> bq = new ArrayBlockingQueue<String>(50);
		BlockingQueue<String> bq = new LinkedBlockingQueue<String>(50);
		// BlockingQueue<String> bq = new PriorityBlockingQueue<String>(50);

		bq.add("Hello");
		bq.add("bye");
		bq.add("Hi");
		bq.add("why");

		Iterator<String> itr = bq.iterator();
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

	}

}
