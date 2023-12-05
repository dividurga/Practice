package homework9;

import java.util.Iterator;

public class Question4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<Integer> d1 = new Deque<>();
		d1.pushLeft(20);
		d1.pushLeft(30);
		d1.pushLeft(40);
		d1.pushLeft(50);
		d1.pushRight(20);
		d1.pushRight(30);
		d1.pushRight(40);
		d1.pushRight(50);
		for (int a : d1) {
			System.out.print(a+ " ");
		}
		System.out.println();
		d1.popLeft();
		for (int a : d1) {
			System.out.print(a+ " ");
		}
		System.out.println();
		d1.popRight();
		for (int a : d1) {
			System.out.print(a+ " ");
		}
		System.out.println();
		// enhanced for loop implementation to test iterable
		System.out.println(d1.size());
		
	}

	public static class Deque<Item> implements Iterable<Item> {
		private Node first;
		private Node last;
		private int N; // number of items in the deque

		private class Node {
			Item item;
			Node next;
			Node prev;
		}

		public boolean isEmpty() {
			return N == 0;
		}

		public int size() {
			return N;
		}

		public void pushRight(Item item) {
			Node newlast = new Node();
			if (isEmpty()) {
				newlast.item = item;
				first = newlast;
				last = newlast;
			} else {
				newlast.item = item;
				newlast.next = null;
				newlast.prev = last;
				last.next = newlast;
				last = newlast;
			}
			N++;
		}

		public void pushLeft(Item item) {
			Node newfirst = new Node();
			if (isEmpty()) {
				newfirst.item = item;
				first = newfirst;
				last = newfirst;

			} else {
				newfirst.item = item;
				newfirst.next = first;
				newfirst.prev = null;
				first.prev = newfirst;
				first = newfirst;
			}
			N++;
		}

		public Item popLeft() {
			Item item = first.item;
			first = first.next;
			first.prev = null;
			if (isEmpty())
				last = null;
			N--;
			return item;
		}

		public Item popRight() {
			Item item = last.item;
			last = last.prev;
			last.next = null;
			if (isEmpty())
				first = null;
			N--;
			return item;
		}

		public Iterator<Item> iterator() {
			return new ListIterator();
		}

		private class ListIterator implements Iterator<Item> {
			private Node current = first;

			public boolean hasNext() {
				return current != null;
			}

			public Item next() {
				Item item = current.item;
				current = current.next;
				return item;
			}

		}
	}
}
