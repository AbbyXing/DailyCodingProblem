package FindAllAnagrams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Sliding Window
 * 
 * Hint: use int[26] to count the chars of the string
 * */

public class Anagrams {
	
	public static List<Integer> indicesOfAnagrams(String w, String s) {
		// special case
		if(w == null || s == null || w.length() == 0 || s.length() == 0
				|| w.length() > s.length())
			return null;
		
		List<Integer> result = new ArrayList<Integer>();
		int[] wcount = new int[26];
		for(char c : w.toCharArray())
			wcount[c - 'a']++;
		
		int size = w.length(); // window size
		for(int i = 0; i <= s.length() - size; i++) {
			// count the string in the window
			int[] count = new int[26];
			for(int j = i; j < i + size; j++) {
				count[s.charAt(j) - 'a']++;
			}
			// compare to w
			if(Arrays.equals(wcount, count))
				result.add(i);
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String w = "ab", s = "abxaba";
		System.out.println(Anagrams.indicesOfAnagrams(w, s));
	}

}
