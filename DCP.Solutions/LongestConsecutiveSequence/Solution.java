package LongestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

/**
 * HashSet
 * 
 * */

public class Solution {
	
	public int longestConsecutiveSequence(int[] a) {
		if(a == null || a.length == 0)
			return 0;
		
		Set<Integer> set = new HashSet<Integer>();
		for(int num : a)
			set.add(num);
		
		int maxLength = 0;
		
		for(int num : set) {
			// find the minimum value of a potential sequence
			if(!set.contains(num - 1)) {
				int current = num;
				int currentLength = 1;
				// find the whole sequence
				while(set.contains(current + 1)) {
					current++;
					currentLength++;
				}
				// choose the larger one
				maxLength = Math.max(maxLength, currentLength);
			}
		}
		
		return maxLength;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {100, 4, 200, 1, 3, 2, 99};
		Solution solution = new Solution();
		System.out.println(solution.longestConsecutiveSequence(a));
	}

}
