package FileSyncing;

public class FileNode {
	
	public String data;
	public FileNode left;
	public FileNode right;
	
	public FileNode(String d) {
		data = d;
		left = null;
		right = null;
	}
}
