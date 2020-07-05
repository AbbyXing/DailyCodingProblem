package LargestBST;

/**
 * Binary Tree Traversal, Recursive
 * 
 * */

public class LargestBST {
	
	public int sizeOfLargestBST(Node root) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null) {
			root.isBST = true;
			return 1;
		}
		int l = sizeOfLargestBST(root.left);
		int r = sizeOfLargestBST(root.right);
		
		if(root.val > root.left.val && root.val <= root.right.val && root.left.isBST
				&& root.right.isBST) {
			root.isBST = true;
			return 1 + l + r;
		}
		else
			return Math.max(l, r);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 *    5
		    /  \
		   2    4
		 /  \
		1    3
		 * */
		Node root = new Node(5);
		root.left = new Node(2);
		root.right = new Node(4);
		root.left.left = new Node(1);
		root.left.right = new Node(3);
		LargestBST largestBST = new LargestBST();
		System.out.println(largestBST.sizeOfLargestBST(root));
	}

}
