package InvertBinaryTree;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * Serialize and Deserialze
 * 
 * 1. serialize the tree (node -> left -> right)
 * 
 * 2. deserialize (node -> right -> left)
 * */

public class InvertBinaryTree {
	
	private String emptyMarker = "none";
	
	public Node invert(Node root) {
		String serial = serialize(root);
		
		return deserialize(serial);
	}
	
	private String serialize(Node root) {
		if(root == null) 
			return emptyMarker + ",";
		
		StringBuilder sBuilder = new StringBuilder();
		sBuilder.append(root.val + ",");
		sBuilder.append(serialize(root.left));
		sBuilder.append(serialize(root.right));
		
		return sBuilder.toString();
	}
	
	private Node deserialize(String s) {
		String[] split = s.split(",");
		LinkedList<String> data = new LinkedList<String>(Arrays.asList(split));
		
		return recursive_deserialize(data);
	}
	
	private Node recursive_deserialize(LinkedList<String> data) {
		if(data.get(0).equals("none")) {
			data.remove(0);
			return null;
		}
		Node node = new Node(data.get(0));
		data.remove(0);
		node.right = recursive_deserialize(data);
		node.left = recursive_deserialize(data);
		
		return node;
	}
	
	private void printTree(Node root) {
		if(root == null)
			return;
		System.out.print(root.val + " ");
		printTree(root.left);
		printTree(root.right);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InvertBinaryTree solution = new InvertBinaryTree();
		
		Node a = new Node("a");
		a.left = new Node("b");
		a.right = new Node("c");
		a.left.left = new Node("d");
		a.left.right = new Node("e");
		a.right.left = new Node("f");
		
		solution.printTree(a);
		
		System.out.println();
		
		Node b = solution.invert(a);
		solution.printTree(b);
	}

}
