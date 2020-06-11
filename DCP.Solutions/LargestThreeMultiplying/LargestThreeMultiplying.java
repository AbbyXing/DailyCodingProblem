package LargestThreeMultiplying;

import java.util.Arrays;

/**
 * Time: O(log n)
 * 
 * Space: O(1)
 * */

public class LargestThreeMultiplying {
	
	public int GetMaxMultiplying(int[] a) {
		Arrays.sort(a); // ascending order
		int n = a.length;
		
		// all positive: last 3
		
		// 1 positive 2 negative: first 2 and last 1
		
		// 2 positive 1 negative: applys to only having 3 elements in that array, so last 3
		
		// 3 negative: last 3
		
		return Math.max(a[n - 1] * a[n - 2] * a[n - 3], a[0] * a[1] * a[n - 1]);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestThreeMultiplying solution = new LargestThreeMultiplying();
		
		int[] a = {-10, -10, 5, 2};
		System.out.println(solution.GetMaxMultiplying(a)); // 500
		int[] b = {10, 3, 5, 6, 20};
		System.out.println(solution.GetMaxMultiplying(b)); // 1200
		int[] c = {-10, -3, -5, -6, -20};
		System.out.println(solution.GetMaxMultiplying(c)); // -90
		int[] d = {1, -4, 3, -6, 7, 0};
		System.out.println(solution.GetMaxMultiplying(d)); // 168
	}

}
