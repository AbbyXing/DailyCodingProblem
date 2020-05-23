package MaxSumOfSubarry;

/**
 * Because there are some negative elements in the array so all we need to do is
 * to find the maximum positive sum of a contiguous subarray and if we cannot find
 * a positive sum then we just simply return 0.
 * */

public class MaxSumOfSubarray {
	
	public int GetMaxSum(int[] a) {
		int max = 0, temp_max = 0, n = a.length;
		for(int i = 0; i < n; i++) {
			temp_max = temp_max + a[i] < 0 ? 0 : temp_max + a[i];
			max = Math.max(max, temp_max);
		}
		
		return max;
	}

	public static void main(String[] args) {
		int[] a = {34, -50, 42, 14, -5, 86};
		MaxSumOfSubarray solution = new MaxSumOfSubarray();
		System.out.println(solution.GetMaxSum(a));
	}

}
