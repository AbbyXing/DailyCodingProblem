package MinSumInTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Binary Tree, Breadth First Search
 * 
 * */

public class BinaryTree {
	
	public static class Node {
		public int val;
		public Node left;
		public Node right;
		
		public Node(int v) {
			val = v;
			left = right = null;
		}
	}
	
	public static int minLevel(Node root) {
		// special case
		if(root == null)
			return -1;
		
		int minLevel = 0;
		int minSum = Integer.MAX_VALUE;
		
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		int level = 0;
		while(!queue.isEmpty()) {
			// count the size of this level
			int count = queue.size();
			
			// calculate sum for current level
			int sum = 0;
			while(count > 0) {
				Node node = queue.poll();
				sum += node.val;
				if(node.left != null)
					queue.add(node.left);
				if(node.right != null)
					queue.add(node.right);
				
				count--;
			}
			
			// replace the minimum sum if possible
			if(sum < minSum) {
				minSum = sum;
				minLevel = level;
			}
			
			// next level
			level++;
		}
		
		return minLevel;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*   Constructed Binary tree is: 
				        50 
				      /   \ 
				    20      3 
				  /  \      \ 
				 4    5      8 
				           /   \ 
				          6     7    */
		
		Node root = new Node(50); 
	    root.left = new Node(20); 
	    root.right = new Node(3); 
	    root.left.left = new Node(4); 
	    root.left.right = new Node(5); 
	    root.right.right = new Node(8); 
	    root.right.right.left = new Node(6); 
	    root.right.right.right = new Node(7);
	    
	    System.out.println(BinaryTree.minLevel(root)); // level 3
	}

}
