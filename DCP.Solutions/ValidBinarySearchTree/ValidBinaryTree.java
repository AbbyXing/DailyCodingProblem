package ValidBinarySearchTree;

/**
 * Recursive, Binary Tree Traversal
 * 
 * */

public class ValidBinaryTree {
	
	public boolean checkValidity(Node root) {
		
		if(root == null)
			return true;
		
		boolean valid = true;
		if((root.left != null && root.left.val > root.val) || 
		(root.right != null && root.right.val < root.val))
			valid = false;
		
		return checkValidity(root.left) && checkValidity(root.right) && valid;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(8);
		root.left = new Node(3);
		root.right = new Node(10);
		root.left.left = new Node(1);
		root.left.right = new Node(6);
		root.right.right = new Node(14);
		
		ValidBinaryTree solution = new ValidBinaryTree();
		System.out.println(solution.checkValidity(root));
		
		root.right.right.val = 9;
		System.out.println(solution.checkValidity(root));
	}

}
