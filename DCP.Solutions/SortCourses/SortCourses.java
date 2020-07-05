package SortCourses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

/**
 * Topological Sorting
 * 
 *  L ← Empty list that will contain the sorted elements
	S ← Set of all nodes with no incoming edge
	
	while S is not empty do
	    remove a node n from S
	    add n to tail of L
	    for each node m with an edge e from n to m do
	        remove edge e from the graph
	        if m has no other incoming edges then
	            insert m into S
	
	if graph has edges then
	    return error   (graph has at least one cycle)
	else 
	    return L   (a topologically sorted order)
 * */

public class SortCourses {
	
	public List<String> sort(Map<String, List<String>> prerequisites) {
		
		List<String> result = new ArrayList<String>(); // to record sorting result
		
		// Find the set of all nodes with no incoming edge
		Vector<String> single = new Vector<String>();
		for(Map.Entry<String, List<String>> entry : prerequisites.entrySet()) {
			if(entry.getValue().isEmpty())
				single.add(entry.getKey());
		}
		
		// while S is not empty do
		while(!single.isEmpty()) {
			// remove a node n from S
			String chosen = single.remove(0);
			
			// add n to tail of L
			result.add(chosen);
			
			// for each node m with an edge e from n to m do
			for(Map.Entry<String, List<String>> entry : prerequisites.entrySet()) {
				if(entry.getValue().contains(chosen)) {
					// remove edge e from the graph
					List<String> edges = new ArrayList<String>(entry.getValue());
					edges.remove(chosen);
					entry.setValue(edges);
					// if m has no other incoming edges then insert m into S
					if(entry.getValue().isEmpty())
						single.add(entry.getKey());
				}
			}
		}
		
		// if graph has edges then, return error (graph has at least one cycle)
		for(Map.Entry<String, List<String>> entry : prerequisites.entrySet()) {
			if(!entry.getValue().isEmpty())
				return null;
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] csc300 = {"CSC100", "CSC200"};
		String[] csc200 = {"CSC100"};
		String[] csc100 = {};
		Map<String, List<String>> prerequisites = new HashMap<String, List<String>>();
		prerequisites.put("CSC100", Arrays.asList(csc100));
		prerequisites.put("CSC200", Arrays.asList(csc200));
		prerequisites.put("CSC300", Arrays.asList(csc300));
		
		SortCourses sortCourses = new SortCourses();
		System.out.println(sortCourses.sort(prerequisites));
	}

}
