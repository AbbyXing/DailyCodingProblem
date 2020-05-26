package LRUCache;

import java.util.HashMap;
import java.util.LinkedList;

import javafx.util.Pair;

/**
 * Double Linked List, HashMap
 * 
 * Double linked list enables us to quickly move nodes.
 * 
 * The LRU cache is a hash map of keys and double linked nodes. 
 * 
 * The hash map makes the time of get() to be O(1). 
 * The list of double linked nodes make the nodes adding/removal operations O(1).
 * */

public class LRUCache {
	
	private int capacity, count;
	private HashMap<Integer, Pair<Integer, Integer>> map;
	private LinkedList<Pair<Integer, Integer>> list;
	
	public LRUCache(int c) {
		capacity = c;
		count = 0;
		map = new HashMap<>();
		list = new LinkedList<>();
	}
	
	public void set(int k, int v) {
		// if the key exists - update the value and set it to recently used
		if(map.get(k) != null) {
			Pair<Integer, Integer> p = map.get(k);
			list.remove(p);
			list.addFirst(new Pair<Integer, Integer>(k, v));
		}
		// key not exists - create a new one
		else {
			Pair<Integer, Integer> p = new Pair<Integer, Integer>(k, v);
			map.put(k, p);
			
			if(count < capacity) {
				list.addFirst(p);
				count++;
				System.out.println("Add pair(" + k + ", " + v + ")");
			}else {
				int k_remove = list.getLast().getKey();
				int v_remove = list.getLast().getValue();
				
				System.out.println("Remove pair(" + k_remove + ", " + v_remove + ")");
				list.removeLast();
				map.remove(k_remove);
				
				list.addFirst(p);
				System.out.println("Add pair(" + k + ", " + v + ")");
			}
		}
	}
	
	public Integer get(int k) throws Exception {
		if(map.get(k) != null) {
			Pair<Integer, Integer> p = map.get(k);
			list.remove(p);
			list.addFirst(p);
			
			return p.getValue();
		} else
			return null;
	}

	public static void main(String[] args) throws Exception {
		LRUCache cache = new LRUCache(2);
		cache.set(1, 10); // it will store a key (1) with value 10 in the cache.
		cache.set(2, 20); // it will store a key (1) with value 10 in the cache.
		System.out.println(cache.get(1)); // returns 10
		cache.set(3, 30); // evicts key 2 and store a key (3) with value 30 in the cache.
		System.out.println(cache.get(2)); // returns -1 (not found)
		cache.set(4, 40); // evicts key 1 and store a key (4) with value 40 in the cache.
		System.out.println(cache.get(1)); // returns -1 (not found)
		System.out.println(cache.get(3)); // returns 30
		System.out.println(cache.get(4)); // returns 40
	}

}
