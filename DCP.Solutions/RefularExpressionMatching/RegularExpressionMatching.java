package RefularExpressionMatching;

/**
 * Dynamic Programming
 * 
 * dp[i][j]: represents if the 1st i characters in s can match the 1st j characters in p
 * 
 * 1. s[i] == p[j] -> dp[i][j] = dp[i-1][j-1] (same character)
 * 2. p[j] == '.' -> dp[i][j] = dp[i-1][j-1] (. can be any single character)
 * 3. p[j] == '*' ->
 * 	(1). s[i-1] != p[j] -> dp[i][j] = dp[i][j-2] (zero of preceding char)
 * 	(2). s[i-1] == p[j] || p[j-1] = '.' -> 
 * 		<1>. dp[i][j] = dp[i][j-2] (zero if preceding char)
 * 		<2>. dp[i][j] = dp[i][j-1] (single preceding char)
 * 		<3>. dp[i][j] = dp[i-1][j] (multiple of preceding char)
 * */

public class RegularExpressionMatching {
	
	public RegularExpressionMatching() {}
	
	 public boolean isMatch(String s, String p) {
		 int m = s.length(), n = p.length();
		 // Initiate dp[][]
		 boolean[][] dp = new boolean[m + 1][n + 1];
		 // base case
		 dp[0][0] = true;
		 for(int j = 2; j <= n; j += 2) {
			 if(p.charAt(j - 1) == '*' && dp[0][j - 2]) {
				 dp[0][j] = true;
			 }
		 }
		 // begin
		 for(int i = 1; i <= m; i++) {
			 for(int j = 1; j <= n; j++) {
				 if(p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1)) {
					 dp[i][j] = dp[i - 1][j - 1];
				 } else if(p.charAt(j - 1) == '*') {
					 if(s.charAt(i - 1) != p.charAt(j - 2) && p.charAt(j - 2) != '.') {
						 dp[i][j] = dp[i][j - 2];
					 } else {
						 dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2];
					 }
				 }
			 }
		 }
		 
		 return dp[m][n];
	 }

	public static void main(String[] args) {
		RegularExpressionMatching solution = new RegularExpressionMatching();
		System.out.println(solution.isMatch("ray", "ra."));
		System.out.println(solution.isMatch("raymoond", "ra."));
		System.out.println(solution.isMatch("chat", ".*at"));
		System.out.println(solution.isMatch("chats", ".*at"));
	}

}
