package me.jeiyai.linkedlist;

import java.util.HashSet;

import me.jeiyai.linkedlist.LinkedList.Node;

class LinkedList{
	Node header;
	
	LinkedList(){
		header = new Node();
	}
	
	static class Node{
		Node next = null;
		int data;
		
		Node get(int idx) {
			Node n = this;
			int i=0;
			while(n.next!=null) {
				if(idx==i) {
					return n;
				}else {
					i++;
					n=n.next;
				}
			}
			return null;
		}
	}
			

	void append(int data) {
		Node end = new Node();
		end.data = data;
		
		Node n = header;
		while(n.next!=null) {
			n=n.next;
		}
		
		n.next  = end;
	}
	
	void delete(int data) {
		Node n = header;
		while(n.next!=null) {
			if(n.next.data == data) {
				n.next = n.next.next;
			}else {
				n= n.next;
			}
		}
	}
	

	
	void retrieve() {
		Node n = header.next;
		while(n.next!=null) {
			System.out.print(n.data+"->");
			n = n.next;
		}
		
		System.out.println(n.data);
	}
	
}



public class LinkedListRunner{
		
	public static void  main(String[] args) {
		LinkedList head =  new LinkedList();
		head.append(2);
		head.append(3);
		head.append(1);
		head.append(2);
		head.append(4);
		head.retrieve();
//		head.append(6);
//		head.retrieve();
//		head.delete(2);
//		head.retrieve();
		
		/*
		duplicateDelete(head);
		head = duplicateDeleteUsingSpace(head);
		System.out.println("### ");
		head.retrieve();
		*/
		
	
//		Node deleteNode =  head.header.next.next.next;
//		deleteNodeRunner(deleteNode);
//		head.retrieve();
		
//		sumRunner();
		getIntersection(); 		
	}
	
	public static void sumRunner() {
		LinkedList l1 =  new LinkedList();
		l1.append(9);
		l1.append(1);
		l1.append(4);
		l1.retrieve();
		
		LinkedList l2 =  new LinkedList();
		l2.append(6);
		l2.append(4);
		l2.append(3);
		l2.retrieve();
		
		Node node = sumLists(l1.header.next,l2.header.next,0);
		while(node.next!=null) {
			System.out.print(node.data+"->");
			node=node.next;
		}
		System.out.print(node.data);
	}
	
	public static void findKRunner(Node deleteNode) {
		/*
		int k =5 ;
		Node node = findKNodeLoop(head, k);

		Reference r = new Reference();
		node = findKNodeRecursive(head.header.next,k,r);
		node = findKNodePointer(head.header.next,k);
		System.out.println("### "+k +": " + node.data);
		*/
	}
	
	public static void deleteNodeRunner(Node deleteNode) {
		
		//단방향 링크드리스트에서 중간 노드 삭제 삭제할 노드만 암.
		deleteNode(deleteNode);
	}

	
	static class Reference{
		public int count=0;
	}
	
	//정렬 x, 버퍼공간 허락하지 않음 
	public static void duplicateDelete(LinkedList list) {
		
		LinkedList inode = list;
		Node node = inode.header;
		while (node.next!=null) {
			Node jnode = node;
			while(jnode.next!=null) {
				if (node.data==jnode.next.data) {
					jnode.next = jnode.next.next;
				}else {
					jnode = jnode.next;
				}
			}
			
			node = node.next;
		}
	}
	
	
	// 스페이스 허용 
	public static LinkedList duplicateDeleteUsingSpace(LinkedList list) {
		
		LinkedList inode = list;
		HashSet temp = new HashSet();
		Node node = inode.header.next;
		while (node.next!=null) {
			int data =node.data;
			if(temp.contains(data)) {
				inode.delete(data);
			}else {
				temp.add(data);
			}
			node = node.next;
		}
		
		return inode;
	}
	
	
	//뒤에서 부터 k번째 노드
	public static Node findKNodeLoop(LinkedList list, int k) {
		Node node= list.header.next;
		int total = 1;
		
		while(node.next!=null) {
			System.out.println("node : "+node.data);
			node = node.next;
			total++;
		}
		System.out.println("total count : "+total +", ");
		node = list.header.next;
		
		for (int i=0;i<total-k;i++) {
			node = node.next;
		}
		return node;
	}
	

	
	//뒤에서 부터 k번째 노드 재귀호출(이것)
	public static Node findKNodeRecursive(Node node, int k, Reference r) {
		
		if (node ==null) {
			return null;
		}
		
		Node returnNode = findKNodeRecursive(node.next,k,r);
		r.count++;
		if(r.count == k) {
			System.out.println(k + " , value: " + node.data);
			
			return node;
		} 
		
		return returnNode;
		
	}
	
	
	
	//포인터 이용
	public static Node findKNodePointer(Node node, int k){
		Node p1 = node;
		Node p2 = node;
		for (int i=0; i<k;i++) {
			if(p1==null) return null;
			p1 = p1.next;
		}
		
		while(p1!=null) {
			p1= p1.next;
			p2 = p2.next;
		}
		
		return p2;
	
	}
	
	//노드삭제
	public static Node deleteNode(Node deleteNode) {
		
		if(deleteNode == null || deleteNode.next == null) return null;
		
		Node current = deleteNode;
		Node temp = current.next;
		
		deleteNode.data = temp.data;
		deleteNode.next = temp.next;
		return null;
	}
	
	
	public static Node sumLists(Node l1, Node l2, int carry) {
		if (l1== null && l2 == null && carry ==0) {
			System.out.println("#zzzz### RRR end       ");
			return null;
		}
		
		Node result = new Node();
		int value = carry;
		
		if(l1!=null) {
			value +=l1.data;
		}
		
		if(l2!=null) {
			value +=l2.data;
		}
		result.data = value%10;
		

		if(l1 !=null || l2!=null) {
			Node next = sumLists(l1 ==null?null: l1.next,
					l2==null?null:l2.next,
							value>10?value/10:0);
			result.next = next;
		}
//		
//		Node print = result;
//		System.out.println("##### RRR       "+print.data);
//		while(print.next!=null) {
//			System.out.print(print.data+"->");
//			print=print.next;
//		}
//		System.out.println(print.data);
//		

		return result;
	}
	
	//하나 더 있음 
	
	
	public static void getIntersection() {
		LinkedList l1 =  new LinkedList();
		l1.append(9);
		l1.append(1);
		l1.append(2);
		l1.append(8);
		l1.append(7);
		l1.retrieve();
		
		LinkedList l2 =  new LinkedList();
		l2.append(6);
		l2.append(4);
		l2.append(3);
		l2.append(2);
		l2.append(8);
		l2.append(7);
		l2.retrieve();
		
		Node n = getIntersection(l1.header.next,l2.header.next);
		
		System.out.println("inter sectio is "+n.data);
	}
	
	private static int getListLength(Node n) {
		int i=0;
		while(n.next!=null) {
			i++;
			n=n.next;
		}
		return i+1;
	}
	
	//교차점 찾기 (음.... 방법생각해  보기)
	public static Node getIntersection(Node n1, Node n2) {
		Node result = null;
		
		int len1 = getListLength(n1);
		int len2 = getListLength(n2);
		
		System.out.println("l1 "+len1 +"l2:"+len2); 
		
		if(len1 > len2) {
			n1 = n1.get(len1-len2);
		}else if(len2>len1) {
			n2 = n2.get(len2-len1);
		}
		
		while(n1.next!=null) {
			if(n1.data==n2.data) {
				System.out.println("l1 "+n1.data +"l2:"+n2.data); 
				result = n1;
				break;
			}else {
				n1 = n1.next;
				n2 = n2.next;
			}
		}
		
		
		
		return result;
		
	}
}




	
		


