package me.jeiayi.queue;

import java.util.NoSuchElementException;

/*
 * Stack
 * FIFO 형
 * add(), remove(), peak(), isEmpty()
 * 
 * */

class Queue<T> {
	class Node<T>{
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
	}
	
	Node<T> first;
	Node<T> last;
	
	
	public void add(T data) {
		Node<T> n = new Node<T>(data);
		if(first == null) {
			first =n;
		}else {
			last.next = n;
		}

		last = n;
	}
	
	public T remove() {
		if(first == null) {
			throw new NoSuchElementException();
		}
		
		T data = first.data;
		first = first.next;
		
		if(first ==null) {
			last =null;
		}
		return data;
	}
	
	
	public T peak() {
		if(first == null) {
			throw new NoSuchElementException();
		}
		
		return first.data;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
}

public class QueueRunner {
	public static void  main(String[] args) {
		Queue<Integer> queue = new Queue<Integer>();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		System.out.println("*** peak: "+queue.peak());
		queue.remove();
		queue.remove();
		queue.remove();
		System.out.println("*** is empty: "+queue.isEmpty());
		queue.remove();	
		queue.remove();	
		System.out.println("*** is empty: "+queue.isEmpty());
	}
}
