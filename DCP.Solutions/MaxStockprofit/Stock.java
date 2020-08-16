package MaxStockprofit;

/**
 * Recursive
 * 
 * */

public class Stock {
	
	public static int maxProfit(int[] prices, int start, int end) {
		if(start >= end)
			return 0;
		
		int max_profit = 0;
		
		for(int i = start; i < end; i++) {
			for(int j = i + 1; j <= end; j++) {
				if(prices[j] > prices[i]) {
					int cur_profit = (prices[j] - prices[i])
							+ maxProfit(prices, start, i - 1)
							+ maxProfit(prices, j + 1, end);
					
					max_profit = Math.max(max_profit, cur_profit);
				}
			}
		}
		
		return max_profit;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] prices = {5, 2, 4, 0, 1};
		System.out.println(Stock.maxProfit(prices, 0, prices.length - 1));
	}

}
