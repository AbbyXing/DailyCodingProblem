package FixAnonymousFunc;

/**
 * Python Lexico Closure Property
 * */

public class Solution {
	
	/**
	 * The original function print 10 "9" instead of 0 to 9
	 * 
	 * 
	 * Solution:
	 * 
	 * functions = []
	   for i in range(10):
       		functions.append(lambda i = i: i)
	   for f in functions:
       		print(f())
	 * */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
