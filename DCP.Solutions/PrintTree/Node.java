package PrintTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Breadth First Search
 * 
 * */

public class Node {
	
	public int val;
	public Node left;
	public Node right;
	
	public Node(int v) {
		val = v;
		left = null;
		right = null;
	}
	
	public void printTree(Node root) {
		if(root == null)
			return;
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		while(!queue.isEmpty()) {
			Node temp = queue.poll();
			System.out.print(temp.val + " ");
			if(temp.left != null)
				queue.offer(temp.left);
			if(temp.right != null)
				queue.offer(temp.right);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new  Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.left.right = new Node(5);
		root.right.left = new Node(6);
		root.right.right = new Node(7);
		root.printTree(root);
	}

}
