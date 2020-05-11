package ThePowerSet;

/**
 * Binary, Operators (&, <<)
 * 
 * check if the ith bit of a number is equal to 1 (not 0): (counter & (1 << i)) > 0
 * 
 * 1 << i is 1 left shift by j(bit)
 * 
 * for example, if i = 2, then 1 << i is 00000010, if counter & 00000010 is 1, then the 2th bit of counter is 1
 * */

import java.util.ArrayList;
import java.util.List;

public class PowerSet {
	
	public List<List<Integer>> GetPowerSet(int[] a) {
		if(a == null || a.length == 0)
			return null;
		
		int n = a.length;
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> subset = new ArrayList<>();
		
		// get the size of the power size: 2^n
		double subset_size = Math.pow(2, n);
		
		for(int i = 0; i < subset_size; i++) {
			// clear subset
			subset.clear();
			for(int j = 0; j < n; j++) {
				// check if the ith bit of counter is equal to 1, if so, add a[j] to subset
				if((i & (1 << j)) > 0)
					subset.add(a[j]);
			}
			// add subset to power set
			result.add(new ArrayList<>(subset));
		}
		
		return result;
	}

	public static void main(String[] args) {
		int[] a = {1, 2, 3};
		PowerSet solution = new PowerSet();
		System.out.print( solution.GetPowerSet(a).toString());
	}

}
