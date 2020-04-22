package MinHouseColoringCost;

/**
 * Dynamic Programming
 * 
 * dp[i][j] is to record minCost of painting house i using color j
 * 
 * dp[i][j] = min[sum(dp[i-1][m])], m!=last house'color
 * */

public class MinHouseColoringCost {
	
	private int K, N;
	private int[][] dp;
	
	public MinHouseColoringCost(int[][] c) {
		this.N = c.length;
		this.K = c[0].length;
		this.dp = c;
	}
	
	public int GetMinimumCost() throws Exception {
		if(K < 1 || N < 0 || (K == 1 && N > 1))
			throw new Exception("It's not sovable");
		if(N == 0)
			return 0;
		int lastMinCost = 0, lastColor = -1, lastScndMinCost = 0;
		for(int i = 0; i < N; i++) {
			int curMinCost = Integer.MAX_VALUE, curScndMinCost = Integer.MAX_VALUE, curColor = -1;
			for(int j = 0; j < K; j++) {
				// If j == last color, use the second minimum cost from last round
				dp[i][j] = dp[i][j] + (lastColor == j ? lastScndMinCost : lastMinCost);
				if(dp[i][j] < curMinCost) {
					curColor = j;
					curScndMinCost = curMinCost;
					curMinCost = dp[i][j];
				} else if(dp[i][j] < curScndMinCost)
					curScndMinCost = dp[i][j];
			}
			lastColor = curColor;
			lastMinCost = curMinCost;
			lastScndMinCost = curScndMinCost;
		}
		
		return lastMinCost;
	}

	public static void main(String[] args) throws Exception {
		int[][] cost = {{17,2,17}, {16,16,5}, {14,3,19}};
		MinHouseColoringCost solution = new MinHouseColoringCost(cost);
		System.out.println(solution.GetMinimumCost());
	}

}
