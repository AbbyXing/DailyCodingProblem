package ArithmeticBinaryTree;

/**
 * Binary Tree Traversal: pre-order traversal
 * */

public class ArithmeticBinaryTree {
	
	public double GetResult(TreeNode node) {
		if(node == null)
			return (Double) null;
		if(node.val == '+')
			return GetResult(node.left) + GetResult(node.right);
		else if(node.val == '-')
			return GetResult(node.left) - GetResult(node.right);
		else if(node.val == '*')
			return GetResult(node.left) * GetResult(node.right);
		else if(node.val == '/')
			return GetResult(node.left) / GetResult(node.right);
		else // numeric
			return Double.valueOf(Character.toString(node.val));
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode('*');
		root.left = new TreeNode('+');
		root.right = new TreeNode('+');
		root.left.left = new TreeNode('3');
		root.left.right = new TreeNode('2');
		root.right.left = new TreeNode('4');
		root.right.right = new TreeNode('5');
		
		ArithmeticBinaryTree solution = new ArithmeticBinaryTree();
		System.out.println(solution.GetResult(root));
	}

}
