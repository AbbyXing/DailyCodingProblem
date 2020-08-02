package FindSameSubtree;

/**
 * Binary Tree Traversal, Recursive
 * 
 * */

public class Solution {
	
	public static class Node {
		public int val;
		public Node left;
		public Node right;
		
		public Node(int v) {
			val = v;
			left = right = null;
		}
	}
	
	public static boolean sameSubtree(Node s, Node t) {
		if(s == null)
			return false;
		if(s.val == t.val) {
			if(same(s, t))
				return true;
		}
		return sameSubtree(s.left, t) || sameSubtree(s.right, t);
	}
	
	private static boolean same(Node n, Node t) {
		if(n == null && t== null)
			return true;
		
		if(n.val != t.val)
			return false;
		
		return same(n.left, t.left) && same(n.right, t.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node s = new Node(0);
		s.left = new Node(1);
		s.left.left = new Node(2);
		s.left.right = new Node(3);
		s.right = new Node(5);
		
		Node t = new Node(1);
		t.left = new Node(2);
		t.right = new Node(3);
		
		System.out.println(Solution.sameSubtree(s, t));
	}

}
