package MultiplicationTable;

public class MultiplicationTable {
	
	public int getTimes(int N, int x) {
		if(x <= 0 || x > N * N)
			return 0;
		int times = 0;
		for(int i = 1; i <= N; i++) {
			if(x % i == 0) {
				int j = x / i;
				if(j >= 1 && j <= N) {
					times++;
				}
			}
		}
		return times;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiplicationTable solution = new MultiplicationTable();
		System.out.println(solution.getTimes(6, 12));
		System.out.println(solution.getTimes(5, 12));
	}

}
