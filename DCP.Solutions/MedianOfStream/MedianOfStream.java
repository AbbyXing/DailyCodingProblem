package MedianOfStream;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Cited from https://www.geeksforgeeks.org/median-of-stream-of-running-integers-using-stl/:
 * 
 * Create two heaps.
 * One max heap to maintain elements of lower half
 * and one min heap to maintain elements of higher half at any point of time..
 * Take initial value of median as 0.
 * 
 * For every newly read element, insert it into either max heap or min heap and calculate the median based on the following conditions:
 * If the size of max heap is greater than size of min heap and the element is less than previous median
 * then pop the top element from max heap and insert into min heap and insert the new element to max heap else insert the new element to min heap. Calculate the new median as average of top of elements of both max and min heap.
 * If the size of max heap is less than size of min heap and the element is greater than previous median
 * then pop the top element from min heap and insert into max heap and insert the new element to min heap else insert the new element to max heap. Calculate the new median as average of top of elements of both max and min heap.
 * 
 * If the size of both heaps are same.
 * Then check if current is less than previous median or not.
 * If the current element is less than previous median
 * then insert it to max heap and new median will be equal to top element of max heap.
 * If the current element is greater than previous median
 * then insert it to min heap and new median will be equal to top element of min heap.
 * */

public class MedianOfStream {
	
	public MedianOfStream() {}
	
	public void PrintMedian(int[] numbers) {
		double median = numbers[0];
		System.out.println(median);
		// 如果不提供Comparator的话，优先队列中元素默认按自然顺序排列，也就是数字默认是小的在队列头
		PriorityQueue<Integer> min_heap = new PriorityQueue<>(Collections.reverseOrder()), max_heap = new PriorityQueue<>();
		min_heap.add(numbers[0]);
		for(int i = 1; i < numbers.length; i++) {
			int number = numbers[i];
			if(min_heap.size() > max_heap.size()) {
				if(number < median) {
					max_heap.add(min_heap.remove());
					min_heap.add(number);
				} else {
					max_heap.add(number);
				}
				median = (double)(min_heap.peek() + max_heap.peek()) / 2;
			} else if(min_heap.size() < max_heap.size()) {
				if(number > median) {
					min_heap.add(max_heap.remove());
					max_heap.add(number);
				} else {
					min_heap.add(number);
				}
				median = (double)(min_heap.peek() + max_heap.peek()) / 2;
			} else { // min.size = max.size
				if(number > median) {
					max_heap.add(number);
					median = (double)max_heap.peek();
				} else {
					min_heap.add(number);
					median = (double)min_heap.peek();
				}
			}
			System.out.println(median);
		}
	}

	public static void main(String[] args) {
		int[] numbers = {2, 1, 5, 7, 2, 0, 5};
		MedianOfStream solution = new MedianOfStream();
		solution.PrintMedian(numbers);
	}

}
