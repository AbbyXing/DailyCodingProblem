package SetCoverAllIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
	
	public static List<Integer> getResult(int[][] a) {
		if(a == null || a.length == 0)
			return null;
		
		// sort all intervals by the end value
		Arrays.sort(a, new Comparator<int[]>() {
			public int compare(int[] a1, int[] a2) {
				return a1[1] - a2[1];
			}
		});
		
		List<Integer> result = new ArrayList<Integer>();
		result.add(a[0][1]);
		
		for(int i = 1; i < a.length; i++) {
			int last = result.get(result.size() - 1);
			// if it's in range, skip this interval
			if(last >= a[i][0] && last <= a[i][1])
				continue;
			else {
				result.add(a[i][1]);
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {{0,3},{2,6},{3,4},{6,9}};
		System.out.println(Solution.getResult(a));
	}

}
