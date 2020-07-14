package FindWordInGrid;

/**
 * Backtracking
 * 
 * */

public class FindWordInGrid {
	
	private int[][] directions = {{1,0},{0,1},{-1,0},{0,-1},{1,1},{-1,-1},{1,-1},{-1,1}};
	
	public boolean exist(char[][] board, String word) {
		char[] c = word.toCharArray();
		int M = board.length;
		int N = board[0].length;
		boolean[][] used = new boolean[M][N];
		for(int i = 0; i < M; i++) {
			for(int j = 0; j < N; j++) {
				if(board[i][j] == c[0])
					if(haveNeighbor(board, i, j, used, word, 1))
						return true;
			}
		}
		
		return false;
	}
	
	private boolean haveNeighbor(char[][] board, int r, int c, boolean[][] used, String word, int index) {
		if(index >= word.length())
			return true;
		
		int M = board.length;
		int N = board[0].length;
		used[r][c] = true;
		
		for(int[] direct : directions) {
			int i = r + direct[0];
			int j = c + direct[1];
			if(valid(M, N, i, j, used) && board[i][j] == word.charAt(index)) {
				if(haveNeighbor(board, i, j, used, word, index + 1))
					return true;
			}
		}
		used[r][c] = false;
		return false;
	}
	
	private boolean valid(int M, int N, int i, int j, boolean[][] used) {
		if(i >= 0 && i < M && j >= 0 && j < N && !used[i][j])
			return true;
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] board = {{'A','B','C','E'},
						  {'S','F','C','S'},
						  {'A','D','E','E'}};
		FindWordInGrid grid = new FindWordInGrid();
		
		String word = "SEE";
		System.out.println(grid.exist(board, word));
		word = "ABCCED";
		System.out.println(grid.exist(board, word));
		word = "ABCB";
		System.out.println(grid.exist(board, word));
	}

}
