package CountUnivalTrees;

/*
 * Recursive
 * */

public class Solution {
	
	private int result;
	
	public Solution() {
		this.result = 0;
	}
	
	public int countUnivalTree(TreeNode root) {
		if(root == null)
			return 0;
		
		isUnival(root);
		
		return result;
	}
	
	public boolean isUnival(TreeNode root) {
		
		if(root.left == null && root.right == null) {
			this.result++;
			return true;
		}
		
		boolean isUni = true;
		if(root.left != null) {
			/* 
			 * Pay attention to the difference between '&' and '&&'!!!
			 * There we need to use '&' instead of '&&' to check all conditions thus traverse all child nodes
			 * */
			isUni = isUni & isUnival(root.left) & root.left.val == root.val;
		}
		if(root.right != null)
			isUni = isUni & isUnival(root.right) & root.right.val == root.val;
		
		if(isUni) {
			this.result++;
			return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(0);
		root.left = new TreeNode(1);
		root.right = new TreeNode(0);
		root.right.left = new TreeNode(1);
		root.right.right = new TreeNode(0);
		root.right.left.left = new TreeNode(1);
		root.right.left.right = new TreeNode(1);
		
		Solution solution = new Solution();

		System.out.println(solution.countUnivalTree(root));
	}

}
