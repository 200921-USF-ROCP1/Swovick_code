package com.revature.generic.list;

public class LinkedList<T> {
	private Node head;
	private int size;
	
	public LinkedList() {
		size = 0;
		head = null;
	}
	
	//insert
	// 1. Find the last element (next == null)
	// 2. Create a new node and set as next
	// 3. Increase size
	public void insert(T data) {
		Node node = head;
		if (head == null) {
			head= new Node(data, null);
		}
		else {
			//Find the last element
			while(node.next!=null) {
				node = node.next;
			}
			 //Create the new node and set as next
			Node newNode = new Node(data, null);
			node.next = newNode;
			}
		// Increase size
		size++;
	}
	
	public int getSize() {
		return size;
	}
	
	//get
	// 1. If index >= size, return null
	// 2. Iterate index times;
	public T get(int index) {
		if(index>=size || index < 0) {
			throw new IndexOutOfBoundsException();
		}
		Node itr = head;
		
		for (int i=0; i< index; i++) {
			itr = itr.next;
		}
		return itr.data;
	}
	public Iterator getIterator() {
		return new Iterator();
	}
	public class Iterator {
		Node current;
		
		public Iterator() {
			current = head;
		}
		public boolean hasNext() {
			return current != null;
		}
		public void next() {
			current = current.next;
		}
		public T getData() {
			return current.data;
		}
	}
	class Node {
		private T data;
		private Node next;
		
		Node(T data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
}
