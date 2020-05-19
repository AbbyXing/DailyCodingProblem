package ExpandRandomRange;

import java.util.Random;

public class ExpandRandomRange {

	private int rand5() {
		Random random = new Random();
		return 1 + random.nextInt(5);
	}
	
	public int rand7() {
		Random random = new Random();
		double p = random.nextDouble();
		if(p <= (double)(5.0 / 7.0)) {
			return rand5();
		}
		else {
			return 6 + random.nextInt(2);
		}
	}
	
	public static void main(String[] args) {
		ExpandRandomRange solution = new ExpandRandomRange();
		int total = 10000;
		int seven = 0;
		for(int i = 0; i < total; i++) {
			if(solution.rand7() == 5)
				seven++;
		}
		System.out.println((double)seven / (double)total);
		System.out.println(1.0 / 7.0);
	}

}
