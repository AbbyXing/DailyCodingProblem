package MinPathSumOfTree;

public class Tree {
	
	public static class Node {
		public int val;
		public Node left;
		public Node right;
		
		public Node(int v) {
			val = v;
			left = right = null;
		}
	}
	
	public static int minPathSum(Node root, int sum) {
		if(root == null)
			return sum;
		
		sum += root.val;
		
		return Math.min(minPathSum(root.left, sum), minPathSum(root.right, sum));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(5);
		root.left.right = new Node(2);
		root.right.right = new Node(1);
		root.right.right.left = new Node(-1);
		
		System.out.println(Tree.minPathSum(root, 0)); // 15
	}

}
