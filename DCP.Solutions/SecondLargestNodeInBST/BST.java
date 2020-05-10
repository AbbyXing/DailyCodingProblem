package SecondLargestNodeInBST;

public class BST {

	public TreeNode root;
	
	public BST(TreeNode r) {
		root = r;
	}
	
	public BST(int v) {
		root = new TreeNode(v);
	}
	
	public void insert(int[] v) {
		for(Integer i : v)
			root = insert(i, root);
	}
	
	private TreeNode insert(int v, TreeNode node) {
		if(node == null)
			return new TreeNode(v);
		if(Integer.compare(v, node.val) > 0) {
			node.right = insert(v, node.right);
		} else if (Integer.compare(v, node.val) < 0) {
			node.left = insert(v, node.left);
		}
		
		return node;
	}
}
