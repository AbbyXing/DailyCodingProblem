package MaximumStockProfit;

public class MaxStockProfit {
	
	// approach #1: time costing
	public int GetMaxProfit1(int[] prices) {
		// invalid input
		if(prices.length <= 1)
			return -1;
		
		int n = prices.length;
		int max = Integer.MIN_VALUE;
		
		for(int i = 0; i < n - 1; i++) {
			for(int j = i + 1; j < n; j++) {
				if(prices[j] - prices[i] > max)
					max = prices[j] - prices[i];
			}
		}
		
		return max;
	}
	
	// approach #2: space costing
	public int GetMaxProfit2(int[] prices) {
		// invalid input
		if(prices.length <= 1)
			return -1;
		
		int n = prices.length;
		int min_price = Integer.MAX_VALUE, max_profit = Integer.MIN_VALUE;
		// base case:
		min_price = Math.min(prices[0], prices[1]);
		max_profit = prices[1] - prices[0];
		// dynamic programming
		for(int i = 2; i < n; i++) {
			max_profit = Math.max(max_profit, prices[i] - min_price);
			min_price = Math.min(min_price, prices[i]);
		}
		
		return max_profit;
	}

	public static void main(String[] args) {
		int[] prices = {9, 11, 8, 5, 7, 10};
		MaxStockProfit solution = new MaxStockProfit();
		System.out.println(solution.GetMaxProfit1(prices));
		System.out.println(solution.GetMaxProfit2(prices));
	}

}
