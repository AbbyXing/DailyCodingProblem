package StringIsANumber;

/**
 * Double.parseDouble(String s)
 * 
 * NumberFormatException
 * 
 * */

public class Solution {
	
	public static boolean isNumeric(String s) {
		if(s == null)
			return false;
		try {
			double d = Double.parseDouble(s);
		} catch (NumberFormatException e) {
			// TODO: handle exception
			return false;
		}
		
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Solution.isNumeric("10"));
		System.out.println(Solution.isNumeric("-10"));
		System.out.println(Solution.isNumeric("10.1"));
		System.out.println(Solution.isNumeric("-10.1"));
		System.out.println(Solution.isNumeric("1e5"));
		
		System.out.println();
		
		System.out.println(Solution.isNumeric("a"));
		System.out.println(Solution.isNumeric("x 1"));
		System.out.println(Solution.isNumeric("a -2"));
		System.out.println(Solution.isNumeric("-"));
	}

}
