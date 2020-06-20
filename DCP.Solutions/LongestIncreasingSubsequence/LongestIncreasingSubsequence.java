package LongestIncreasingSubsequence;

import java.util.Arrays;

/**
 * Dynamic Programming
 * */

public class LongestIncreasingSubsequence {
	
	public int GetLength(int[] a) {
		if(a == null || a.length == 0)
			return 0;
		int n = a.length;
		int[] dp = new int[n];
		
		// base case: all length are 1
		Arrays.fill(dp, 1);
		
		// dynamic programming: if a[i] > a[j], dp[i] could be dp[j] + 1
		for(int i = 1; i < n; i++) {
			for(int j = 0; j < i; j++) {
				if(a[i] > a[j])
					dp[i] = Math.max(dp[i], dp[j] + 1);
			}
		}
		
		// return max
		int max = 0;
		for(int l : dp)
			max = Math.max(max, l);
		return max;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
		LongestIncreasingSubsequence solution = new LongestIncreasingSubsequence();
		System.out.println(solution.GetLength(a));
	}

}
