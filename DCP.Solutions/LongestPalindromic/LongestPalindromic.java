package LongestPalindromic;

/**
 * Dynamic Programming
 * 
 * dp[i][j] represents dp(s[i, ... , j]): dp value of substring of s from index i to index j
 * 
 * for each gap from 1 to n - 1
 * 	for each i from 0 to n - 1
 * 		j = i + gap
 * 
 * 		if s[i] = s[j] and s[i + 1, ... , j - 1] is palindromic,
 * 		then dp[i][j] = s[i] + dp[i + 1][j - 1] + s[j]
 * 
 * 		else,
 * 		dp[i][j] = maxlength(dp[i + 1][j], dp[i][j - 1])
 * 
 * return dp[0][n - 1]
 * */

public class LongestPalindromic {
	
	public String GetResult(String s) {
		if(s == null)
			return null;
		
		char[] str = s.toCharArray();
		int n = str.length;
		String[][] dp = new String[n][n];
		
		// base cases:
		for(int i = 0; i < n; i++) {
			// from a to a -> dp = s[a]
			dp[i][i] = Character.toString(str[i]);
		}
		
		for(int gap = 1; gap < n; gap++) {
			for(int i = 0; i < n - 1; i++) {
				int j = i + gap;
				if(j > n - 1)
					break;
				if(str[i] == str[j]) {
					if(j - i == 1)
						dp[i][j] = "" + str[i] + str[j];
					else if(dp[i + 1][j - 1].equals(s.substring(i + 1, j)))
						dp[i][j] = str[i] + dp[i + 1][j - 1] + str[j];
				}
				else {
					if(dp[i + 1][j].length() > dp[i][j - 1].length())
						dp[i][j] = dp[i + 1][j];
					else
						dp[i][j] = dp[i][j - 1];
				}
			}
		}
		
		return dp[0][n - 1];
	}

	public static void main(String[] args) {
		LongestPalindromic solution = new LongestPalindromic();
		System.out.println(solution.GetResult("aabcdcb"));
		System.out.println(solution.GetResult("bananas"));
	}

}
