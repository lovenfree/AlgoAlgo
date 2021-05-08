package me.jeiyai.stack;
/**
 * 
 * Stack 을 정렬하는 함
 * : 하나의 stack 추가 사용가능, Array 등 다른 데이터 구조 사용 불가 
 * 
 * */


public class StackSortRunner {

	
	
	public static void main(String[] args) {
		 Stack<Integer> s1 = new Stack<Integer>();
		 s1.push(3);
		 s1.push(1);
		 s1.push(2);
		 s1.push(4);
		 sort(s1);
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.pop());
		System.out.println(s1.pop());
	
		 
	}
	
	private static void sort(Stack<Integer> s1) {
		 Stack<Integer> s2 = new Stack<Integer>();
		 while(!s1.isEmpty()) {
			 int tmp = s1.pop();
			 while(!s2.isEmpty() && s2.peak() > tmp) {
				 s1.push(s2.pop());
			 }
			 s2.push(tmp);
		 }
		 
		 while(!s2.isEmpty()) {
			 s1.push(s2.pop());
		 }
	}

}
