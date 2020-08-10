package SumTwoLinkedList;

import java.util.LinkedList;

public class LinkedListInteger {
	
	public static LinkedList<Integer> sum(LinkedList<Integer> l1, LinkedList<Integer> l2) {
		int n1 = listToNum(l1), n2 = listToNum(l2);
		int sum = n1 + n2;
		
		return numToList(sum);
	}
	
	private static int listToNum(LinkedList<Integer> l) {
		int i = 1, num = 0;
		while(!l.isEmpty()) {
			num += i * l.poll();
			i *= 10;
		}
		
		return num;
	}
	
	private static LinkedList<Integer> numToList(int n) {
		LinkedList<Integer> l = new LinkedList<Integer>();
		while(n > 0) {
			l.add(n % 10);
			n /= 10;
		}
		
		return l;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		l1.add(9);
		l1.add(9);
		l2.add(5);
		l2.add(2);
		
		System.out.println(LinkedListInteger.sum(l1, l2)); // return 124 as 4->2->1
	}

}
