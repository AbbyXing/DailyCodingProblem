package TwoPrimeWithGivenSum;

import java.util.Arrays;

public class Solution {
	
	public int[] getTwoPrimes(int num) {
		int[] result = new int[2];
		for(int i = 2; i <= num / 2; i++) {
			if(prime(i) && prime(num - i)) {
				result[0] = i;
				result[1] = num - i;
				break;
			}
		}
		
		return result;
	}
	
	private boolean prime(int n) {
		int m = n / 2;
		for(int i = 2; i <= m; i++) {
			if(n % i == 0)
				return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(Arrays.toString(solution.getTwoPrimes(24)));
	}

}
