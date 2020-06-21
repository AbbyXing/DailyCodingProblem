package MergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class MergeIntervals {
	
	public ArrayList<int[]> merge(int[][] a) {
		if(a == null || a.length == 0)
			return null;
		ArrayList<int[]> merged = new ArrayList<int[]>();
		Arrays.sort(a, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});
		merged.add(a[0]);
		for(int i = 1; i < a.length; i++) {
			if(a[i][0] <= a[i - 1][1])
				merged.get(merged.size() - 1)[1] = Math.max(a[i][1], a[i - 1][1]);
			else
				merged.add(a[i]);
		}
		
		return merged;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] a = {{1,3},{4,10},{5,8},{20,25}};
		MergeIntervals solution = new MergeIntervals();
		for(int[] i : solution.merge(a)) {
			System.out.println(Arrays.toString(i));
		}
	}

}
