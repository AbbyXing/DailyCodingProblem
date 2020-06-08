package UnbiasedCoinToss;

import java.util.Random;

/**
 * Distribution, Expectation value, Probability
 * 
 * */

public class UnbiasedCoinToss {
	
	// unbiased toss
	public int toss_unbiased() {
		
		// Expectation value of this f() is 0, result can be -1, 0 or 1
		
		double diff = toss_biased() - toss_biased();
		
		// The probabilities of "return 0" and "return 1" are equal because
		// the probabilities of f() returning -1 and returning 1 are equal.
		
		if(diff < 0) // p' = p * (p-1)
			return 0;
		else if(diff > 0) // p' = p * (p-1)
			return 1;
		
		// if f() returns 0, drop this try and do again
		else // p' = p*p + (p-1)*(p-1)
			return toss_unbiased();
	}
	
	
	// biased toss
	private int toss_biased() {
		Random rand = new Random();
		double p = rand.nextDouble(); // p = 0.6
		if(p < 0.4)
			return 0;
		else
			return 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnbiasedCoinToss toss = new UnbiasedCoinToss();
		double head = 0, sum = 0;
		for(int i = 1; i <= 100000; i++) {
			sum++;
			int v = toss.toss_unbiased();
			if(v == 1)
				head++;
			System.out.println(sum + " " + head / sum);
		}
	}

}
