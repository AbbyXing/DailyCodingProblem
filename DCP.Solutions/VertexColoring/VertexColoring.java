package VertexColoring;

/**
 * Backtracking
 * */

public class VertexColoring {
	
	// main function
	public void Coloring(int[][] graph, int k) {
		int V = graph.length;
		int[] colors = new int[V];
		// no solution for v0 -> no solution
		if(!SubColoring(graph, k, colors, 0))
			System.out.println("No solution!");
		else
			PrintColor(colors);
	}
	
	// backtracking function
	private boolean SubColoring(int[][] graph, int k, int[] colors, int v) {
		int V = graph.length;
		if(v == V)
			return true;
		for(int c = 1; c <= k; c++) {
			// if v can be assigned color c
			if(isValid(graph, colors, v, c)) {
				colors[v] = c;
				// see if v+1 still has a solution (continuously calling)
				if(SubColoring(graph, k, colors, v + 1))
					return true;
				// v+1 has no solution, clean v and find the next valid color for v
				else {
					colors[v] = 0;
				}
			}
		}
		// can't find any valid color for v -> backtrack
		return false;
	}
	
	// check if vertex v can be assigned color c
	private boolean isValid(int[][] graph, int[] colors, int v, int c) {
		int V = graph.length;
		for(int i = 0; i < V; i++) {
			if(graph[v][i]== 1 && colors[i] == c)
				return false;
		}
		return true;
	}
	
	// print solution
	private void PrintColor(int[] colors) {
		for(int i = 0; i < colors.length; i++) {
			System.out.println("Vertex " + i + ": " + colors[i]);
		}
	}

	public static void main(String[] args) {
		int[][] graph = {{0, 1, 1, 1},
				        {1, 0, 1, 0},
				        {1, 1, 0, 1},
				        {1, 0, 1, 0}};
		VertexColoring vertexColoring = new VertexColoring();
		vertexColoring.Coloring(graph, 3);
		vertexColoring.Coloring(graph, 1);
	}

}
