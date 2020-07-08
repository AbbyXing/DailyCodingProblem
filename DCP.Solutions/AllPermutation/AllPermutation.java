package AllPermutation;

import java.util.Arrays;

public class AllPermutation {
	
	/**
	 * Backtracking
	 * 
	 * */
	
	public void permutation(int[] a, int start, int end) {
		if(start == end)
			System.out.println(Arrays.toString(a));
		for(int i = start; i <= end; i++) {
			a = swap(a, start, i);
			permutation(a, start + 1, end);
			a = swap(a, start, i); // swap back to root node
		}
	}
	
	private int[] swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3};
		AllPermutation allPermutation = new AllPermutation();
		allPermutation.permutation(a, 0, a.length - 1);
	}

}
