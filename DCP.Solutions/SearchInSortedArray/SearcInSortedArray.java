package SearchInSortedArray;

/**
 * Binary Search: O(log n) & Recursive
 * */

public class SearcInSortedArray {
	
	public int ReturnIndex(int[] a, int k, int left, int right) {
		// can't find k
		if(left > right)
			return -1;
		int mid = (left + right) / 2;
		
		if(a[mid] == k)
			return mid;
		
		// the left subarray is sorted
		if(a[left] <= a[mid]) {
			// if k is in the left subarray
			if(k >= a[left] && k < a[mid])
				return ReturnIndex(a, k, left, mid - 1);
			// k is in the right subarray
			else
				return ReturnIndex(a, k, mid + 1, right);
		}
		
		// the right subarray is sorted
		if(k > a[mid] && k <= a[right]) // if k is in the right subarray
			return ReturnIndex(a, k, mid + 1, right);
		else // k is in the left subarray
			return ReturnIndex(a, k, left, mid - 1);
	}

	public static void main(String[] args) {
		int[] a = {2, 3, 4, 5, 0, 1};
		SearcInSortedArray solution = new SearcInSortedArray();
		System.out.println(solution.ReturnIndex(a, 5, 0, a.length - 1));
	}

}
