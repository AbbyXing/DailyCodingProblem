package RandomNumExcldLIst;

/**
 * Binary Search
 * 
 * */

import java.util.Arrays;
import java.util.Random;

public class NumGenerator {

	public Integer generate(int n, int[] a) {
		if(n <= 0 || a.length >= n)
			return null;
		
		Arrays.sort(a);
		
		int n1 = n - a.length;
		Random r = new Random();
		int index = r.nextInt(n1) + 1;
		//System.out.println("index: " + index);
		
		// binary search
		int i = a.length / 2, min = 0, max = a.length;
		while(min < max) {
			int miss = a[i] - i;
			if(miss > i)
				max = i;
			else if(miss < i)
				min = i;
			else
				break;
			i = (min + max) / 2;
		}
		
		int miss = a[i] - i;
		if(miss > index) {
			i--;
			miss = a[i] - i;
		}
		//System.out.println("i: " + i);
		
		//System.out.println("result: " + (a[i] + (index - miss)));
		return a[i] + (index - miss);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 7;
		int[] a = {0, 1, 4};
		NumGenerator obj = new NumGenerator();
		double sum = 0, count = 0;
		for(int i = 0; i < 1000; i++) {
			int num = obj.generate(n, a);
			//System.out.println(num);
			if(num == 6)
				count++;
			sum++;
		}
		System.out.println(count / sum);
	}

}
