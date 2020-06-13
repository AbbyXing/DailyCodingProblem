package Rand7ToRand5;

import java.util.Random;

public class Rand {
	
	private int rand7() {
		Random rand = new Random();
		return 1 + rand.nextInt(7);
	}
	
	public int rand5() {
		int num = rand7();
		while(num > 5) {
			num = rand7();
		}
		return num;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rand rand = new Rand();
		double sum = 0, count = 0;
		for(int i = 0; i < 10000; i++) {
			if(rand.rand5() == 1)
				count++;
			sum++;
		}
		System.out.println((int)sum + ": " + count / sum);
	}

}
