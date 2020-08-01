package LCAOfTwoNodes;

/**
 * Recursive. Binary Tree Traversal
 * 
 * */

public class LCA {

	public static class Node {
		public int val;
		public Node left;
		public Node right;
		
		public Node(int v) {
			val = v;
			left = null;
			right = null;
		}
	}
	
	public static Node lca(Node current, int n1, int n2) {
		if(current == null)
			return null;
		
		if(current.val == n1 || current.val == n2)
			return current;
		
		Node left_found = lca(current.left, n1, n2);
		Node right_found = lca(current.right, n1, n2);
		
		if(left_found != null && right_found != null)
			return current;
		
		return left_found != null ? left_found : right_found;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1); 
        root.left = new Node(2); 
        root.right = new Node(3); 
        root.left.left = new Node(4); 
        root.left.right = new Node(5); 
        root.right.left = new Node(6); 
        root.right.right = new Node(7);
        System.out.println(LCA.lca(root, 4, 5).val); // 2
        System.out.println(LCA.lca(root, 4, 6).val); // 1
        System.out.println(LCA.lca(root, 3, 4).val); // 1
        System.out.println(LCA.lca(root, 2, 4).val); // 2
	}

}
