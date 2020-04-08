package FirstMissingPositive;

import java.util.Arrays;

public class Solution {
	
	public Solution() {};
	
	/** Hint: use array itself as a hash table: attempt to put every positive integer
	as position that has index "value - 1" **/
	
    public int firstMissingPositive(int[] nums) {
        // check whether 1 is contained
        boolean containsOne = false;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                containsOne = true;
                break;
            }
        }
        // if 1 is not contained, return 1
        if(!containsOne)
            return 1;

        // if nums = [1], return 2
        if(Arrays.equals(nums, new int[] {1}))
            return 2;

        // clean the data: filter out non positive and bigger than n
        int n = nums.length;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        // use array itself as a hash table: swap nums[i] to index "nums[i] - 1" if can
        int i = 0;
        while(i < n) {
            int val = nums[i];
            // if nums[val - 1] is already val, skip this swapping
            if(i + 1 != val && nums[val - 1] != val) {
            	// swap
            	nums[i] = nums[val - 1];
            	nums[val - 1] = val;
            	continue;
            }
            i++;
        }
        
        // loop through the hash table and find the first non-exist integer
        int result = n + 1;
        for(i = 0; i < nums.length; i++) {
        	if(nums[i] != i + 1) {
        		result = i + 1;
        		break;
        	}
        }
        
        return result;
    }

	public static void main(String[] args) {
		int[] a = new int[] {0, -1, 3, 1};
		Solution solution = new Solution();
		System.out.println(solution.firstMissingPositive(a));

	}

}
