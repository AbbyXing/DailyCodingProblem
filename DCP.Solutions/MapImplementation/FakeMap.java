package MapImplementation;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import javafx.util.Pair;

public class FakeMap {
	
	Map<Integer, Queue<Pair<Integer, Integer>>> map; // Map<key, List<Pair<time, value>>>
	Comparator<Pair<Integer, Integer>> comparator;
	
	public FakeMap() {
		map = new HashMap<Integer, Queue<Pair<Integer,Integer>>>();
		
		// sort all pairs as an ascending order
		comparator = new Comparator<Pair<Integer,Integer>>() {
			@Override
	        public int compare(Pair<Integer,Integer> p1, Pair<Integer,Integer> p2) {
	        return p1.getKey() - p2.getKey();
	        }
		};
	}
	
	public void set(int key, int val, int time) {
		if(!map.containsKey(key)) {
			map.put(key, new PriorityQueue<Pair<Integer, Integer>>(comparator));
		}
		
		Queue<Pair<Integer, Integer>> list = map.get(key);
		for(Pair<Integer, Integer> p : list) {
			if(p.getKey() == time) {
				list.remove(p);
				break;
			}
		}
		
		Pair<Integer, Integer> newPair = new Pair<Integer, Integer>(time, val);
		list.add(newPair);
	}
	
	public Integer get(int key, int time) {
		if(!map.containsKey(key))
			return null;
		
		Queue<Pair<Integer, Integer>> list = map.get(key);
		Integer val = null;
		for(Pair<Integer, Integer> p : list) {
			if(p.getKey() <= time)
				val = p.getValue();
			else
				break;
		}
		
		return val;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FakeMap d = new FakeMap();
		d.set(1, 1, 0); // set key 1 to value 1 at time 0
		d.set(1, 2, 2); // set key 1 to value 2 at time 2
		//System.out.println();
		System.out.println(d.get(1, 1)); // get key 1 at time 1 should be 1
		System.out.println(d.get(1, 3)); // get key 1 at time 3 should be 2
		
		FakeMap d2 = new FakeMap();
		d2.set(1, 1, 5); // set key 1 to value 1 at time 5
		System.out.println(d2.get(1, 0)); // get key 1 at time 0 should be null
		System.out.println(d2.get(1, 10)); // get key 1 at time 10 should be 1
		
		FakeMap d3 = new FakeMap();
		d3.set(1, 1, 0); // set key 1 to value 1 at time 0
		d3.set(1, 2, 0); // set key 1 to value 2 at time 0
		System.out.println(d3.get(1, 0)); // get key 1 at time 0 should be 2
	}

}
