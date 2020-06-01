package FileSyncing;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Merkle tree & Hashing
 * 
 * */

public class FileSyncing {
	
	private FileNode root;
	
	// initialize the merkle tree
	public FileSyncing(Queue<FileNode> files) throws Exception {
		
		while(files.size() > 1) {
			int i = 0;
			int n = files.size();
			// process all file nodes at the same tree level
			while(i < n) {
				FileNode left = files.poll();
				i++;
				
				FileNode right = null;
				if(i < n) {
					right = files.poll();
					i++;
				}
				
				// hashing
				try {
					MessageDigest md = MessageDigest.getInstance("MD5");
					md.update((left.data + (right == null? "" : right.data)).getBytes());
					// parent
					FileNode parent = new FileNode(new BigInteger(1, md.digest()).toString(16));
					parent.left = left;
					parent.right = right;
					files.offer(parent); // add parent node to the files queue
				} catch (Exception e) {
					throw new Exception(e.toString());
				}
			}
		}
		root = files.poll(); // the last node will be the root
	}
	
	public boolean HasDiff(FileNode refRoot, FileNode changeRoot) {
		// both are null
		if(refRoot == null && changeRoot == null)
			return false;
		
		// one is null
		if(refRoot == null || changeRoot == null) {
			System.out.println("Difference detected, update root: " + changeRoot.data);
			return true;
		}
		
		// both are not null but data are different
		if(refRoot.data != changeRoot.data) {
			System.out.println("Difference detected, update root: " + changeRoot.data);
			return true;
		}
		
		// recursively detect difference
		boolean leftDiff = HasDiff(refRoot.left, changeRoot.left);
		boolean rightDiff = HasDiff(refRoot.right, changeRoot.right);
		
		return leftDiff || rightDiff;
	}
	
	public FileNode Merge(FileNode refNode, FileNode changeNode) {
		// base cases:
		if(refNode == null && changeNode == null)
			return null;
		// delete
		if(refNode == null && changeNode != null) {
			System.out.println("Change detected, data deleted: " + changeNode.data);
			return null;
		}
		// add
		if(refNode != null && changeNode == null) {
			 System.out.println("Change detected, data added: " + refNode.data);
			return new FileNode(refNode.data);
		}
		// update
		if(refNode.data != changeNode.data) {
			changeNode.data = refNode.data;
		}
		// recursively update the tree
		changeNode.left = Merge(refNode.left, changeNode.left);
		changeNode.right = Merge(refNode.right, changeNode.right);
		
		return changeNode;
	}

	public static void main(String[] args) throws Exception {
		Queue<FileNode> q = new LinkedList<>();
        q.add(new FileNode("A"));
        q.add(new FileNode("B"));
        q.add(new FileNode("C"));
        q.add(new FileNode("D"));
        q.add(new FileNode("E"));
        FileSyncing mt = new FileSyncing(q);
        System.out.println("Root Hash of current data: " + mt.root.data);

        Queue<FileNode> q2 = new LinkedList<>();
        q2.add(new FileNode("AA"));
        q2.add(new FileNode("B"));
        q2.add(new FileNode("C"));
        q2.add(new FileNode("D"));
        q2.add(new FileNode("E"));
        FileSyncing mt2 = new FileSyncing(q2);
        System.out.println("Root Hash of updated data: " + mt2.root.data);

        if(mt.HasDiff(mt.root, mt2.root)) {
            mt.root = mt.Merge(mt.root, mt2.root);
        }
	}

}
