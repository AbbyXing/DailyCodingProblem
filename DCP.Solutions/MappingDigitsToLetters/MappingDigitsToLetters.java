package MappingDigitsToLetters;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Backtracking
 * 
 * */

public class MappingDigitsToLetters {
	
	private ArrayList<String> result = new ArrayList<String>();
	
	public ArrayList<String> mapping(String digits, Map<Integer, String[]> dict) {
		if(dict == null || dict.isEmpty() || digits == null | digits.length() == 0)
			return null;
		mapHelper("", digits, dict);
		
		return result;
	}
	
	public void mapHelper(String combine, String digits, Map<Integer, String[]> dict) {
		// if there is no more digits to check
		if(digits.length() == 0)
			result.add(combine); // the combination is done
		// if there are still digits to check
		else {
			// iterate over all letters which map the next available digit
			int digit = Integer.valueOf(digits.substring(0, 1));
			String[] letters = dict.get(digit);
			for(String letter : letters) {
				// Backtracking!
				// append the current letter to the combination and proceed to the next digits
				mapHelper(combine + letter, digits.substring(1) , dict);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<Integer, String[]> dict = new HashMap<Integer, String[]>();
		dict.put(2, new String[] {"a", "b", "c"});
		dict.put(3, new String[] {"d", "e", "f"});
		
		MappingDigitsToLetters solution = new MappingDigitsToLetters();
		System.out.println(solution.mapping("23", dict));
	}
}
