package DecodeWays;

/*
 * Dynamic Programming
 * 
 * Note: pay attention to dp[0] and dp[1]*/

public class Solution {
	
	public Solution() {}
	
	public int decodedWays(String message) {
		
		if(message == null)
			return 0;
		
		int[] dp = new int[message.length() + 1];
		dp[0] = 1; // for dp[2] = 1 + 1 = 2, thus dp[0] = 1
		dp[1] = message.charAt(0) == '0' ? 0 : 1;
		for(int i = 2; i <= message.length(); i++) {
			int lastDigit = Integer.parseInt(message.substring(i - 1, i));
			if(lastDigit >= 1 && lastDigit <= 9)
				dp[i] += dp[i - 1];
			int lastTwoDigit = Integer.parseInt(message.substring(i - 2, i));
			if(lastTwoDigit >= 10 && lastTwoDigit <= 26)
				dp[i] += dp[i - 2];
		}
		
		return dp[message.length()];
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.decodedWays("111"));

	}

}
