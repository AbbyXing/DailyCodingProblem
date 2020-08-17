package HitCounter;

import java.util.HashMap;
import java.util.Map;

public class HitCounter {
	
	private Map<Integer, Integer> hitMap;
	private int totalHits;
	
	public HitCounter() {
		hitMap = new HashMap<Integer, Integer>();
		totalHits = 0;
	}
	
	public void record(int timestamp) {
		if(!hitMap.containsKey(timestamp))
			hitMap.put(timestamp, 1);
		else {
			int hits = hitMap.get(timestamp);
			hits++;
			hitMap.put(timestamp, hits);
		}
		
		totalHits++;
	}
	
	public int total() {
		
		return this.totalHits;
	}
	
	public int range(int lower, int upper) {
		
		int sum = 0;
		
		for(int i = lower; i <= upper; i++) {
			if(hitMap.containsKey(i))
				sum += hitMap.get(i);
		}
		
		return sum;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HitCounter hitCounter = new HitCounter();
		System.out.println(hitCounter.total());
		hitCounter.record(1);
		hitCounter.record(2);
		hitCounter.record(3);
		hitCounter.record(3);
		hitCounter.record(4);
		System.out.println(hitCounter.total());
		System.out.println(hitCounter.range(1, 3));
	}

}
