package ShuffleCards;

import java.util.Arrays;
import java.util.Random;

public class ShuffleCards {
	
	private static int n = 52;
	private int[] cards;
	
	public ShuffleCards() {
		cards = new int[n];
		for(int i = 0; i < n; i++)
			cards[i] = i + 1;
	}
	
	public int[] Shuffle() {
		Random rand = new Random();
		for(int i = 0; i < n; i++) {
			// exchange each element with the randomly chosen element
			// in the range from itself to the end.
			int r = i + rand.nextInt(n - i);
			int temp = cards[r];
			cards[r] = cards[i];
			cards[i] = temp;
		}
		
		return cards;
	}

	public static void main(String[] args) {
		ShuffleCards shuffle = new ShuffleCards();
		System.out.println(Arrays.toString(shuffle.Shuffle()));
	}

}
