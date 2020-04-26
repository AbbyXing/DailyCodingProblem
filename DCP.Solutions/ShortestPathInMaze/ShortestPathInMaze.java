package ShortestPathInMaze;

/**
 * BFS(Breadth First Search)
 * 
 * A `vists[][]` matrix to record visited tile
 * 
 * A trace queue to store tiles that waited to be explored
 * 
 *  * */

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathInMaze {
	
	private int M, N;
	private boolean[][] maze;
	private Queue<Tile> traceQueue;
	private boolean[][] visited;
	
	public ShortestPathInMaze(boolean[][] m) {
		if(m != null) {
			this.maze = m;
			M = m.length;
			N = M>0 ? m[0].length : 0;
		}
	}
	
	public int GetMinStep(int[] start, int[] end) {
		if(maze == null || start == null || end == null)
			return -1;
		
		// define 4 directions can move
		int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
		this.traceQueue = new LinkedList<Tile>();
		this.visited = new boolean[M][N];
		
		// if start point id legal, then add it to trace queue and mark it as visited
		if(IsLegal(start[0], start[1])) {
			traceQueue.add(new Tile(start[0], start[1], 0));
			visited[start[0]][start[1]] = true;
		}
		
		// poll a tile each time, and explore 4 directions from this tile if legal
		while(!traceQueue.isEmpty()) {
			Tile t = traceQueue.poll();
			
			// if reach the end tile, return
			if(t.x == end[0] && t.y == end[1])
				return t.s;
			for(int[] dir: directions) {
				int x = t.x + dir[0];
				int y = t.y + dir[1];
				if(IsLegal(x, y)) {
					traceQueue.add(new Tile(x, y, t.s + 1));
				}
			}
		}
		
		return -1;
	}

	// check if (x, y) is a legal tile: is on the board && is not a wall && hasn't been visited
	private boolean IsLegal(int i, int j) {
		return !(i < 0 || j < 0 || i >= M || j >= N || maze[i][j] || visited[i][j]);
	}

	public static void main(String[] args) {
		boolean[][] maze = {{false, false, false, false}, {true, true, false, true}, {false, false, false, false}, {false, false, false, false}};
		int[] start = {3, 0}, end = {0,0};
		ShortestPathInMaze solution = new ShortestPathInMaze(maze);
		System.out.println(solution.GetMinStep(start, end));
	}

}
