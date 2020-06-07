package ClockwiseSpiralMatrix;

/**
 * Recursive
 * */

public class ClockwiseSpiralMatrix {
	
	// recursively print each board
	public void Print(int[][] a, int m, int n, int r, int c) {
		if(m <= 0 || n <= 0)
			return;
		
		// print top row
		for(int j = r; j < c + n; j++)
			System.out.print(a[r][j] + " ");
		
		// print last column
		for(int i = r + 1; i < r + m; i++) {
			System.out.print(a[i][c + n - 1] + " ");
		}
		
		// print last row (if havn't printed)
		if(m > 1) {
			for(int j = c + n - 2; j >= c; j--)
				System.out.print(a[r + m - 1][j] + " ");
		}
		
		// print first column (if havn't printed)
		if(n > 1) {
			for(int i = r + m - 2; i >= r + 1; i--)
				System.out.print(a[i][c] + " ");
		}
		
		// recurse
		Print(a, m - 2, n - 2, r + 1, c + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {{1,2,3,4,5},{6,7,8,9,10},{11,12,13,14,15},{16,17,18,19,20}};
		ClockwiseSpiralMatrix matrix = new ClockwiseSpiralMatrix();
		matrix.Print(a, a.length, a[0].length, 0, 0);
	}

}
