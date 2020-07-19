package SubstringWithAllChars;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
	
	public String ShortestSubStirngWithAllChars(String s, Set<Character> set) {
		
		// count the numbers of existence for each character in the set
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		// record the first one and the last one
		int from = Integer.MAX_VALUE, to = Integer.MIN_VALUE;
		for(int i = 0; i < s.length(); i++) {
			if(set.contains(s.charAt(i))) {
				if(i < from)
					from = i;
				if(i > to)
					to = i;
				char c = s.charAt(i);
				if(!map.containsKey(c))
					map.put(c, 0);
				int count = map.get(c);
				count ++;
				map.put(c, count);
			}
		}
		
		// no substring contains all characters, return null
		if(map.size() < set.size())
			return null;
		
		// find the shortest substring -> shrink the window until can't
		while(true) {
			if(map.get(s.charAt(from)) == 1 && map.get(s.charAt(to)) == 1)
				break;
			while(map.get(s.charAt(from)) > 1) {
				int count = map.get(s.charAt(from));
				count--;
				map.put(s.charAt(from), count);
				from++;
				while(!set.contains(s.charAt(from)))
					from++;
			}
			while(map.get(s.charAt(to)) > 1) {
				int count = map.get(s.charAt(to));
				count--;
				map.put(s.charAt(to), count);
				to--;
				while(!set.contains(s.charAt(to)))
					to--;
			}
		}
		
		return s.substring(from, to + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "figehaeci";
		Set<Character> set = new HashSet<Character>();
		set.add('a');
		set.add('e');
		set.add('i');
		Solution solution = new Solution();
		System.out.println(solution.ShortestSubStirngWithAllChars(s, set));
	}

}
