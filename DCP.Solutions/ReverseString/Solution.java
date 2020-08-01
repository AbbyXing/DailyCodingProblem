package ReverseString;

public class Solution {
	
	public static String reverse(String s) {
		String[] array = s.split(" ");
		int n = array.length;
		for(int i = 0; i < n / 2; i++) {
			String temp = array[i];
			array[i] = array[n - 1 - i];
			array[n - 1 - i] = temp;
		}
		return String.join(" ", array);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "hello world here";
		System.out.println(Solution.reverse(s)); // "here world hello"
	}

}
