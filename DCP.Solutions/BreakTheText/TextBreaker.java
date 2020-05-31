package BreakTheText;

/**
 * This is a problem that needs to consider many and many situations!
 * */

import java.util.ArrayList;
import java.util.Arrays;

public class TextBreaker {
	
	public String[] Break(String s, int k) {
		if(s == null || k <= 0)
			return null;
		ArrayList<String> result = new ArrayList<>();
		while(!s.isEmpty()) {
			int index = s.indexOf(' ');
			String temp = "";
			if(index != -1) {
				int count = index + 1;
				while(count <= k + 1) {
					temp += s.substring(0, index) + " ";
					s = s.substring(index + 1);
					index = s.indexOf(' ');
					if(index != -1)
						count += index + 1;
					else
						break;
				}
			}
			// reach the last word in the text
			else {
				if(s.length() > k)
					return null;
				else if(result.get(result.size() - 1).length() + 1 + s.length() <= k) {
					result.set(result.size() - 1, result.get(result.size() - 1) + " " + s);
					return result.toArray(new String[0]);
				}
				else {
					result.add(s);
					return result.toArray(new String[0]);
				}
			}
			
			if(temp.equals(""))
				return null;
			
			result.add(temp.substring(0, temp.length() - 1));
		}
		
		return result.toArray(new String[0]);
	}

	public static void main(String[] args) {
		String s = "the quick brown fox jumps over the lazy dog";
		TextBreaker textBreaker = new TextBreaker();
		System.out.println(Arrays.toString(textBreaker.Break(s, 8)));
	}

}
