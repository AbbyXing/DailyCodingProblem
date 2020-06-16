package ReverseLinkedList;

/**
 * Recursive
 * 
 * */

public class ReverrseLinkedList {
	
	public Node reverse(Node node)  {
		// base case
		if(node == null || node.next == null)
			return node;
		// recursive
		Node reverse = reverse(node.next);
		// tricky
		node.next.next = node; // now node.next is original node.next
		node.next = null; // now node became the tail of reverse (node.next = null)
		
		return reverse; // return the reverse
	}
	
	public void printList(Node head) {
		Node node = head;
		while(node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.print("null");
		System.out.println();
	}
	
	public Node add(Node head, int v) {
		Node node = head;
		while(node.next != null) {
			node = node.next;
		}
		node.next = new Node(v);
		return head;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverrseLinkedList solution = new ReverrseLinkedList();
		Node head = new Node(1);
		head = solution.add(head, 2);
		head = solution.add(head, 3);
		head = solution.add(head, 4);
		head = solution.add(head, 5);
		solution.printList(head);
		
		head = solution.reverse(head);
		solution.printList(head);
	}

}
