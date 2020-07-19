package SingleLinkedPalindrome;

import java.util.Stack;

/**
 * Stack, Linked List
 * 
 * */

public class Solution {
	
	public boolean palindrome(Node list) {
		Stack<Integer> stack = new Stack<Integer>();
		Node node = list;
		while(node != null) {
			stack.push(node.val);
			node = node.next;
		}
		node = list;
		while(node != null) {
			if(node.val != stack.pop())
				return false;
			node = node.next;
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node list = new Node(1);
		list.next = new Node(4);
		list.next.next = new Node(3);
		list.next.next.next = new Node(4);
		list.next.next.next.next = new Node(1);
		
		Solution solution = new Solution();
		System.out.println(solution.palindrome(list));
	}

}
