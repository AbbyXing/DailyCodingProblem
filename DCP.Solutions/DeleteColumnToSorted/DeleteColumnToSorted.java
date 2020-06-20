package DeleteColumnToSorted;

/**
 * !!!!! Unsolved !!!!!
 * 
 * */

public class DeleteColumnToSorted {
	
	public int MinRemove(int[][] a) {
		if(a == null || a.length == 0)
			return 0;
		
		int M = a.length, N = a[0].length;
		int result = 0;
		boolean[] valid = new boolean[M - 1];
		
		search: for(int j = 0; j < N; j++) {
			for(int i = 0; i < M - 1; i++) {
				if(!valid[i] && (a[i][j]> a[i + 1][j])) {
					result++;
					continue search;
				}
			}
			
			for(int i = 0; i < M - 1; i++) {
				if(a[i][j] < a[i + 1][j])
					valid[i] = true;
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {{'c','b','a'},
					 {'d','a','f'},
					 {'g','h','i'}};
		DeleteColumnToSorted solution = new DeleteColumnToSorted();
		System.out.println(solution.MinRemove(a));
	}
}
