package MinStepIn2DGrid;

public class Solution {
	
	public int minStep(int[][] points) {
		if(points == null || points.length <= 1)
			return 0;
		int step = 0;
		int from_x = points[0][0];
		int from_y = points[0][1];
		for(int i = 1; i < points.length; i++) {
			int to_x = points[i][0];
			int to_y = points[i][1];
			
			step += Math.max(Math.abs(to_x - from_x), Math.abs(to_y - from_y));
			
			from_x = to_x;
			from_y = to_y;
		}
		
		return step;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] points = {{0,0},{1,1},{1,2}};
		Solution solution = new Solution();
		System.out.println(solution.minStep(points));
	}

}
