package CurrencyArbitrage;

import java.util.Arrays;

/**
 * Graph
 * 
 * Goal: looking for a cycle whose product of edge weights is greater than 1
 * 
 * 1. trans product to looking for the minimum sum: 
 * log (w1 * w2 * w3 ... ) > log(1) => log(w1) + log(w2) + log(w3) ... > 0 => -log(w1) - log(w2) - log(w3) ... < 0
 * 
 * New goal: looking for a negative cycle in the graph => Bellman-Ford algorithm
 * 
 * Bellman-Ford can be used to solve the following problems:

- Whether there is a path from A to each node (of course, the calculated value can be reached);
- The shortest path from A to each node (shortest time, shortest path, etc.)
- Whether there is a negative cycle in the graph (the sum of weights is negative)
 * */

public class CurrencyArbitrage {
	
	public CurrencyArbitrage() {}
	
	public boolean hasArbitrage(double[][] rates) {
		int n = rates.length;
		// transform graph weights
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				rates[i][j] = (-1) * Math.log(rates[i][j]);
			}
		}
		
		// Bellman-Ford
		return bellmanFord(rates, 0);
	}
	
	private boolean bellmanFord(double[][] rates, int source) {
		int n = rates.length;
		double[] dis = new double[n];
		int[] pre = new int[n];
		Arrays.fill(dis, Double.MAX_VALUE);
		Arrays.fill(pre, -1);
		dis[source] = 0;
		// Relax edges |V - 1| times
		for(int k = 0; k < n - 1; k++) {
			for(int i = 0; i < n; i++) {
				for(int j = 0; j < n; j++) {
					if(rates[i][j] + dis[i] < dis[j]) {
						dis[j] = rates[i][j] + dis[i];
						pre[j] = i;
					}
				}
			}
		}
		// check if there's negative cycle
		for (int i = 0; i < n; ++i)
			  for (int j = 0; j < n; ++j)
			    if (dis[i] + rates[i][j] < dis[j])
			    	return true; // negative cycle exists
		
		return false;
	}

	public static void main(String[] args) {
		double[][] rates = {{1, 0.5, 0.7}, {1.1, 1, 0.9}, {1.3, 1.5, 1}};
		CurrencyArbitrage solution = new CurrencyArbitrage();
		System.out.println(solution.hasArbitrage(rates));
	}

}
