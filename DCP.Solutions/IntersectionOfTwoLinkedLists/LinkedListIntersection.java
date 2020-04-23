package IntersectionOfTwoLinkedLists;

/**
 * The point is list a and b may have different length before the intersection part.
 * 
 * So find a way to make two iterators reach the starting point of intersection part at the same time.
 * 
 * Link list a and b as a "circle" can achieve the goal.
 * 
 * */

public class LinkedListIntersection {
	
	public LinkedListIntersection() {}
	
	public ListNode GetIntersection(ListNode headA, ListNode headB) {
		if(headA == null || headB == null)
			return null;
		ListNode a = headA, b = headB;
		/* 
		 * 1. If 2 lists have the same length, result can be found during the 1st round
		 * 2. If have different length, result can be found during the 2ed round
		 * 	(after the 1st round the difference in length will be be compensated)
		 * 2. If 2 lists have no intersection, a and b will both equal to null after the 2ed round */
		while(a != b) {
			a = (a == null) ? headB : a.next;
			b = (b == null) ? headA : b.next;
		}
		return a;
	}

	public static void main(String[] args) {
		ListNode intersect = new ListNode(8);
		intersect.next = new ListNode(4);
		intersect.next.next = new ListNode(5);
		
		ListNode a = new ListNode(3);
		a.next = new ListNode(7);
		a.next.next = intersect;
		
		ListNode b = new ListNode(99);
		b.next = new ListNode(11);
		b.next.next = new ListNode(1);
		b.next.next.next = intersect;
		
		LinkedListIntersection solution = new LinkedListIntersection();
		System.out.println(solution.GetIntersection(a, b).val);
	}

}
