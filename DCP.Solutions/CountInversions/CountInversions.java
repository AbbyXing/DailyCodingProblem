package CountInversions;

import java.util.Arrays;

/**
 * Divide and Conquer: 
 * recursively breaking down a problem into two or more 
 * sub-problems of the same or related type, until these become simple enough 
 * to be solved directly.
 * 
 * 1, divide the array into two halves in each step until the base case is reached.
 * 
 * 2. Create a function merge that counts the number of inversions 
 * when two halves of the array are merged
 * 
 * 3. Create a recursive function to divide the array into halves and find 
 * the answer
 * 
 * 4. Base case: when there is only one element in the given half.
 * */

public class CountInversions {
	
	public int GetResult(int[] a, int left, int right) {

		// base case: result = 0 if there is only one element in the subarray
		int result = 0;
		
		if(left < right) {
			int mid = (left + right) / 2;
			
			// count left half
			result += GetResult(a, left, mid);
			
			// count right half
			result += GetResult(a, mid + 1, right);
			
			// count merge
			result += Merge(a, left, mid, right);
		}
		
		return result;
	}
	
	// count the number of inversions caused by merging
	private int Merge(int[] a, int left, int mid, int right) {
		// get two halves
		int[] left_half = Arrays.copyOfRange(a, left, mid + 1);
		int[] right_half = Arrays.copyOfRange(a, mid + 1, right + 1);
		
		int i = 0, j = 0, k = left, inversions = 0;
		
		// compare, sort and count merge inversions
		while(i < left_half.length && j < right_half.length) {
			// left[i] > right[j]
			if(left_half[i] > right_half[j]) {
				// count inversions
				// if a[i] is greater than a[j], 
				// then there are (mid – i) inversions.
				inversions += (mid + 1) - i - left;
				// sort and store in array(choose the smaller one)
				a[k] = right_half[j];
				k++;
				j++;
			} else { // left[i] <= right[j]
				// no extra inversions so do nothing
				
				// sort and store in array(choose the smaller one)
				a[k] = left_half[i];
				k++;
				i++;
			}
		}
		
		// finish the rest storage (note: left and right subarray are both sorted)
		while(i < left_half.length)
			a[k++] = left_half[i++];
		while(j < right_half.length)
			a[k++] = right_half[j++];
		
		return inversions;
	}

	public static void main(String[] args) {
		int[] a = {2, 4, 1, 3, 5};
		CountInversions solution = new CountInversions();
		System.out.println(solution.GetResult(a, 0, a.length - 1));
	}

}
