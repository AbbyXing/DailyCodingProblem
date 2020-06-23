package NonDecreasingArray;

public class NonDecreasingArray {
	
	public boolean nonDecreasing(int[] a) {
		int n = a.length;
		Integer k = null;
		for(int i = 0; i < n - 1; i++) {
			if(a[i] > a[i + 1]) {
				if(k != null) // more than 2 a[i] is bigger than a[i + 1]	
					return false;
				k = i;
			}
		}
		
		if(k == null || k == 0 || k == n - 2 || a[k - 1] <= a[k + 1] ||a[k] <= a[k + 2])
			return true;
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {10,5,7};
		int[] b = {10,5,1};
		NonDecreasingArray solution = new NonDecreasingArray();
		System.out.println(solution.nonDecreasing(a));
		System.out.println(solution.nonDecreasing(b));
	}

}
