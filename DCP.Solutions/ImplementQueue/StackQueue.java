package ImplementQueue;

import java.util.Stack;

/**
 * Stack and Queue
 * 
 * stack1: store new pushed elements
 * stack2: reverse elements in stack1 to get the head of the stack1
 * */

public class StackQueue {
	
	private Stack<Integer> stack1;
	private Stack<Integer> stack2;
	
	public StackQueue() {
		stack1 = new Stack<>();
		stack2 = new Stack<>();
	}
	
	public void enqueue(int v) {
		stack1.push(v);
		System.out.println("Push " + v);
	}
	
	public int dequeue() {
		if(stack1.isEmpty() && stack2.isEmpty())
			throw new Error("The queue is empty!");
		
		if(stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		
		int result = stack2.pop();
		System.out.println("Pop " + result);
		return result;
	}

	public static void main(String[] args) {
		StackQueue queue = new StackQueue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.dequeue();
		queue.enqueue(3);
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
	}

}
