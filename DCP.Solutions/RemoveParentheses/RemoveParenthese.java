package RemoveParentheses;

public class RemoveParenthese {
	
	public int remove(String s) {
		if(s == null || s.length() == 0)
			return 0;
		
		int count = 0, balance = 0;
		for(char c : s.toCharArray()) {
			if(c == '(')
				balance++;
			else if(c == ')')
				balance--;
			if(balance < 0) {
				count ++;
				balance = 0;
			}
		}
		
		count += Math.abs(balance);
		
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "()())()";
		String s2 = ")(";
		
		RemoveParenthese solution = new RemoveParenthese();
		System.out.println(solution.remove(s1));
		System.out.println(solution.remove(s2));
	}

}
