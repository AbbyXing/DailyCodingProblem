package StackImplement;

/**
 * Stack, Design
 * 
 * Define a "max" property in each Node to represent the max element in the stack
 * if this Node is the head of this stack
 * */

public class MaxStack {
	
	private Node head;
    
    public void push(int x) {
    	// create the first head
        if(head == null)
        	// itself is the max element
        	head = new Node(x, x);
        else {
        	// compare the pushing element and the last head's max
        	Node n = new Node(x, Math.max(x, head.max));
        	// make the Node n the head of this stack
        	n.next = head;
        	// change the head pointer to the new head
        	head = n;
        }
    }
    
    public int pop() throws Exception {
        if(head != null) {
        	int v = head.val;
        	// move the head pointer to the next element
        	head = head.next;
        	return v;
        } else {
        	throw new Exception("Illegal Operation: the stack is empty");
        }
    }

    public int max() throws Exception {
        if(head != null)
        	return head.max;
        else
        	throw new Exception("Illegal Operation: the stack is empty");
    }

	public static void main(String[] args) throws Exception {
		MaxStack stack = new MaxStack();
		stack.push(5);
		stack.push(3);
		stack.push(4);
		System.out.println(stack.pop() + " " + stack.max());
		
	}

}
