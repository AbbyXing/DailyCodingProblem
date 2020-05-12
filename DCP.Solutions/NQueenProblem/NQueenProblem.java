package NQueenProblem;

import java.util.Arrays;

/**
 * Backtracking
 * */

public class NQueenProblem {
	
	// array to record the column id of the queen on each row
	private int[] a;
	private int n;
	static int initial = Integer.MIN_VALUE;
	
	public NQueenProblem(int N) {
		n = N;
		a = new int[n];
		// initialize a
		Arrays.fill(a, initial);
	}
	
	public int GetArrangmentsNum() {
		if(n < 1)
			return 0;
		
		int result = 0;
		int i = 0, j = 0;
		
		while(i < n) {
			while(j < n) {
				// if (i, j) is valid, place the queen and move to the next row
				if(isValid(i, j)) {
					a[i] = j;
					j = 0;
					break;
				} else { // if (i, j) is not valid, move to the next column
					j++;
				}
			}
			
			// if can not find any valid column in this row, backtrack to the last row,
			// remove the queen in last row, and start scanning from the next column of its current column
			if(a[i] == initial) {
				// if its the first row, exit the program
				if(i == 0)
					break;
				i--; // backtrack
				j = a[i] + 1;
				a[i] = initial;
				continue;
			}
			
			// if reach the last row, means found an arrangement
			if(i == n - 1) {
				result++;
				// continue on the next column of this row to find the next arrangement
				j = a[i] + 1;
				a[i] = initial;
				continue;
			}
			
			i++;
		}
		
		return result;
	}
	
	// check if the queen can be placed on row r column c
	private boolean isValid(int r, int c) {
		for(int i = 0; i < n; i++) {
			if(a[i] == c || i + a[i] == r + c || i - a[i] == r - c)
				return false;
		}	
		return true;
	}

	public static void main(String[] args) {
		NQueenProblem solution = new NQueenProblem(8);
		System.out.println(solution.GetArrangmentsNum());
	}

}
