package TextJustification;

/**
 * This is a dumb question that teaches you to dealing with countless corner cases.
 * 
 * For each word in words list:
 * 
 * 1. Find the word's range for this line
 * 
 * 2. Justification
 * 	(1). Left justification: when there's only one word
 * 	(2). Middle justification: other cases
 * */

import java.util.ArrayList;
import java.util.List;

public class TextJustification {
	
	public TextJustification() {}
	
	public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        int start = 0, end = 0;
        while(start < words.length) {
        	int sum = words[start].length();
        	end = start + 1;
        	// pick words for this line: form index start to index end
        	while(end < words.length) {
        		if(words[end].length() + sum + 1 > maxWidth) // plus 1 for space
        			break;
        		sum += words[end].length() + 1;
        		end++;
        	}
        	// justification
        	StringBuilder line = new StringBuilder();
        	int range = end - start - 1;
        	// left justification: only one word
        	if(range == 0) {
        		line.append(words[start]);
        		for(int i = line.length(); i < maxWidth; i++)
        			line.append(" ");
        	}
        	// middle justification: other cases
        	else {
        		int space_num = (maxWidth - sum) / range; // the number of extra spaces should be appended after each word
        		int remain_space_num = (maxWidth - sum) % range; // first 'remain_space_num'th words should have one more space
        		for(int i = start; i < end; i++) {
        			line.append(words[i]); // add the word
        			if(i < end - 1) {
        				line.append(" "); // add one space right after the word
        				for(int j = 0; j < space_num; j++)
            				line.append(" ");
            			if(i - start < remain_space_num)
            				line.append(" ");
        			}
        		}
        	}
        	
        	result.add(line.toString());
        	start = end;
        }
        
        return result;
    }

	public static void main(String[] args) {
		String[] words = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
		int maxWidth = 16;
		TextJustification solution = new TextJustification();
		List<String> result = solution.fullJustify(words, maxWidth);
		for(String s: result)
			System.out.println(s);
	}

}
