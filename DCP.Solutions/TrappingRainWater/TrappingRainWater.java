package TrappingRainWater;


/**
 * Dynamic Programming and pointers
 * 
 * 1. For each element:
 * 
 * 	find the highest left wall and the highest right wall
 * 
 * 	filling height = min(the highest left wall, the highest right wall) - current element's height
 * 
 *2. Use 2 pointers
 *	
 *	if max_left < max_right: left++
 *	if max_right < max_left: right--
 *
 *	!Important: if walls[left - 1] < walls[right + 1]: max_left < max_right
 * 
 * */

public class TrappingRainWater {
	
	public TrappingRainWater() {}
	
	public int GetResult(int[] walls) {
		int result = 0, max_left = 0, max_right = 0;
		int left = 1, right = walls.length - 2;
		for(int i = 1; i < walls.length - 1; i++) {
			if(walls[left - 1] < walls[right + 1]) { // max_left < max_right
				max_left = Math.max(max_left, walls[left - 1]);
				int min = max_left;
				if(min > walls[left])
					result += min - walls[left];
				left++;
			} else { // max_left > max_right
				max_right = Math.max(max_right, walls[right + 1]);
				int min = max_right;
				if(min > walls[right])
					result += min - walls[right];
				right--;
			}
		}
		
		return result;
	}

	public static void main(String[] args) {
		int[] walls = {3, 0, 1, 3, 0, 5};
		TrappingRainWater solution = new TrappingRainWater();
		System.out.println(solution.GetResult(walls));
	}

}
