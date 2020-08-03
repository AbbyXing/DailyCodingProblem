package SquareAndSortTheArray;

import java.util.Arrays;

public class Solution {
	
	public static int[] squareAndSort(int[] a) {
		for(int i = 0; i < a.length; i++)
			a[i] = (int)Math.pow(a[i], 2);
		
		Arrays.sort(a);
		
		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {-9, -2, 0, 2, 3};
		System.out.println(Arrays.toString(Solution.squareAndSort(a))); // [0, 4, 4, 9, 81]
	}

}
