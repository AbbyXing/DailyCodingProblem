package LargestSumOfNonAdjacent;

public class Solution {
	
	/*
	 * Define two Integer,
	 * 'sum_pre' is the max sum with previous item,
	 * 'sum_pre_pre' is the max sum without previous item.
	 * 
	 * So current item can only be added to 'sum_pre_pre' because of non-adjacent only.
	 * 
	 * In each step: sum_pre = sum+pre_pre + current, sum_pre_pre = max(old_sum_pre, sum_pre_pre).
	 * 
	 * Return 'max(sum_pre, sum_pre_pre)'
	 * */
	
	public Solution() {}
	
	public int maxSumNonAdjacent(int[] data) {
		if(data == null)
			return 0;
		// i = 0:
		int sum_pre_pre = 0, sum_pre = data[0];
		for(int i = 1; i < data.length; i++) {
			int current = data[i];
			int old_sum_pre = sum_pre;
			sum_pre = sum_pre_pre + current;
			sum_pre_pre = Math.max(old_sum_pre, sum_pre_pre);
		}
		
		return(Math.max(sum_pre, sum_pre_pre));
	}

	public static void main(String[] args) {
		Solution solution = new Solution();
		int[] data = new int[] {2, 4, 6, 2, 5};
		System.out.println(solution.maxSumNonAdjacent(data));
	}

}
