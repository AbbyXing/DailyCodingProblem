package BinaryTreeSerializeDeserialize;

import java.util.Arrays;
import java.util.LinkedList;

import BinaryTreeSerializeDeserialize.Node;;

public class Solution {
	
	private static String empty_marker = "none";
	
	public Solution() {}
	
	public static String serialize(Node node) {
		
		if(node == null) {
			return empty_marker + ",";
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(node.val + ",");
		stringBuilder.append(serialize(node.left));
		stringBuilder.append(serialize(node.right));
		
		return stringBuilder.toString();
	}
	
	public static Node deserialize(String data) {
		
		String[] data_array = data.split(",");
		LinkedList<String> data_list = new LinkedList<>(Arrays.asList(data_array));
		
		return recursive_deserialize(data_list);
	}
	
	private static Node recursive_deserialize(LinkedList<String> data_list) {
		
		if(data_list.get(0).equals("none")) {
			data_list.remove(0);
			return null;
		}
		
		Node node = new Node(data_list.get(0));
		data_list.remove(0);
		node.left = recursive_deserialize(data_list);
		node.right = recursive_deserialize(data_list);
		
		return node;
	}

	public static void main(String[] args) {
		Node node = new Node("root", new Node("left", new Node("left.left")), new Node("right"));
		System.out.println(deserialize(serialize(node)).left.left.val.equals("left.left"));
	}

}
