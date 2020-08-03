package GenerateBinaryTree;

/**
 * Binary Tree Traversal, Recursive
 * 
 * */

import java.util.Random;

public class BinaryTree {
	
	public static class Node {
		public int val;
		public Node left;
		public Node right;
		
		public Node(int v) {
			val = v;
			left = right = null;
		}
	}
	
	// generate a unbounded finite binary tree in O(1)
	public static Node generate() {
		Random rand = new Random();
		
		int v = rand.nextInt();
		Node root = new Node(v);
		
		if(rand.nextBoolean())
			root.left = generate();
		if(rand.nextBoolean())
			root.right = generate();
		
		return root;
	}
	
	public static void printTree(Node root) {
		if(root == null)
			return;
		System.out.print(root.val + " ");
		printTree(root.left);
		printTree(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = BinaryTree.generate();
		BinaryTree.printTree(root);
	}

}
