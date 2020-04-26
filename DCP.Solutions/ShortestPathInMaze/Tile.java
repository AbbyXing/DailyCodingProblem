package ShortestPathInMaze;

/**
 * x, y are coordinates
 * s is the number of steps takes from the start tile to this tile
 * */
public class Tile {
	public int x, y, s;
	
	public Tile(int x, int y, int s) {
		this.x= x;
		this.y = y;
		this.s = s;
	}
}
