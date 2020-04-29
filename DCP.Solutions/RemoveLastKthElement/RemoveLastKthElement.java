package RemoveLastKthElement;

/**
 * Use a window which's width is k
 * 
 * A start point and an end point to represent the window
 * 
 * 1. move the end point to the kth element
 * 
 * 2. move the start and the end point together until the end point reaches the end of the list
 * 
 * 3. remove the element where the start point currently at
 * */

public class RemoveLastKthElement {
	
	private LinkedListNode _list;
	
	public RemoveLastKthElement(LinkedListNode list) {
		_list = list;
	}
	
	public LinkedListNode GetRemovedList(int k) {
		if(_list == null)
			return null;
		LinkedListNode head = _list, start = _list, end = _list, preStart = null;
		for(int i = 0; i < k; i++) {
			end = end.next;
		}
		while(end != null) {
			preStart = start;
			start = start.next;
			end = end.next;
		}
		preStart.next = start.next;
		
		return head;
	}

	public static void main(String[] args) {
		LinkedListNode head = new LinkedListNode(5);
		head.next = new LinkedListNode(4);
		head.next.next = new LinkedListNode(3);
		head.next.next.next = new LinkedListNode(2);
		head.next.next.next.next = new LinkedListNode(1);
		RemoveLastKthElement solution = new RemoveLastKthElement(head);
		head = solution.GetRemovedList(3);
		while(head != null) {
			System.out.print(head.val + ", ");
			head = head.next;
		}
	}

}
