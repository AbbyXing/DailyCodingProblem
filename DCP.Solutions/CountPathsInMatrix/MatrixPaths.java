package CountPathsInMatrix;

/**
 * Dynamic Programming
 * 
 * dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
 * */

public class MatrixPaths {
	
	public int CountPaths(int M, int N) {
		if(M <= 0 || N <= 0)
			return 0;
		int[][] dp = new int[M + 1][N + 1];
		
		// base cases:
		for(int i = 1; i <= M; i++)
			dp[i][1] = 1;
		for(int j = 1; j <= N; j++)
			dp[1][j] = 1;
		
		// dynamic programming
		for(int i = 2; i <= M; i++) {
			for(int j = 2; j <= N; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		
		return dp[M][N];
	}

	public static void main(String[] args) {
		MatrixPaths matrixPaths = new MatrixPaths();
		System.out.println(matrixPaths.CountPaths(2, 2));
		System.out.println(matrixPaths.CountPaths(5, 5));
	}

}
