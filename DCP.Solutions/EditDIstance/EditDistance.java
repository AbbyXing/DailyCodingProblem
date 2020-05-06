package EditDIstance;

/**
 * Dynamic Programming
 * 
 * if s1[i] == s2[j]: dp[i][j] = dp[i-1][j-1]
 * 
 * if s1[i] != s2[j]: dp[i][j] = min(dp[i-1][j-1], dp[i][j-1], dp[i-1][j]) + 1
 * */

public class EditDistance {
	
	public EditDistance() {}
	
	public int GetDistance(String s1, String s2) {
		int m = s1.length(), n = s2.length();
		int[][] dp = new int [m + 1][n + 1];
		dp[0][0] = 0;
		for(int i = 1; i <= m; i++) {
			dp[i][0] = i;
		}
		for(int j = 1; j <= n; j++) {
			dp[0][j] = j;
		}
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(s1.charAt(i - 1) == s2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1];
				else
					dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		String s1 = "sunday", s2 = "saturday";
		EditDistance solution = new EditDistance();
		System.out.println(solution.GetDistance(s1, s2));
	}

}
