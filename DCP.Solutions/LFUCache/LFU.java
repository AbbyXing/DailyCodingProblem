package LFUCache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;

import LRUCache.Node;

/**
 * How to get the least frequency? - TreeMap can get the first key (the min key)
 * 
 * Hashmap: get() is O(1)
 * Linkedlist: node adding and removal are O(1)
 * 
 * 与HashMap相比，TreeMap是一个能比较元素大小的Map集合，会对传入的key进行了大小排序。
 * 其中，可以使用元素的自然顺序，也可以使用集合中自定义的比较器来进行排序；
 * 
 * */

public class LFU {
	
	private int capacity, count;
	private HashMap<Integer, Node> cache; // <index, Pair<value, frequency>>
	private TreeMap<Integer, LinkedList<Integer>> frequency; // <frequency, List<index>>
	
	public LFU(int c) {
		capacity = c;
		count = 0;
		cache = new HashMap<>();
		frequency = new TreeMap<>();
	}
	
	public void set(int index, int value) {
		
		// if the key exists - update the value and add frequency
		if(cache.containsKey(index)) {
			// update value
			cache.get(index).value = value;
			// add frequency
			addFreq(index);
			System.out.println("update (" + index + ", " + value + ")");
		}
		else {
			// the key doesn't exist
			// havn't reach the capacity, create and add the new element
			if(count < capacity) {
				System.out.println("add (" + index + ", " + value + ")");
				addNew(index, value);
				count++;
			}
			// reached the capacity, remove the least frequency element and add the new one
			else {
				// remove old element
				int min_f = frequency.firstKey();
				int remove_index = frequency.get(min_f).poll();
				if(frequency.get(min_f).isEmpty())
					frequency.remove(min_f);
				cache.remove(remove_index);
				System.out.println("remove index " + remove_index);
				
				// add new element
				System.out.println("add (" + index + ", " + value + ")");
				addNew(index, value);
			}
		}
	}
	
	public Integer get(int index) throws Exception {
		
		// index exists, return the value
		if(cache.containsKey(index)) {		
			// add frequency
			addFreq(index);	
			// return value
			System.out.println("get (" + index + ", " + cache.get(index).value + ")");
			return cache.get(index).value;
		}
		// index doesn't exist, return null
		System.out.println("null");
		return null;
	}
	
	// helper function: add frequency
	private void addFreq(int index) {
		
		int f = cache.get(index).freq;
		frequency.get(f).remove(Integer.valueOf(index));
		if(frequency.get(f).isEmpty())
			frequency.remove(f);
		if(!frequency.containsKey(f + 1))
			frequency.put(f + 1, new LinkedList<Integer>());
		frequency.get(f + 1).addFirst(index);
		cache.get(index).freq++;
	}
	
	private void addNew(int index, int value) {
		cache.put(index, new Node(value));
		if(!frequency.containsKey(1))
			frequency.put(1, new LinkedList<Integer>());
		frequency.get(1).addFirst(index);
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		LFU cache = new LFU(3);
		cache.get(1);
		cache.set(1, 1);
		cache.set(2, 2);
		cache.set(3, 3);
		cache.get(2);
		cache.set(3, 13);
		cache.set(4, 4);
	}

}
