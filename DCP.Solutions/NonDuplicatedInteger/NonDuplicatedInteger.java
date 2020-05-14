package NonDuplicatedInteger;

/**
 * Reference:
 * https://www.geeksforgeeks.org/find-the-element-that-appears-once/
 * https://stackoverflow.com/questions/14100169/find-the-element-that-appears-once
 * 
 * */

public class NonDuplicatedInteger {
	
	/*
	 * sum the bits in same positions for all the numbers and take modulo with 3. 
	 * The bits for which sum is not multiple of 3, are the bits of number with single occurrence.
	 * */
	public int GetResult(int[] a) {
		int sum = 0;
		for(int i : a) {
			int x = Integer.valueOf(Integer.toBinaryString(i));
			sum += x;
		}
		int bit = 0, result = 0;
		while(sum / 10 > 0) {
			if((sum % 10) % 3 != 0) {
				result +=  Math.pow(2, bit);
			}
			sum /= 10;
			bit ++;
		}
		if((sum % 10) % 3 != 0) {
			result += Math.pow(2, bit);
		}
		
		return result;
	}
	// cite from https://stackoverflow.com/questions/14100169/find-the-element-that-appears-once
	public int SimpleSolution(int[] a) {
		int ones = 0 ; //At any point of time, this variable holds XOR of all the elements which have appeared "only" once.
	    int twos = 0 ; //At any point of time, this variable holds XOR of all the elements which have appeared "only" twice.
	    int not_threes ;

	    for( int x : a )
	    {
	        twos |= ones & x ; //add it to twos if it exists in ones
	        ones ^= x ; //if it exists in ones, remove it, otherwise, add it

	        // Next 3 lines of code just converts the common 1's between "ones" and "twos" to zero.

	        not_threes = ~(ones & twos) ;//if x is in ones and twos, dont add it to Threes.
	        ones &= not_threes ;//remove x from ones
	        twos &= not_threes ;//remove x from twos
	    } 
	    return ones;
	}

	public static void main(String[] args) {
		int[] a = {5, 5, 8, 5};
		NonDuplicatedInteger solution = new NonDuplicatedInteger();
		System.out.println(solution.GetResult(a));
		System.out.println(solution.SimpleSolution(a));
	}

}
