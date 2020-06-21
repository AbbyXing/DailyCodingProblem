package MergeLinkedLists;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class MergeLinkedLists {
	
	public LinkedList<Integer> merge(ArrayList<LinkedList<Integer>> lists) {
		if(lists == null || lists.isEmpty())
			return null;
		
		LinkedList<Integer> merged = new LinkedList<Integer>();
		int k = lists.size();
		Integer[] cache = new Integer[k];
		Arrays.fill(cache, null);
		for(int i = 0; i < k; i++) {
			if(!lists.get(i).isEmpty())
				cache[i] = lists.get(i).poll();
			else
				cache[i] = null;
		}
		
		int minIndex = getMinIndex(cache);
		while(minIndex != -1) {
			int preMergeElement = cache[minIndex];
			merged.addLast(preMergeElement);
			if(!lists.get(minIndex).isEmpty())
				cache[minIndex] = lists.get(minIndex).poll();
			else
				cache[minIndex] = null;
			minIndex = getMinIndex(cache);
		}
		
		return merged;
	}
	
	private int getMinIndex(Integer[] cache) {
		int minIndex = -1;
		int min = Integer.MAX_VALUE;
		for(int i = 0;  i < cache.length; i++) {
			if(cache[i] != null && cache[i] < min) {
				min = cache[i];
				minIndex = i;
			}
		}
		
		return minIndex;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		l1.push(9);
		l1.push(7);
		l1.push(5);
		l1.push(3);
		l1.push(1);
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		l2.push(10);
		l2.push(8);
		l2.push(6);
		l2.push(4);
		l2.push(2);
		ArrayList<LinkedList<Integer>> a = new ArrayList<LinkedList<Integer>>();
		a.add(l1);
		a.add(l2);
		MergeLinkedLists solution = new MergeLinkedLists();
		System.out.println(solution.merge(a).toString());
	}

}
