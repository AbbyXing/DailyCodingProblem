package TwoTreenodesSumToK;

import java.util.ArrayList;

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
	
	public static Node[] twoNodesSumToK(Node root, int k) {
		Node[] result = new Node[2];
		
		ArrayList<Node> list = treeToList(root, new ArrayList<Node>());
		int start = 0, end = list.size() - 1;
		
		while(start < end) {
			if(list.get(start).val + list.get(end).val == k) {
				result[0] = list.get(start);
				result[1] = list.get(end);
				break;
			}
			else if(list.get(start).val + list.get(end).val > k)
				end--;
			else
				start++;
		}
		
		return result;
	}
	
	private static ArrayList<Node> treeToList(Node root, ArrayList<Node> list) {
		if(root == null)
			return list;
		
		treeToList(root.left, list);
		list.add(root);
		treeToList(root.right, list);
		
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(15);
		root.right.left = new Node(11);
		root.right.right = new Node(15);
		
		Node[] twoNode = twoNodesSumToK(root, 20);
		System.out.println(twoNode[0].val + " " + twoNode[1].val);
	}

}
