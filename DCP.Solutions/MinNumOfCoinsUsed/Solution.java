package MinNumOfCoinsUsed;

public class Solution {
	
	private static int[] coins = {1, 5, 10, 25};
	
	public static int minCoinsRequired(int sum) {
		
		int result = 0;
		
		int pointer = coins.length - 1;
		
		while(pointer > 0) {
			if(coins[pointer] > sum)
				pointer--;
			else {
				result += sum / coins[pointer];
				sum %= coins[pointer];
			}
		}
		
		result += sum;
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Solution.minCoinsRequired(16));
	}

}
