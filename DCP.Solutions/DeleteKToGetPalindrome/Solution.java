package DeleteKToGetPalindrome;

/**
 * The task is to transform the given string into its reverse by 
 * removing at most K characters from it.
 * 
 * 
 * */

public class Solution {
	
	public static boolean kPalindrome(String s, int k) {
		String rev = reverseString(s);
		
		return (palindrome(s, rev, s.length(), rev.length()) <= 2 * k);
	}
	
	// a recursive function which calculates how many characters should be move to make s a palindrome
	private static int palindrome(String s, String rev, int m, int n) {
		
		// s is empty -> remove all characters in rev
		if(m == 0)
			return n;
		
		// rev is empty -> remove all characters in s
		if(n == 0)
			return m;
		
		// last character are same -> m-- and n--
		if(s.charAt(m - 1) == rev.charAt(n - 1))
			return palindrome(s, rev, m - 1, n - 1);
		
		// last character are not same -> remove last character from s or rev (take the min)
		return 1 + Math.min(palindrome(s, rev, m - 1, n), palindrome(s, rev, m, n - 1));
	}
	
	private static String reverseString(String s) {
		
		return new StringBuffer(s).reverse().toString();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "waterrfetawx";
		System.out.println(Solution.kPalindrome(s, 2));
		System.out.println(Solution.kPalindrome(s, 1));
	}

}
