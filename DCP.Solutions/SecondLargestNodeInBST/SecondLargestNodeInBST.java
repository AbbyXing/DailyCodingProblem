package SecondLargestNodeInBST;

public class SecondLargestNodeInBST {
	
	public int ReturnSecondLargest(BST bst) {
		
		TreeNode node1 = bst.root;
		TreeNode node2 = bst.root;
		
		// reach the very right of the tree
		while(node2.right != null) {
			node1 = node2;
			node2 = node2.right;
		}
		
		// if node2 has no left child, return node1
		if(node2.left == null)
			return node1.val;
		
		// if node2 has left child, move the its left child and keep going right until there's no right child
		node2 = node2.left;
		while(node2.right != null) {
			node2 = node2.right;
		}
		
		return node2.val;
	}

	public static void main(String[] args) {
		int[] v = {5, 20, 1, 8, 15, 30, 14, 19, 25, 28, 26, 27};
		BST bst = new BST(10);
		bst.insert(v);
		SecondLargestNodeInBST solution = new SecondLargestNodeInBST();
		System.out.println(solution.ReturnSecondLargest(bst));
	}

}
