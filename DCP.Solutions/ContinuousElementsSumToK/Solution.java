package ContinuousElementsSumToK;

import java.util.Arrays;

// Suppose there is always a valid solution in the test case

public class Solution {
	
	public int[] findSequence(int[] a, int k) {
		int from = 0, to = 0, sum = a[0];
		while(true) {
			if(sum == k)
				break;
			else if(sum < k) {
				to ++;
				sum += a[to];
			}
			else {
				sum -= a[from];
				from++;
			}
		}
		
		return Arrays.copyOfRange(a, from, to + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {5,1,1,4,2};
		int k = 8;
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.findSequence(a, k)));
	}

}
