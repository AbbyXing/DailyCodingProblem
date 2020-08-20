package InorderSuccessor;

public class BinarySearchTree {
	
	public static class Node {
		public int val;
		public Node left;
		public Node right;
		public Node parent;
		
		public Node(int v) {
			val = v;
			left = right = null;
		}
	}
	
	public static int inOrderSuccessor(Node n) {
		
		int parent = n.parent.val;
		int child = parent;
		
		while(n.left != null) {
			child = n.left.val;
			n = n.left;
		}
		
		return Math.min(parent, child);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
