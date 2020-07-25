package AllPathsInBinaryTree;

/**
 * Recursive
 * 
 * */

public class Node {
	
	public int val;
	public Node left;
	public Node right;
	
	public Node(int v) {
		val = v;
		left = null;
		right = null;
	}
	
	// print all paths from root to leaf
	public void printAllPaths(Node root, String s) {
		
		s += String.valueOf(root.val) + " ";
		
		if(root.left == null || root.right == null) {
			System.out.println(s);
			if(root.left == null && root.right == null)
				return;
		}
		if(root.left != null)
			printAllPaths(root.left, s);
		if(root.right != null)
			printAllPaths(root.right, s);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.left = new Node(4);
		root.right.right = new Node(5);
		root.printAllPaths(root, "");
	}

}
