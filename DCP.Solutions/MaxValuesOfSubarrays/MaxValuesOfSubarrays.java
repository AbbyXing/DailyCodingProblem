package MaxValuesOfSubarrays;

import java.util.ArrayDeque;

/**
 * Deque<E>: A linear collection that supports element insertion and removal at both ends.
 * 
 * Methods (all of these costs O(1)):
 * 	peek() - return the head
 * 	peekLast()
 * 	poll() - remove the head
 * 	pollLast()
 * 	offer() - insert to the end
 * 
 * 1) Define a Deque to record elements' index
 * 
 * 2) For each a[i], do the following to Deque:
 * 	1. Remove elements that are out of range;
 * 	2. Remove elements that are smaller than a[i];
 * 	3. Add i;
 * 	4. Print out the head element of Deque;
 * */

import java.util.Deque;

public class MaxValuesOfSubarrays {
	
	private int[] array;
	private Deque<Integer> deque;
	
	public MaxValuesOfSubarrays(int[] a) {
		this.array = a;
		this.deque = new ArrayDeque<>();
	}
	
	public void PrintMaxValuesOfSubarrays(int k) {
		for(int i = 0; i < array.length; i++) {
			while(!deque.isEmpty() && deque.peek() < i - k + 1) // Remove out of range elements
				deque.poll();
			while(!deque.isEmpty() && array[deque.peek()] < array[i]) // Remove elements smaller than a[i]
				deque.poll();
			deque.offer(i); // Insert at the end
			// Start printing from index k - 1
			if(i >= k - 1)
				System.out.print(array[deque.peek()] + " ");
		}
	}

	public static void main(String[] args) {
		int[] a = {1,3,-1,-3,5,3,6,7};
		MaxValuesOfSubarrays solution = new MaxValuesOfSubarrays(a);
		solution.PrintMaxValuesOfSubarrays(3);
	}

}
