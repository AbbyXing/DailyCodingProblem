package PartitionSetWithSameSum;

import java.util.Arrays;

/**
 * Dynamic Programming
 * */

public class PartitionSet {
	
	public boolean Partition(int[] a) {
		// special cases
		if(a == null || a.length == 0)
			return true;
		if(a.length == 1)
			return false;
		
		// if sum of the set is odd, then can't divide into 2 subarrays with same sum
		int sum = Arrays.stream(a).sum();
		if(sum % 2 != 0)
			return false;
		sum /= 2;
		
		// dynamic programming
		boolean[] dp = new boolean[sum + 1];
		for(int i : a)
			dp[i] = true;
		for(int i = 0; i <= sum; i++) {
			for(int k : a) {
				if(i - k >= 0 && dp[i - k]) {
					dp[i] = true;
					break;
				}
			}
		}
		
		return dp[sum];
	}

	public static void main(String[] args) {
		int[] a = {15, 5, 20, 10, 35, 15, 10};
		int[] b = {15, 5, 20, 10, 35};
		PartitionSet solution = new PartitionSet();
		System.out.println(solution.Partition(a));
		System.out.println(solution.Partition(b));
	}

}
