package FindWordInMatrix;


public class FindWordInMatrix {
	
	public boolean FindWord(char[][] matrix, char[] word) {
		if(matrix == null || matrix.length == 0)
			return false;
		
		int m = matrix.length, n = matrix[0].length;
		for(int i = 0; i < m; i++) {
			for(int j = 0; j < n; j++) {
				if(matrix[i][j] == word[0]) {
					if(search(matrix, word, i, j))
						return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean search(char[][] matrix, char[] word, int r, int c) {
		int m = matrix.length, n = matrix[0].length;
		if(word.length > m - r && word.length > n - c)
			return false;
		
		if(word.length <= m - r) {
			for(int i = 0; i < word.length; i++) {
				if(word[i] != matrix[r + i][c])
					return false;
			}
		}
		else if(word.length <= n - c) {
			for(int i = 0; i < word.length; i++) {
				if(word[i] != matrix[r][c + i])
					return false;
			}
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][] matrix = {{'F', 'A', 'C', 'I'},
							{'O', 'B', 'Q', 'P'},
							{'A', 'N', 'O', 'B'},
							{'M', 'A', 'S', 'S'}};
		String word = "MASS";
		FindWordInMatrix solution = new FindWordInMatrix();
		System.out.println(solution.FindWord(matrix, word.toCharArray()));
		word = "MASS";
		System.out.println(solution.FindWord(matrix, word.toCharArray()));
		word = "ABB";
		System.out.println(solution.FindWord(matrix, word.toCharArray()));
	}

}
