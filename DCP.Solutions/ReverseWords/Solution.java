package ReverseWords;

/**
 * Split String
 * 
 * */

import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public static String reverse(String s) {
		List<String> delimiters = new ArrayList<String>();
		
		// split
		String[] words = s.split("//|:|/"); // split if there is "//" or ";" or "/"
		
		// find delimiters
		int i = 0;
		while(i < s.length()) {
			if(!Character.isLetter(s.charAt(i))) {
				int j = i;
				while(j < s.length() && !Character.isLetter(s.charAt(j))) {
					j++;
				}
				delimiters.add(s.substring(i, j));
				i = j + 1;
			}
			else
				i++;
		}
		
		// reverse
		for(int k = 0; k < words.length / 2; k++) {
			String temp = words[k];
			words[k] = words[words.length - 1 - k];
			words[words.length - 1 - k] = temp;
		}
		
		// join
		StringBuffer result = new StringBuffer();
		for(int k = 0; k < words.length; k++) {
			result.append(words[k]);
			if(k < delimiters.size())
				result.append(delimiters.get(k));
		}
		if(delimiters.size() > words.length)
			result.append(delimiters.get(delimiters.size() - 1));
		
		return result.toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "hello/world:here/";
		System.out.println(Solution.reverse(s)); // "here/world:hello/"
		s = "hello//world:here";
		System.out.println(Solution.reverse(s)); // "here//world:hello"
	}

}
