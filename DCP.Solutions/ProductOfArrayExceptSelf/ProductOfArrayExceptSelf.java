package ProductOfArrayExceptSelf;

import java.util.Arrays;


public class ProductOfArrayExceptSelf {
	
	public ProductOfArrayExceptSelf() {}
	
	public int[] productExceptSelf(int[] nums) {
		if(nums == null)
			return null;
		
        int[] result = new int[nums.length];
        result[0] = 1;
        
        // left product
        for(int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        
        // right product
        int right = 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        
        return result;
    }

	public static void main(String[] args) {
		ProductOfArrayExceptSelf solution = new ProductOfArrayExceptSelf();
		int[] a = new int[] {1, 2, 3, 4};
		System.out.println(Arrays.toString(solution.productExceptSelf(a)));
	}

}
