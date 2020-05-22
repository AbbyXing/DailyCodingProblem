package ReconstructTree;

/**
 * Binary Tree Traversal (pre-order, in-order)
 * 
 * Recursive
 * */

public class ReconstructTree {
	
	private int i = 0;
	
	public TreeNode ConstructTree(char[] preoder, char[] inorder, int start, int end) {
		
		// start > end means there is no node here
		if(start > end)
			return null;
		
		TreeNode node = new TreeNode(preoder[i]);
		i++;
		
		// start = end means this node has no child
		if(start == end)
			return node;
		
		int indexInInOder = FindIndexInPreOrder(inorder, preoder[i], start, end);
		// the left leaf must be located from (start) to (indexInInOder - 1) in the in-order array
		node.left = ConstructTree(preoder, inorder, start, indexInInOder - 1);
		// the left leaf must be located from (indexInInOder + 1) to (end) in the in-order array
		node.right = ConstructTree(preoder, inorder, indexInInOder + 1, end);
		
		return node;
	}
	
	// print the tree in pre-order
	private int FindIndexInPreOrder(char[] inorder, char v, int start, int end) {
		int index = start;
		for(int i = start; i <= end; i++) {
			if(inorder[i] == v)
				index = i;
		}
		
		return index;
	}
	
	public void PrintTreePreOrder(TreeNode root) {
		if(root == null)
			return;
		System.out.print(root.val + " ");
		PrintTreePreOrder(root.left);
		PrintTreePreOrder(root.right);
	}

	public static void main(String[] args) {
		char[] preoder = {'a', 'b', 'd', 'e', 'c', 'f', 'g'};
		char[] inorder = {'d', 'b', 'e', 'a', 'f', 'c', 'g'};
		ReconstructTree solution = new ReconstructTree();
		TreeNode root = solution.ConstructTree(preoder, inorder, 0, preoder.length - 1);
		solution.PrintTreePreOrder(root);
	}

}
