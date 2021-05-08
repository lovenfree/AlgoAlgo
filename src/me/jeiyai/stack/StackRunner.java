package me.jeiyai.stack;

import java.util.EmptyStackException;

/*
 * Stack
 * LIFO 형
 * pop(), peak(), push()
 * */

class Stack<T>{

	//스택의 기본 구조 자기 자신과 다음 주소를 가짐 
	class Node<T>{
		private T data;
		private Node<T> next;
		
		public Node(T data) {
			this.data = data;
		}
	}
	
	
	private Node<T> top;

	public T pop() {
		if(top ==null) {
			throw new EmptyStackException();
		}
		
		T data = top.data;
		top = top.next;
		
		return data;
	}
	
	
	public void push(T item) {
		Node<T> newNode = new Node<T>(item);
		newNode.next = top;
		top = newNode;
	}
	
	
	public T peak() {
		if(top ==null) {
			throw new EmptyStackException();
		}
		return top.data;
	}
	
	public boolean isEmpty() {
		return top == null;
	}
}


public class StackRunner {
	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(1);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		System.out.println("### peak data: " + s.peak());
		System.out.println("### pop data: " + s.pop());
		System.out.println("### pop data: " + s.pop());
		System.out.println("### pop  data: " + s.pop());
		System.out.println("### pop  data: " + s.pop());
		System.out.println("### pop  data: " + s.isEmpty());
		System.out.println("### pop  data: " + s.pop());
		System.out.println("### pop  data: " + s.isEmpty());
		
	}

	
}
