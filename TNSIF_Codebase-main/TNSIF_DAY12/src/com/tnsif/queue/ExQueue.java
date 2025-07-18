package com.tnsif.queue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class ExQueue {
public static void main(String[] args) {
	Queue<Integer> q = new LinkedList<Integer>();

	q.add(6);
	q.add(10);
	q.add(12);
	q.add(13);
	q.add(2);

	System.out.println(q);
	System.out.println(q.retainAll(q));
	
	System.out.println("using Peek method first value from queue: " +  q.peek());

	
	System.out.println("Using elemnets method first value from queue: " + q.element());

	System.out.println();
	System.out.println(q.remove());
	System.out.println(q);

	Iterator<Integer> i = q.iterator();
	while (i.hasNext()) {
		System.out.print(i.next() + " ");
	}
	System.out.println();

	System.out.println(q.poll());
	System.out.println(q);

	System.out.println(q.retainAll(q));

}

}
