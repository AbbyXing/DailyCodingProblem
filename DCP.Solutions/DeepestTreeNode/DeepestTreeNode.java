package DeepestTreeNode;

public class DeepestTreeNode {
	
	public static class Node {
		public char val;
		public Node left;
		public Node right;
		
		public Node(char v) {
			val = v;
			left = null;
			right = null;
		}
	}
	
	private int maxLevel = -1;
	private Character deepestNodeVal = null;
	
	// main function
	public Character findDeepest(Node root) {
		find(root, 0);
		
		return deepestNodeVal;
	}
	
	// in-order traversal
	private void find(Node root, int level) {
		if(root != null) {
			// left
			find(root.left, ++level); // can't be level++ because needs to add before use
			// itself
			if(level > maxLevel) {
				deepestNodeVal = root.val;
				maxLevel = level;
			}
			// right
			find(root.right, level); // level has been already ++ so just use level
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node('a');
		root.left = new Node('b');
		root.right = new Node('c');
		root.left.left = new Node('d');
		
		DeepestTreeNode solution = new DeepestTreeNode();
		System.out.println(solution.findDeepest(root));
	}

}
