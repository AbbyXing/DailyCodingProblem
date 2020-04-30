package BalancedBrackets;

import java.util.Stack;

/**
 * Stack
 * 
 * For each char c in string s:
 * 
 * 1. If c = '(' or '[' or '{' -> then push ')' or ']' or '}'
 * 
 * 2. If c = ')' or ']' or '}' -> then pop
 * 
 * 3. If stack is always not empty and valid while pop, and is empty after scanning of s, then s is valid
 * 
 * */

public class BalancedBrackets {
	
	public BalancedBrackets() {}
	
	public boolean IsBalanced(String s) {
		Stack<Character> stack = new Stack<>();
		for(char c: s.toCharArray()) {
			if(c == '(')
				stack.push(')');
			else if(c == '[')
				stack.push(']');
			else if(c == '{')
				stack.push('}');
			else {
				if(stack.isEmpty() || stack.pop() != c)
					return false;
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		String s = "([])[]({})";
		BalancedBrackets solution = new BalancedBrackets();
		System.out.println(solution.IsBalanced(s));
	}

}
