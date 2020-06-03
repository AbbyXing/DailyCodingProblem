package CalculateExponentiation;

/**
 * Divide and Conquer
 * 
 * Subproblem: pow(x, y / 2)
 * 
 * O(log n)
 * */

public class Pow {
	
	public int pow(int x, int y) {
		if(x == 0)
			return 0;
		
		// base case
		if(y == 0)
			return 1;
		
		// record the subproblem result to reduce the numbers of calling
		int subPow = pow(x, y / 2);
		
		if(y % 2 == 0)
			return subPow * subPow;
		else 
			return x * subPow * subPow;
	}

	public static void main(String[] args) {
		Pow pow = new Pow();
		System.out.println(pow.pow(2, 10));
	}

}
