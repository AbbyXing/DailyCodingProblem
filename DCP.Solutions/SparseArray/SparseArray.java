package SparseArray;

import java.util.HashMap;
import java.util.Map;

public class SparseArray {
	
	private Map<Integer, Integer> array;
	private int size;
	
	public SparseArray() {
		array = new HashMap<Integer, Integer>();
		size = 0;
	}
	
	public void init(int size) {
		this.size = size;
	}
	
	public void set(int id, int val) {
		if(id >= size) {
			System.out.println("Out of boundary!");
			return;
		}
		array.put(id, val);
	}
	
	public int get(int id) throws Exception {
		if(id >= size)
			throw new Exception("Out of boundary!");
		else
			return (array.containsKey(id)) ? array.get(id) : 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
