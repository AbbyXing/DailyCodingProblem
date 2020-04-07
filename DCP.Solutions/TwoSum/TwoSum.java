package TwoSum;

import java.util.*;

public class TwoSum {
	
	public TwoSum() {};
	
	public boolean twoSumSolution(int[] nums, int target) {
        if(nums == null || nums.length < 2) {
            return false;
        }
        Map<Integer, Integer> compensate = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            compensate.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++) {
            if(compensate.containsKey(target - nums[i]) && compensate.get(target - nums[i]) != i) {
                return true;
            }
        }
        return false;
    }

	public static void main(String[] args) {
		
		TwoSum twoSum = new TwoSum();
		
		// test case
		int[] a = new int[] {10, 15, 3, 7};
		int target = 17;
		
		// print result
		System.out.println(twoSum.twoSumSolution(a, target));
	}

}
