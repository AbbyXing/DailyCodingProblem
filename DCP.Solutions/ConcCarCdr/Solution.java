package ConcCarCdr;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Solution {
	
/** Python solution: 
	
//	def cons(a, b):
//	    def pair(f):
//	        return f(a, b)
//	    return pair
	
//	def car(pair):
//	    def return_first(a, b):
//	        return a
//	    return pair(return_first)
//
//	def cdr(pair):
//	    def return_last(a, b):
//	        return b
//	    return pair(return_last)
**/
	
	
	
/** 
 * Java Solution
**/
	public Solution() {}
	
	// def cons(a, b)
	public static<T, U, R> Function<BiFunction<T, U, R>, R> cons(T a, U b) {
		
		// def pair(f)
		Function<BiFunction<T, U, R>, R> pair;
		
		// return f(a, b)
		pair = f -> f.apply(a, b);
		
		// return pair
		return pair;
	}
	
	public static<T, U> T car(Function<BiFunction<T, U, T>, T> pair) {
		
		// return pair(return_first(a, b))
		return pair.apply((a, b) -> a);
		
		// p.s., return first(a, b) = a
	}
	
	public static<T, U> U cdr(Function<BiFunction<T, U, U>, U> pair) {
		
		// return pair(return_last(a, b))
		return pair.apply((a, b) -> b);
		
		// p.s., return_last(a, b) = b
	}

	public static void main(String[] args) {
		
		Solution solution = new Solution();
		System.out.println(solution.car(cons(2,3)));
		System.out.println(solution.cdr(cons(2,3)));
	}

}
