package com.tnsif.list;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListDemo {
	public static void main(String[] args) {
		
		
			LinkedList<Integer> linkedList=new LinkedList<Integer>();
			
			System.out.println(linkedList);
			
			for (int i = 0; i < 10; i++) {
				linkedList.add(i*10);
			}
			
			System.out.println(linkedList);
			
			linkedList.addFirst(-10);
			System.out.println(linkedList);
			linkedList.addLast(200);
			linkedList.add(11, 95);
			System.out.println(linkedList);
			
			System.out.println("First element: "+ linkedList.getFirst());
			System.out.println("Last element: "+ linkedList.getLast());
			System.out.println("8 element: "+ linkedList.get(7));
			
			
			linkedList.removeFirst();
			System.out.println(linkedList);
			linkedList.removeLast();
			System.out.println(linkedList);
			
			ListIterator<Integer> i= linkedList.listIterator();
			
			while (i.hasNext()) {
				System.out.print(i.next()+" ");
			}
			System.out.println();
			ListIterator<Integer> l1 = linkedList.listIterator(linkedList.size());
			
			while (l1.hasPrevious()) {
				System.out.print(l1.previous()+" ");
			
			}
			
		}

	}