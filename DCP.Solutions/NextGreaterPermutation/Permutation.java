package NextGreaterPermutation;

import java.util.Arrays;

public class Permutation {
	
	/**
	 * The greatest number should be a descending order
	 * 
	 * */
	
	public int[] next(int[] a) {
		// Traverse from right and find the first item that is not following the descending order.
		int n = a.length;
		int i = n - 2;
		while(i >= 0) {
			if(a[i] < a[i + 1])
				break;
			i--;
		}
		if(i < 0) // already descending
			Arrays.sort(a); // return the smallest value (ascending order)
		else {
			// Swap the found value with closest greater (or smallest greater) element on right side of it.
			// find the smallest greater element
			int[] sub = Arrays.copyOfRange(a, i + 1, n);
			int smallestId = minId(sub) + (i + 1);
			// swap it with i
			a = swap(a, i, smallestId);
			
			// After swapping, sort the string after the position of character found in step a.
			Arrays.sort(a, i + 1, n);
		}
		
		return a;
	}
	
	public int minId(int[] a) {
		int min = Integer.MAX_VALUE, id = 0;
		for(int i = 0; i < a.length; i++) {
			if(a[i] < min) {
				min = a[i];
				id = i;
			}
		}
		
		return id;
	}
	
	public int[] swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		
		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,5,4,3};
		
		Permutation permutation = new Permutation();
		System.out.println(Arrays.toString(permutation.next(a))); // [1,3,2,4,5]
	}

}
