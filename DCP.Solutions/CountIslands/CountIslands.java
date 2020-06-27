package CountIslands;

/**
 * Recursive DFS (traverse each neighbor cell)
 * */

public class CountIslands {
	
	private int[][] board;
	private int M, N;
	
	public CountIslands(int[][] a) {
		board = a;
		if(a != null)
			M = a.length;
		if(M != 0)
			N = a[0].length;
	}
	
	// main function
	public int islandsNum() {
		if(board == null || M == 0)
			return 0;
		
		boolean[][] visited = new boolean[M][N];
		int count = 0;
		
		for(int r = 0; r < M; r++) {
			for(int c = 0; c < N; c++) {
				// if this cell could be a part of one island, start DFS here
				if(valid(r, c, visited)) {
					DFS(r, c, visited);
					// after DFS returned, means one island has been fully traversed
					count++;
					// remind that if all cells are 1, then the total island number will be 1
				}
			}
		}
		
		return count;
	}
	
	// recursive DFS (traverse all cell on one island)
	private void DFS(int r, int c, boolean[][] visited) {
		visited[r][c] = true;
		
		int[] directs = {-1, 0, 1};
		for(int i : directs) {
			for(int j : directs) {
				if(!(i == 0 && j == 0) && valid(r + i, c + j, visited))
					DFS(r + i, c + j, visited);
			}
		}
		
		// there is no more cell can be included in this island, return the function
		return;
	}
	
	// check valid
	private boolean valid(int r, int c, boolean[][] visited) {
		// check if it's on the board
		if(r >= 0 && r < M && c >= 0 && c < N) {
			// check if it's not visited and it has value 1
			if(!visited[r][c] && board[r][c] == 1)
				return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {{1, 0, 0, 0, 0},
					{0, 0, 1, 1, 0},
					{0, 1, 1, 0, 0},
					{0, 0, 0, 0, 0},
					{1, 1, 0, 0, 1},
					{1, 1, 0, 0, 1}};
		CountIslands solution = new CountIslands(a);
		System.out.println(solution.islandsNum());
	}

}
