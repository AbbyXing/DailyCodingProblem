package SubstringWithKDistictChar;

import java.util.HashSet;
import java.util.Set;

/**
 * Idea is to maintain a window and add elements to the window till it contains less or equal k, 
 * update our result if required while doing so. 
 * 
 * If unique elements exceeds than required in window, 
 * start removing the elements from left side.
 * */

public class SubstringWithKDistinctChars {
	
	public SubstringWithKDistinctChars() {}
	
	public int GetLength(int k, String s) {
		if(s == null || k <= 0)
			return 0;
		int start = 0, end = 0, maxLength = 0;
		Set<Character> set = new HashSet<>();
		for(int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			if(set.size() == k && !set.contains(c)) {
				String window = s.substring(start, end);
				Character a = s.charAt(start);
				start += window.lastIndexOf(a) + 1;
				window = window.substring(window.lastIndexOf(a));
				set.remove(a);
			}
			set.add(c);
			end++;
			if(end - start > maxLength)
				maxLength = end - start;
			//System.out.println(s.substring(start, end));
		}
		return maxLength;
	}

	public static void main(String[] args) {
		String s = "aabbcc";
		int k = 2;
		SubstringWithKDistinctChars solution = new SubstringWithKDistinctChars();
		System.out.println(solution.GetLength(k, s));
	}

}
