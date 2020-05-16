package SubsetSumProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Dynamic Programming/Recursive
 * 
 * */

public class SubsetSum {
	
	public List<Integer> GetTargetSubset(int[] a, int k) {
		
		// base case #1: can't find a solution, return null
		if(a.length == 0)
			return null;
		
		// base case #2: a[0] == k, return a list contains only a[0]
		if(a[0] == k) {
			List<Integer> list = new ArrayList<>();
			list.add(a[0]);
			return list;
		}
		
		// check if a[1:n] has a subset add up to k-a[0]
		List<Integer> first = GetTargetSubset(Arrays.copyOfRange(a, 1, a.length), k - a[0]);
		// a[1:n] has a subset add up to k-a[0],
		// then add a[0] to this found subset and return the result
		if(first != null) {
			first.add(a[0]);
			return first;
		} else {
			// a[1:n] doesn't have a subset add up to k-a[0],
			// then check if a[1:n] has a subset add up to k
			return GetTargetSubset(Arrays.copyOfRange(a, 1, a.length), k);
		}
	}

	public static void main(String[] args) {
		int[] a = {12, 1, 61, 5, 9, 2};
		int k = 24;
		SubsetSum solution = new SubsetSum();
		System.out.println(solution.GetTargetSubset(a, k));
	}

}
