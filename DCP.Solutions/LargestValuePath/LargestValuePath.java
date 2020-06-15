package LargestValuePath;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * Topological Sorting & Dynamic Programming
 * 
 * */


public class LargestValuePath {
	
	enum State {
		UNPROCESSED,
        PROCESSING,
        PROCESSED;
    }
	
	private List<List<Integer>> graph;
	
	public Integer getLargestValue(String s, int[][] edges) {
		// special cases
		if(s== null || s.isEmpty() || edges == null) return 0;
		if (!s.isEmpty() && edges.length == 0) return 1;
		if (s.isEmpty() && edges.length == 1) return 2;
		
		// if the graph has cycle, return null
		if(!buildGraph(s, edges)) return null;
		
		// if no cycle, find the largest path value
		State[] states = new State[graph.size()];
		Arrays.fill(states, State.UNPROCESSED);
		
		// topological sort
		Deque<Integer> order = topSort(graph, states);
		if(order == null) // has cycle
			return null;
		
		return getLargestHelper(s.toCharArray(), graph, order);
	}
	
	// 
	private Integer getLargestHelper(char[] s, List<List<Integer>> graph, Deque<Integer> order) {
		int maxValue = 0;
		//dp[i][j] is the max value that can be made using the ith node as path starting node and jth letter.
		int[][] dp = new int[s.length][26]; // 26 upper-case letters
		for (int node = 0; node < graph.size(); node++) {
            dp[node][s[node] - 'A']++;
        }
		
		while(!order.isEmpty()) {
			int node = order.poll();
			for (int adj : graph.get(node)) {
                for (int i = 0; i < dp[0].length; i++) {
                    dp[adj][i] = Math.max(dp[adj][i], dp[node][i]);
                }
                dp[adj][s[adj] - 'A'] = dp[node][s[adj] - 'A'] + 1;
                maxValue = Math.max(maxValue, dp[adj][s[adj] - 'A']);
            }
		}
		
		return maxValue;
	}
	
	// topological sort
	private Deque<Integer> topSort(List<List<Integer>> graph, State[] states) {
        Deque<Integer> order = new ArrayDeque<>();
        for (int node = 0; node < graph.size(); node++) {
            if (hasCycle(graph, node, states, order)) return null;
        }
        //System.out.println(order.toString());
        return order;
    }
    
    private boolean hasCycle(List<List<Integer>> graph, int node, State[] states, Deque<Integer> order) {
        if (states[node] != State.UNPROCESSED) {
            return states[node] == State.PROCESSING;
        }
        states[node] = State.PROCESSING;
    
        for (int adj : graph.get(node)) {
            if (hasCycle(graph, adj, states, order)) return true;
        }
        
        states[node] = State.PROCESSED;
        order.push(node);
        return false;
    }
	
	// build graph nodes and check if there is cycle in the graph
	private boolean buildGraph(String s, int[][] edges) {
		graph = new ArrayList<List<Integer>>();
		for(int i = 0; i < s.length(); i++) {
			graph.add(new ArrayList<Integer>());
		}
		for(int[] edge : edges) {
			graph.get(edge[0]).add(edge[1]);
			if(edge[0] == edge[1])
				return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LargestValuePath solution = new LargestValuePath();
		
		String s = "ABACA";
		int[][] edges = new int[][] {{0, 1},
									{0, 2},
									{2, 3},
									{3, 4}};
		System.out.println(solution.getLargestValue(s, edges)); //Expect 3
		
		
		s = "A";
		edges = new int[][] {{0, 0}};
		System.out.println(solution.getLargestValue(s, edges)); //Expect null
        
        s = "ABABBC";
		edges = new int[][]{};
		System.out.println(solution.getLargestValue(s, edges)); //Expect 1
        
        s = "BAA";
        edges = new int[][] {{0, 1},
        					{0, 2}};
        System.out.println(solution.getLargestValue(s, edges)); //Expect 1
        
        s = "BAA";
        edges = new int[][] {{0, 1},
        					{2, 0}};
        System.out.println(solution.getLargestValue(s, edges)); //Expect 2 
	}

}
