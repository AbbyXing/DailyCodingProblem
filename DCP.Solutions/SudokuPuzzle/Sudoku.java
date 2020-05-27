package SudokuPuzzle;

import java.util.Arrays;

/**
 * Backtracking
 * 
 * similar as the 8 Queen problem
 * */

public class Sudoku {
	
	private int n;
	private int[][] grid;
	
	public Sudoku(int[][] initial) {
		grid = initial;
		n = grid.length;
	}
	
	// return a solution or say the puzzle is not solvable
	public void GetASolution() {
		if(HasASolution())
			PrintPuzzle();
		else
			System.out.println("Not solvable!");
	}
	
	// backtracking function
	private boolean HasASolution() {
		int r = -1, c = -1;
		boolean finish = true;
		// find an empty grid in the puzzle
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				// found an empty grid
				if(grid[i][j] == 0) {
					r = i;
					c = j;
					// the puzzle is not finished
					finish = false;
					break;
				}
			}
			// an empty grid has been found, so break the loop
			if(!finish)
				break;
		}
		
		// the whole puzzle has been finished (no empty grid)
		if(finish)
			return true;
		
		// for this found empty grid, try to fill it with value 1-9
		for(int v = 1; v <= n; v++) {
			if(isValid(r, c, v)) {
				grid[r][c] = v;
				// see if this path can lead to a solution
				if(HasASolution())
					return true;
				else
					// this path cannot lead to a solution, so try the next value
					grid[r][c] = 0;
			}
				
		}
		
		return false;
	}
	
	// check if grid[r][c] can be value v in the puzzle
	private boolean isValid(int r, int c, int v) {
		// check each row
		for(int i = 0; i < n; i++) {
			if(grid[i][c] == v)
				return false;
		}
		// check each column
		for(int j = 0; j < n; j++) {
			if(grid[r][j] == v)
				return false;
		}
		// check each box
		for(int i = r / 3; i < r / 3 + 3; i++) {
			for(int j = c / 3; j < c / 3; c++) {
				if(!(i == r && j == c)) {
					if(grid[i][j] == v)
						return false;
				}
			}
		}
		
		// everything good, return true
		return true;
	}
	
	// print out the solution
	public void PrintPuzzle() {
		for(int i = 0; i < n; i++)
			System.out.println(Arrays.toString(grid[i]));
	}

	public static void main(String[] args) {
		int[][] initial = { { 3, 1, 6, 5, 7, 8, 4, 9, 2 }, 
			                { 5, 2, 9, 1, 3, 4, 7, 6, 8 }, 
			                { 4, 8, 7, 6, 2, 9, 5, 3, 1 }, 
			                { 2, 6, 3, 0, 1, 5, 9, 8, 7 }, 
			                { 9, 7, 4, 8, 6, 0, 1, 2, 5 }, 
			                { 8, 5, 1, 7, 9, 2, 6, 4, 3 }, 
			                { 1, 3, 8, 0, 4, 7, 2, 0, 6 }, 
			                { 6, 9, 2, 3, 5, 1, 8, 7, 4 }, 
			                { 7, 4, 5, 0, 8, 6, 3, 1, 0 } }; 
		Sudoku sudoku = new Sudoku(initial);
		sudoku.GetASolution();
	}

}
