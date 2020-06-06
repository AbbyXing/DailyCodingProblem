package KnightsTour;

/**
 * Backtracking
 * 
 * Note: knight's move could be {(2, 1),
						        (1, 2),
						        (1, -2),
						        (-2, 1),
						        (-1, 2),
						        (2, -1),
						        (-1, -2),
						        (-2, -1)};
						        
int[][] visited records the step number of each grid.
 * */

public class KnightsTour {
	
	private int N;
	
	// knight's legal moves
	private int[][] direction = {{2, 1},
							{1, 2},
							{1, -2},
							{-2, 1},
							{-1, 2},
							{2, -1},
							{-1, -2},
							{-2, -1}};
	
	public KnightsTour(int n) {
		N = n;
	}
	
	// main function
	public int GetTourNumber() {
		int count = 0;
		
		// calculate solution number at each grid
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++)
				count += TourHelper(new int[N][N], i, j, 1);
		}
		
		return count;
	}
	
	// backtrack function
	private int TourHelper(int[][] visited, int r, int c, int step) {
		int count = 0;
		
		visited[r][c] = step;
		
		// if visited all grid, return 1 (found a solution)
		if(step == N * N) {
			// backtrack a step to find another solution
			visited[r][c] = 0;
			return 1;
		}
		
		// try all directions to see if one can lead to a solution
		for(int[] direct : direction) {
			int newR = r + direct[0];
			int newC = c + direct[1];
			if(isValid(newR, newC) && visited[newR][newC] == 0) {
				count += TourHelper(visited, newR, newC, step + 1);
			}
		}
		
		// can't found any solution, backtrack a step
		visited[r][c] = 0;
		
		return count;
	}
	
	// check if the coordinate is valid
	private boolean isValid(int r, int c) {
		if(r < 0 || r >= N || c < 0 || c >= N)
			return false;
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		KnightsTour knightsTour = new KnightsTour(5);
		System.out.println(knightsTour.GetTourNumber()); // 1728
	}

}
