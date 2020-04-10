package XORLinkedList;

public class XORDoublyLinkedList {
	
	private Node head;
	private Node tail;
	
	private int size;
	
	public int lastItemAddress; 
	
	private Memory memory = Memory.getMemory();

	public XORDoublyLinkedList() {
		this.lastItemAddress = -1;
		this.size = 0;
	}
	
	public <T> void add(int v) throws Exception {
		
		Node node = new Node(v);
		
		// allocate memory for new node
		int address = this.memory.allocate(node);
		if(address == -1) {
			throw new Exception("no enough memory!");
		}
		
		// assign both for this new node
		if(lastItemAddress == -1) {
			// the first node (head)
			node.both = 0; // both = null ^ null
			this.head = node;
			this.tail = node;
		}
		else {
			// both = lastItemAddress ^ null;
			node.both = lastItemAddress ^ 0;
		}
		
		// update tail's both
		this.tail.both = this.tail.both ^ address;
		
		// update laetItemAddress
		lastItemAddress = address;
		
		// update tail
		this.tail = node;
		
		// size up
		this.size++;
	}
	
	public int get(int index) throws Exception {
		// check index eligibility
		if(index + 1 > size || index < 0) {
			throw new Exception("Illegal index!");
		}
		// iterate from tail to head
		// at tail
		Node now = this.tail;
		int nowAddress = lastItemAddress;
		int nextAddress = 0; // tail -> next = null
		
		// if index is tail
		if(index == size - 1) {
			return memory.getByAddress(nowAddress).value;
		}
		
		// otherwise, start traversing: preAddress = nowBoth ^ nextAddress
		int i = this.size - index - 1;
		while(i > 0) {
			// get previsou address
			int previousAddress = now.both ^ nextAddress;
			
			// swap
			now = memory.getByAddress(previousAddress);
			nextAddress = nowAddress;
			nowAddress = previousAddress;
			
			i--;
		}
		return now.value;
	}
	
	
	public static void main(String[] args) throws Exception {
		XORDoublyLinkedList list = new XORDoublyLinkedList();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		list.add(5);
		System.out.println(list.get(2));
	}

}
