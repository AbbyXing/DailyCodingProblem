package XORLinkedList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * I use an int[capacity] to simulate the real memory allocation,
 * the "fake" memory has capacity, the index of each element in the array
 * represent the start address of the stored element. memory[add] is 0 if this address
 * is not occupied, otherwise memory[add] is 1.
 * 
 * **/

public class Memory {
	
	private static int capacity = 1024;
	private int[] memory;
	private Map<Integer, Node> nodeList;
	
	private static Memory instance;
	
	public Memory() {
		this.memory = new int[capacity];
		Arrays.fill(memory, 0);
		nodeList = new HashMap<Integer, Node>();
	}
	
	public static Memory getMemory() {
		if(instance == null) {
			instance = new Memory();
		}
		return instance;
	}
	
	public int allocate(Node node) throws Exception {
		if(Arrays.stream(memory).sum() == capacity) {
			return -1;
		}
		Random random = new Random();
		int address = random.nextInt(capacity);
		while(true) {
			if(memory[address] == 0) {
				break;
			}
			address = random.nextInt(capacity);
		}
		memory[address] = 1;
		nodeList.put(address, node);
		return address;
	}
	
	public Node getByAddress(int address) {
		return nodeList.get(address);
	}

}
