package BitArray;

import java.util.HashSet;
import java.util.Set;

public class BitArray {
	
	private int size;
	private Set<Integer> positiveId;
	
	public BitArray() {
		size = 0;
	}
	
	// all elements are 0 when first initiate
	public void init(int size) {
		positiveId = new HashSet<Integer>(size);
		this.size = size;
	}
	
	public void set(int id, int val) throws Exception {
		if(id >= size || id < 0 || (val != 0 && val != 1))
			throw new Exception("illegal setting!");
		
		if(val == 1)
			positiveId.add(id);
		else {
			if(positiveId.contains(id))
				positiveId.remove(id);
		}
	}
	
	public int get(int id) throws Exception {
		if(id >= size || id < 0)
			throw new Exception("out of boundary!");
		
		return positiveId.contains(id) ? 1 : 0;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BitArray bitArray = new BitArray();
		bitArray.init(5);
		bitArray.set(1, 1);
		bitArray.set(2, 1);
		System.out.println(bitArray.get(1));
		bitArray.set(2, 0);
		System.out.println(bitArray.get(2));
		System.out.println(bitArray.get(3));
	}

}
