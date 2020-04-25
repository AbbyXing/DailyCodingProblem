package WordBreak;

/**
 * Dynamic Programming
 * 
 * dp[i] = dp[j] && dictionary.contains(substring(j, i))
 * 
 * dp[0] = true
 * 
 * If dp[length] = true, means can be reconstructed, return result list, otherwise return null.
 * */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	
	private List<String> result;
	
	public WordBreak() {
		result = null;
	}
	
	public List<String> GetSentence(Set<String> wordDictionary, String sentence) {
		if(sentence == null || wordDictionary == null)
			return null;
		result = new ArrayList<>();
		boolean[] dp = new boolean[sentence.length() + 1];
		dp[0] = true;
		for(int i = 1; i <= sentence.length(); i++) {
			for(int j = 0; j < i; j++) {
				if(wordDictionary.contains(sentence.substring(j, i)) && dp[j]) {
					dp[i] = true;
					//System.out.println(sentence.substring(j, i));
					result.add(sentence.substring(j, i));
					break;
				} else {
					dp[i] = false;
				}
			}
		}
		
		if(dp[sentence.length()])
			return result;
		
		return null;
	}

	public static void main(String[] args) {
		Set<String> dictionary = new HashSet<>();
		dictionary.add("quick");
		dictionary.add("brown");
		dictionary.add("the");
		dictionary.add("fox");
		
		WordBreak solution = new WordBreak();
		System.out.println(solution.GetSentence(dictionary, new String("thequickbrownfox")));
	}

}
