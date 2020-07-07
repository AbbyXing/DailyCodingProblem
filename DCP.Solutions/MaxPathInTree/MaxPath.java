package MaxPathInTree;

/**
 * Binary Tree Traversal, Recursive
 * 
 * */

public class MaxPath {
	
	private int max = 0;
	
	public int getMaxPath(Node root) {
		if(root == null)
			return 0;
		
		int lmax = getMaxPath(root.left);
		int rmax = getMaxPath(root.right);
		int currentMax = 0;
		
		if(lmax < 0 && rmax < 0)
			// only this node
			currentMax = root.val;
		else
			// pass through root node (this node)
			currentMax = Math.max(lmax + rmax + root.val, Math.max(lmax, rmax) + root.val);
		
		if(currentMax > max)
			max = currentMax;
		
		// can only return the left side or the right side
		return Math.max(root.val, Math.max(lmax, rmax) + root.val);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(-5);
        root.left = new Node(1);
        root.right = new Node(4);
        root.left.left = new Node(-6);
        root.left.right = new Node(5);
        root.left.right.left = new Node(-2);
        root.left.right.right = new Node(3);
        root.left.left.left = new Node(9);
        root.left.left.right = new Node(10);
        root.right.left = new Node(11);
        root.right.right = new Node(-2);
        root.right.right.right = new Node(-8);
        root.right.right.left = new Node(7);
        root.right.right.right.left = new Node(1);
        root.right.right.right.right = new Node(7);
        root.right.right.right.right.left = new Node(12);
        
        MaxPath maxPath = new MaxPath();
        maxPath.getMaxPath(root);
        System.out.println(maxPath.max); // result should be 24
	}

}
