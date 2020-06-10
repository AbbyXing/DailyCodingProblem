package BishopAttack;

public class BishopAttack {
	
	private int M;
	private int[][] board;
	
	public BishopAttack(Integer m, int[][] bishops) {
		M = m;
		
		board = new int[M][M];
		for(int[] bishop : bishops) {
			int i = bishop[0];
			int j = bishop[1];
			board[i][j] = 1;
		}
	}
	
	public int CountAttackPairs() {
		int result = 0;

		// Count all right direction diagonals
		for(int i = M - 2; i > 0; i--) {
			int numBishops = CountDiagonal(i, 0, "right");
			result += AttachPairsDiagonal(numBishops);
		}
		for(int j = 0; j < M - 1; j++) {
			int numBishops = CountDiagonal(0, j, "right");
			result += AttachPairsDiagonal(numBishops);
		}
		
		// Count all left direction diagonals
		for(int j = 1; j < M; j++) {
			int numBishops = CountDiagonal(0, j, "left");
			result += AttachPairsDiagonal(numBishops);
		}
		for(int i = 1; i < M - 1; i++) {
			int numBishops = CountDiagonal(i, M - 1, "left");
			result += AttachPairsDiagonal(numBishops);
		}
		
		return result;
	}
	
	// Count the bishop amount in a specific diagonal
	private int CountDiagonal(int i, int j, String direct) {
		int count = 0;
		if(direct.equals("right")) {
			while(i < M && j < M) {
				if(board[i][j] == 1)
					count++;
				i++;
				j++;
			}
		}
		else {
			while(i < M && j >= 0) {
				if(board[i][j] == 1)
					count++;
				i++;
				j--;
			}
		}
		
		return count;
	}
	
	// Given the amount of bishops in a diagonal, calculate the number of attack pairs
	private int AttachPairsDiagonal(int count) {
		
		return (count * (count - 1)) / 2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int M = 5;
		int[][] bishops = {{0,0},{1,2},{2,2},{4,0}};
		BishopAttack bishopAttack = new BishopAttack(M, bishops);
		System.out.println(bishopAttack.CountAttackPairs());
	}

}
