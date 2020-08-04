package CollectMaxCoinsInMatrix;

public class CoinCollecting {
	
	public static int maxResult(int[][] matrix) {
		if(matrix == null || matrix.length == 0)
			return 0;
		
		int m = matrix.length, n = matrix[0].length;
		
		int[][] max = new int[m][n];
		max[0][0] = matrix[0][0];
		
		for(int i = 1; i < m; i++) {
			max[i][0] = max[i - 1][0] + matrix[i][0];
		}
		for(int j = 1; j < n; j++) {
			max[0][j] = max[0][j - 1] + matrix[0][j];
		}
		
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				max[i][j] = Math.max(max[i - 1][j], max[i][j - 1]) + matrix[i][j];
			}
		}
		
		return max[m - 1][n - 1];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = {{0,3,1,1},{2,0,0,4},{1,5,3,1}};
		System.out.println(CoinCollecting.maxResult(matrix)); // 12
	}

}
