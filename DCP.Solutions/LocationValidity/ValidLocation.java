package LocationValidity;

import java.util.HashMap;
import java.util.Map;

public class ValidLocation {
	
	private static int[][] directs = {{0,1},
									  {1,1},
									  {1,0},
									  {1,-1},
									  {0,-1},
									  {-1,-1},
									  {-1,0},
									  {-1,1}};
	private Map<String, Integer> nswe = new HashMap<String, Integer>();
	
	public ValidLocation() {
		nswe.put("N", 0);
		nswe.put("NE", 1);
		nswe.put("E", 2);
		nswe.put("SE", 3);
		nswe.put("S", 4);
		nswe.put("SW", 5);
		nswe.put("W", 6);
		nswe.put("NW", 7);
	}
	
	public boolean validCheck(String[] rules) {
		Map<String, int[]> coords = new HashMap<String, int[]>();
		
		for(String rule : rules) {
			String[] split = rule.split(" ");
			String from = split[2], to = split[0], direct = split[1];
			
			// if not contained, create new coord
			if(!coords.containsKey(from)) {
				int[] coord = {0, 0};
				coords.put(from, coord);
			}
			
			// get source coord
			int from_x = coords.get(from)[0];
			int from_y = coords.get(from)[1];
			
			// locate distance
			int loc_x = directs[nswe.get(direct)][0];
			int loc_y = directs[nswe.get(direct)][1];
			
			// calculate destination coord
			int to_x = from_x + loc_x;
			int to_y = from_y + loc_y;
			
			// check validity
			
			// if destination not contained, create new
			if(!coords.containsKey(to)) {
				int[] coord = {to_x, to_y};
				coords.put(to, coord);
				continue;
			}
			
			// if destination exists, check validity
			int prev_x = coords.get(to)[0];
			int prev_y = coords.get(to)[1];
			
			if((prev_x != to_x) && (prev_y != to_y))
				return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] rules = {"A N B", "B NE C", "C N A"};
		ValidLocation solution = new ValidLocation();
		System.out.println(solution.validCheck(rules));
		String[] rules2 = {"A NW B", "A N B"};
		System.out.println(solution.validCheck(rules2));
		String[] rules3 = {"A N B", "A N C", "A N D", "B N C", "B S A"};
		System.out.println(solution.validCheck(rules3));
	}

}
