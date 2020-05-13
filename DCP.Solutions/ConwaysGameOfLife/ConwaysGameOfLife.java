package ConwaysGameOfLife;

import java.util.ArrayList;
import java.util.List;

public class ConwaysGameOfLife {
	
	private int step;
	private List<int[]> live;
	
	public ConwaysGameOfLife(List<int[]> init ,int s) {
		this.step = s;
		this.live = init;
		System.out.println("Initial:");
		for(int[] coord : init)
			System.out.println("(" + coord[0] + ", " + coord[1] + ") -> *");
	}
	
	private void nextGeneration() {
		List<int[]> scanned = new ArrayList<int[]>();
		List<int[]> remove = new ArrayList<int[]>();
		List<int[]> add = new ArrayList<int[]>();
		for(int[] coord : live) {
			for(int i = -1; i <= 1; i++) {
				for(int j = -1; j <= 1; j++) {
					int[] neighbor = new int[2];
					neighbor[0] = i + coord[0];
					neighbor[1] = j + coord[1];
					if(!contains(scanned, neighbor) && !contains(live, neighbor) && dieToLive(neighbor)) {
						//System.out.println(contains(scanned, neighbor));
						add.add(neighbor);
						//System.out.println(neighbor[0] + " " + neighbor[1]);
					}
					scanned.add(neighbor);
				}
			}
			if(liveToDie(coord)) {
				remove.add(coord);
			}
			scanned.add(coord);
		}
		
		// add
		for(int[] coord : add)
			System.out.println("(" + coord[0] + ", " + coord[1] + ") -> *");
		live.addAll(add);
		// remove
		for(int[] coord : remove)
			System.out.println("(" + coord[0] + ", " + coord[1] + ") -> .");
		live.removeAll(remove);
	}
	
	private boolean contains(List<int[]> list,int[] coord) {
		for(int[] c : list) {
			if(coord[0] == c[0] && coord[1] == c[1]) {
				return true;
			}
		}
		return false;
	}
	
	public void play() {
		for(int i = 0; i < step; i++) {
			System.out.println("\n" + "Step " + (i + 1) + ":");
			nextGeneration();
		}
	}
	
	private int countLiveNeighbors(int[] coord) {
		int liveNeighbors = 0;
		for(int i = -1; i <= 1; i++) {
			for(int j = -1; j <= 1; j++) {
				if(!(i == 0 && j == 0)) {
					//System.out.println((i + coord[0]) + " " + (j + coord[1]));
					if(contains(live, new int[] {i + coord[0], j + coord[1]}))
						liveNeighbors ++;
				}
			}
		}
		//System.out.println(liveNeighbors);
		return liveNeighbors;
	}
	
	private boolean liveToDie(int[] coord) {
		int liveNeighbors = countLiveNeighbors(coord);
		if(liveNeighbors < 2)
			return true;
		if(liveNeighbors > 3)
			return true;
		return false;
	}
	
	private boolean dieToLive(int[] coord) {
		int liveNeighbors = countLiveNeighbors(coord);
		if(liveNeighbors == 3)
			return true;
		return false;
	}

	public static void main(String[] args) {
		List<int[]> lives = new ArrayList<>();
		lives.add(new int[] {1, 3});
		lives.add(new int[] {1, 4});
		lives.add(new int[] {2, 4});
		lives.add(new int[] {5, 3});
		lives.add(new int[] {5, 4});
		lives.add(new int[] {6, 2});
		lives.add(new int[] {6, 3});
		lives.add(new int[] {7, 5});
		lives.add(new int[] {8, 4});
		
		ConwaysGameOfLife game = new ConwaysGameOfLife(lives, 1);
		game.play();
	}

}
