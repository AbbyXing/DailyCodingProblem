package BinaryTreeSerializeDeserialize;


public class Node {

	public String val;
	public Node left;
	public Node right;
	
	public Node() {}
	
	public Node(String val) {
		this.val = val;
	}
	
	public Node(String val, Node left) {
		this.val = val;
		this.left = left;
	}
	
	public Node(String val, Node left, Node right) {
		this.val = val;
		this.left = left;
		this.right = right;
	}
}
