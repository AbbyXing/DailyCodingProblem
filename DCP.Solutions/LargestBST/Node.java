package LargestBST;

public class Node {
	public int val;
	public Node left;
	public Node right;
	public boolean isBST;
	
	public Node(int v) {
		val = v;
		left = null;
		right = null;
		isBST = false;
	}
}
