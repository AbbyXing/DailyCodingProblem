package FlipCoinsTillTails;

import java.util.Random;

public class FlipCoins {

	public static int roudsForAllTails(int n) {
		Random rand = new Random();
		int round = 0;
		
		// head = true, tail = false
		int i = 1;
		while(i < n) {
			boolean result = rand.nextBoolean();
			System.out.println("coint " + i + ": " + result);
			round++;
			if(!result) {
				i++;
				continue;
			}
			else {
				while(result) {
					result = rand.nextBoolean();
					System.out.println("coint " + i + ": " + result);
					round++;
				}
				i++;
				continue;
			}
		}
		
		return round;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("\nTotal rounds: " + FlipCoins.roudsForAllTails(5));
	}

}
