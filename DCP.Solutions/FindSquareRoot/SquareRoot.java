package FindSquareRoot;

/**
 * Binary Search
 * 
 * */

public class SquareRoot {

	public static int sqrtOf(int n) {
		if(n < 0)
			return -1;
		if(n == 0 || n == 1)
			return n;
		
		// binary search
		int start = 1, end = n, result = 0;
		while(start <= end) {
			int mid = (start + end) / 2;
			if(mid * mid == n)
				return mid;
			if(mid * mid < n) {
				start = mid + 1;
				result = mid;
			}
			else {
				end = mid - 1;
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("sqrt(-1) = " + SquareRoot.sqrtOf(-1));
		System.out.println("sqrt(0) = " + SquareRoot.sqrtOf(0));
		System.out.println("sqrt(1) = " + SquareRoot.sqrtOf(1));
		System.out.println("sqrt(2) = " + SquareRoot.sqrtOf(2));
		System.out.println("sqrt(4) = " + SquareRoot.sqrtOf(4));
		System.out.println("sqrt(25) = " + SquareRoot.sqrtOf(25));
		System.out.println("sqrt(99) = " + SquareRoot.sqrtOf(99));
	}

}
