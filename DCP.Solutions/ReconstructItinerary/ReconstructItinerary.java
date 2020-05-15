package ReconstructItinerary;

/**
 * Backtracking
 * */

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javafx.util.Pair;

public class ReconstructItinerary {
	
	public List<String> findItinerary(List<Pair<String, String>> tickets, String start) {
		if(tickets == null)
			return null;
		Collections.sort(tickets, new Comparator<Pair<String, String>>() {
			@Override
			public int compare(Pair<String, String> o1, Pair<String, String> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}
		});
        List<String> result = new ArrayList<String>();
        List<Integer> record = new ArrayList<>();
        for(int k = 0; k < tickets.size(); k++)
        	record.add(-1);
        String currentStart = start;
        int i = 0, j = 0;
        while(i < tickets.size()) {
        	boolean foundStart = false;
        	while(j < tickets.size()) {
            	if(tickets.get(j).getKey().equals(currentStart)) {
            		if(!record.contains(j)) {
            			foundStart = true;
            			record.set(i, j);
            			currentStart = tickets.get(j).getValue();
            			j = 0;
            			i++;
            			break;
            		}
            	}
            	j++;
            }
        	if(!foundStart) {
        		return null;
        	}
        }
        
        result.add(start);
        for(int index : record) {
        	result.add(tickets.get(index).getValue());
        }
        return result;
    }

	public static void main(String[] args) {
		List<Pair<String, String>> tickets = new ArrayList<>();
//		tickets.add(new Pair<String, String>("SFO", "HKO"));
//		tickets.add(new Pair<String, String>("YYZ", "SFO"));
//		tickets.add(new Pair<String, String>("YUL", "YYZ"));
//		tickets.add(new Pair<String, String>("HKO", "ORD"));
		tickets.add(new Pair<String, String>("A", "C"));
		tickets.add(new Pair<String, String>("A", "B"));
		tickets.add(new Pair<String, String>("B", "C"));
		tickets.add(new Pair<String, String>("C", "A"));
		ReconstructItinerary solution = new ReconstructItinerary();
		System.out.println(solution.findItinerary(tickets, "A"));
	}

}
