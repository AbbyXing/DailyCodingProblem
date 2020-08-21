package LargestRectangle;

/**
 * Recursive
 * 
 * */

public class Solution {
	
	private static int[][] directs = {{0,1},{1,0},{0,-1},{-1,0}};
	
	public static int largestRectangle(int[][] matrix) {
		
		if(matrix == null || matrix.length == 0)
			return 0;
		
		int m = matrix.length, n = matrix[0].length;
		boolean[][] checked = new boolean[m][n];
		
		int max = 0;
		
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(matrix[i][j] == 1 && !checked[i][j]) {
					checked[i][j] = true;
					int rectangle = rectangle(matrix, checked, i, j, 1);
					max = Math.max(max, rectangle);
				}
			}
		}
		
		return max;
	}
	
	private static int rectangle(int[][] matrix, boolean[][] checked, int r, int c, int sum) {
		for(int[] direct : directs) {
			int i = direct[0], j = direct[1];
			if(valid(matrix, r + i, c + j) && matrix[r + i][c + j] == 1 && !checked[r + i][c + j]) {
				checked[r + i][c + j] = true;
				return rectangle(matrix, checked, r + i, c + j, sum + 1);
			}
		}
		
		return sum;
	}
	
	private static boolean valid(int[][] matrix, int r, int c) {
		int m = matrix.length, n = matrix[0].length;
		if(r >= 0 && r < m && c >= 0 && c < n)
			return true;
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{1,0,0,0},
						  {1,0,1,1},
						  {1,0,1,1},
						  {0,1,0,0}};
		
		System.out.println(Solution.largestRectangle(matrix)); // 4
	}

}
