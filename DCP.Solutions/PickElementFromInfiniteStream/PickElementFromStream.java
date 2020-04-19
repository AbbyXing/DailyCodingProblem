package PickElementFromInfiniteStream;

import java.util.Random;

/**
 * Reservoir sampling
 * */

public class PickElementFromStream {
	
	private String result;
	private int count;
	
	public PickElementFromStream() {
		this.count = 0;
		result = "";
	}
	
	public String pickRandom(String x) {
        count++; // increment count of numbers seen so far 
          
        // If this is the first element from stream, return it 
        if (count == 1) 
            this.result = x; 
        else { 
             // Generate a random number from 0 to count - 1 
            Random r = new Random(); 
            int i = r.nextInt(count); 
              
            // Replace the prev random number with new number with 1/count probability 
            if(i == count - 1) 
            	this.result = x; 
        } 
        return this.result; 
	}

	public static void main(String[] args) {
		String stream[] = {"1", "2", "3", "4"}; 
        int n = stream.length; 
        PickElementFromStream instance = new PickElementFromStream();
        for(int i = 0; i < n; i++) 
            System.out.println("Random element from first " + (i+1) + " numbers is " + instance.pickRandom(stream[i])); 
	}

}
