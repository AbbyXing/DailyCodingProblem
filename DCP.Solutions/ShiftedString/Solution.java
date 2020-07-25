package ShiftedString;

public class Solution {
	
	public boolean shiftable(String a, String b) {
		// special cases
		if((a == null && b == null) || a.equals(b))
			return true;
		if(a.length() != b.length())
			return false;
		
		int n = a.length();
		
		for(int i = 0; i < n; i++) {
			// shift string A
			String first = String.valueOf(a.charAt(0));
			a = a.substring(1);
			a += first;
			if(a.equals(b))
				return true;
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		String a = "asdfg", b = "dfgas";
		System.out.println(solution.shiftable(a, b));
		b = "dfgsa";
		System.out.println(solution.shiftable(a, b));
	}

}
