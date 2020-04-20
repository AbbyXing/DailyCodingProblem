package LongestAbsolutePath;

/**
 * 1. Split the original path string with "\n", store each folder/file's string into an dirs array
 * 
 * 2. Loop the dirs array, for each folder/file:
 * 	1) Count the number of tabs it has
 * 	2) Record it's absolute path length
 * 	3) If it's a file, compare it's absolute path length with the previous maximum length
 * 
 * Note: '\n' is a single “special” character, so as '\t'. FYI: https://javascript.info/string#special-characters
 * */

public class FileSystem {
	
	private int result;
	private String[] dirs;
	int[] lengthOfLevels;
	
	public FileSystem(String path) {
		this.result = 0;
		this.dirs = path.split("\n"); // Split the original path string
		this.lengthOfLevels = new int[dirs.length + 1];
	}
	
	public int LengthOfLongestPath() {
		if(this.dirs == null || this.dirs.length == 0) // If the path is empty
			return 0;
		for(String s: dirs) {
			int numOfTabs = s.lastIndexOf("\t") + 1; // The number of tabs
			int level = numOfTabs + 1; // In which path level
			lengthOfLevels[level] = lengthOfLevels[level - 1] + s.length() - numOfTabs + 1; // Plus 1 for appending a '/'
			if(s.contains(".")) // If find a file, then compare with the current result
				this.result = Math.max(this.result, lengthOfLevels[level] - 1); // Minus 1 for deleting the '/' after file name
		}
		return this.result;
	}

	public static void main(String[] args) {
		String path = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
		FileSystem fileSystem = new FileSystem(path);
		System.out.println(fileSystem.LengthOfLongestPath());
	}

}
