package me.jeiayi.queue;

import java.util.Stack;

/*
 * 두개의 stack으로 Queue 구현하
 * */

class MyQueue<T>{
	Stack<T> stackNewest, stackOldest;
	
	MyQueue(){
		stackNewest = new Stack<T>();
		stackOldest = new Stack<T>();
	} 
	
	public int size() {
		return stackNewest.size()+ stackOldest.size();
	}
	
	public void add(T data) {
		stackNewest.push(data);
	}
	
	public void shiftStacks() {
		if(stackOldest.isEmpty()) {
			while(!stackNewest.isEmpty()) {
				stackOldest.push(stackNewest.pop());
			}
		}
	}
	
	public T peek() {
		shiftStacks();
		return stackOldest.peek();
	}
	
	public T remove() {
		shiftStacks();
		return stackOldest.pop();
	}
	
	
}
public class QueueWith2StackRunner {
	public static void main(String[] args) {
		MyQueue<Integer> q = new MyQueue<Integer>();
		q.add(1);
		q.add(2);
		q.add(3);
		System.out.println(q.peek());
		System.out.println(q.remove());
		System.out.println(q.size());
		
		
	}
}
