package RunLengthEncoding;

public class RunLengthEncoding {
	
	public RunLengthEncoding() {}
	
	public String GetEncodedString(String s) {
		StringBuilder result = new StringBuilder();
		int count = 1;
		char c = s.charAt(0);
		for(int i = 1; i < s.length(); i++) {
			if(s.charAt(i) == c) {
				count++;
			} else {
				result.append(count);
				result.append(c);
				count = 1;
				c = s.charAt(i);
			}
		}
		result.append(count);
		result.append(c);
		
		return result.toString();
	}

	public static void main(String[] args) {
		String s = "AAAABBBCCDAA";
		RunLengthEncoding solution = new RunLengthEncoding();
		System.out.println(solution.GetEncodedString(s));
	}

}
