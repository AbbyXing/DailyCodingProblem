package LockableBinaryTrees;

/**
 * Explanation in BinaryTreeNode class
 * 
 * */

public class LockableBinaryTrees {

	public static void main(String[] args) {
		BinaryTreeNode a = new BinaryTreeNode(1);
		BinaryTreeNode b = new BinaryTreeNode(2);
		BinaryTreeNode c = new BinaryTreeNode(3);
		BinaryTreeNode d = new BinaryTreeNode(4);
		BinaryTreeNode e = new BinaryTreeNode(5);
		BinaryTreeNode f = new BinaryTreeNode(6);
		BinaryTreeNode g = new BinaryTreeNode(7);
		a.setLeft(b);
		a.setRight(c);
		b.setLeft(d);
		b.setRight(e);
		c.setLeft(f);
		c.setRight(g);
		
		e.lock();
		System.out.println(b.lock());
		System.out.println(c.lock());
	}

}
