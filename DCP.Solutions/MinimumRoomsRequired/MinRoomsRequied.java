package MinimumRoomsRequired;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/***
 * 1. Sort the meetings by start time
 * 2. Use a priority queue to record the end time of class that is being taught right now
 * 	(in priority queue larger number will have higher priority)
 * 3. For each class c, if the last time in priority queue is smaller than the start time of c,
 * 	then no need to assign extra room for c, otherwise assign a new room for c
 */

public class MinRoomsRequied {
	
	private int[][] _classes;
	
	public MinRoomsRequied(int[][] classes) {
		Arrays.sort(classes, Comparator.comparing((int[] c) -> c[0]));
		this._classes = classes;
	}
	
	public int GetMinRoomsNum() {
		if(_classes == null)
			return 0;
		int time, n = _classes.length, result = 0;
		PriorityQueue<Integer> teaching = new PriorityQueue<>();
		int i = 0;
		while(i < n) {
			time = _classes[i][0];
			if(teaching.isEmpty())
				result++;
			else {
				if(teaching.peek() < time)
					teaching.poll();
				else
					result++;
			}
			
			teaching.offer(_classes[i][1]);
			i++;
		}
		
		return result;
	}

	public static void main(String[] args) {
		int[][] classes = {{30, 75}, {0, 50}, {60, 150}};
		MinRoomsRequied solution = new MinRoomsRequied(classes);
		System.out.println(solution.GetMinRoomsNum());
	}

}
