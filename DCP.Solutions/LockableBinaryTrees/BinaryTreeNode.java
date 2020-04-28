package LockableBinaryTrees;

public class BinaryTreeNode {
	
	/**
	 * 
	 * */
	
	private boolean _is_locked;
	public int val;
	public BinaryTreeNode left;
	public BinaryTreeNode right;
	public BinaryTreeNode parent; // need a pointer for parent
	// record the num of locked descendants of this node, so don't need to traverse the descendants when lock/unlock,
	// then the time for lock/unlock reduce reduce from O(m + h) to O(h), with m represent the number of descendants.
	public int num_lock_descendants; 
	
	public BinaryTreeNode(int v) {
		_is_locked = false;
		val = v;
		left = null;
		right = null;
		parent = null;
		num_lock_descendants = 0;
	}
	
	public void setLeft(BinaryTreeNode node) {
		this.left = node;
		node.parent = this;
	}
	
	public void setRight(BinaryTreeNode node) {
		this.right = node;
		node.parent = this;
	}
	
	// get status of the node
	public boolean is_locked() {
		return _is_locked;
	}
	
	public boolean lock() {
		if(can_lock_unlock()) {
			// if can be locked, set status to locked, traverse parents and add 1 count to their num_lock_descendants
			_is_locked = true;
			BinaryTreeNode current = this.parent;
			while(current != null) {
				current.num_lock_descendants ++;
				current = current.parent;
			}
			return true;
		}
		return false;
	}
	
	public boolean unlock() {
		if(can_lock_unlock()) {
			// if can be locked, set status to unlocked, traverse parents and reduce 1 count to their num_lock_descendants
			_is_locked = false;
			BinaryTreeNode current = this.parent;
			while(current != null) {
				current.num_lock_descendants --;
				current = current.parent;
			}
			return true;
		}
		return false;
	}
	
	// check if this node can be lock/unlock - whether has a parent or descendant with a locked status
	private boolean can_lock_unlock() {
		// if there's a locked descendant then return false
		if(this.num_lock_descendants > 0)
			return false;
		// traverse parents, if there's a locked parent then return false
		BinaryTreeNode current = this.parent;
		while(current != null) {
			if(current.is_locked())
				return false;
			current = current.parent;
		}
		return true;
	}
}
