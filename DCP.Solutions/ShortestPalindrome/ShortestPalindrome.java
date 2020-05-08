package ShortestPalindrome;

import javax.print.attribute.standard.PrinterLocation;

/**
 * Dynamic Programming
 * 
 * dp(s[a...b]) = 
 * 	dp(s[a+1...b-1]), if s[a]=s[b]
 * 	min(dp(s[a+1...b]), dp(s[a...b-1])), if s[a]!=s[b]
 * 
 * 	if dp(s[a+1...b])=dp(s[a...b-1]): compare them lexicographically
 * 
 * Start by comparing the first and last letters of the current substring
 * */

public class ShortestPalindrome {
	
	public ShortestPalindrome() {}
	
	public String GetShortestPalindrome(String s) {
		if(s == null)
			return null;
		char[] str = s.toCharArray();
		int n = str.length;
		String[][] dp = new String[n][n];
		// base case
		for(int i = 0; i < n; i++) {
			// from a to a -> dp = s[a]
			dp[i][i] = Character.toString(str[i]);
		}
		for(int gap = 1; gap < n; gap++) {
			for(int i = 0; i < n - 1; i++) {
				int j = i + gap;
				if(j > n-1)
					break;
				// s[a] = s[b]
				if(str[i] == str[j]) {
					if(j - i == 1)
						dp[i][j] = "" + str[i] + str[j];
					else
						dp[i][j] = str[i] + dp[i + 1][j - 1] + str[j];
				} else { // s[a] != s[b]
					if(dp[i + 1][j].length() < dp[i][j - 1].length())
						dp[i][j] = str[i] + dp[i + 1][j] + str[i];
					else if(dp[i + 1][j].length() > dp[i][j - 1].length())
						dp[i][j] = str[j] + dp[i][j - 1] + str[j];
					else { // dp(s[a+1...b])=dp(s[a...b-1])
						if(str[i] < str[j])
							dp[i][j] = str[i] + dp[i + 1][j] + str[i];
						else
							dp[i][j] = str[j] + dp[i][j - 1] + str[j];
					}
				}
				//System.out.println(dp[i][j]);
			}
		}
		
		return dp[0][n-1];
	}

	public static void main(String[] args) {
		String s1 = "google", s2 = "race";
		ShortestPalindrome solution = new ShortestPalindrome();
		System.out.println(solution.GetShortestPalindrome(s1));
		System.out.println(solution.GetShortestPalindrome(s2));
	}

}
