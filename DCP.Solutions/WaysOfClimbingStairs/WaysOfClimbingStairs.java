package WaysOfClimbingStairs;

/**
 * [Dynamic Programming]
 * 
 * Given a steps array `steps[m]`, we can have:
 * 
 * dp(n) = dp(n - steps[0]) + dp(n - steps[1]) + ... + dp(n - steps[m - 1])
 * 
 * Base case: dp(0) = 1 -> because if steps[k] == n, we want dp(n - steps[k]) = 1.
 * */

public class WaysOfClimbingStairs {
	
	private int result;
	
	public WaysOfClimbingStairs(int[] steps, int totalSteps) {
		if(steps == null || totalSteps <= 0) {
			this.result = 0;
		}
		else {
			int[] ways = new int[totalSteps + 1];
			ways[0] = 1;
			for(int i = 1; i <= totalSteps; i++) {
				for(Integer j: steps) {
					if(i - j < 0)
						continue;
					ways[i] += ways[i - j];
				}
			}
			this.result = ways[totalSteps];
		}
	}
	
	public int GetResult() {
		return this.result;
	}

	public static void main(String[] args) {
		int[] steps = new int[] {1, 2};
		WaysOfClimbingStairs waysOfClimbingStairs = new WaysOfClimbingStairs(steps, 4);
		System.out.println(waysOfClimbingStairs.GetResult());;
	}

}
