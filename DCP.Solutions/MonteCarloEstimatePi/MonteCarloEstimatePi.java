package MonteCarloEstimatePi;

import java.text.DecimalFormat;
import java.util.Random;

/**
 * Suppose you have a bag of beans. Spread the beans evenly on the figure. 
 * Then count the number of beans in the figure. 
 * The number of beans is the area of the figure. 
 * The smaller your beans and the more you sprinkle, 
 * the more accurate the result. 
 * 
 * */

public class MonteCarloEstimatePi {
	
	private double Pi;
	
	public MonteCarloEstimatePi(int totalSeed) {
		int goodSeed = 0;
		double r = 1;
		Random random = new Random();
		for(int i = 0; i < totalSeed; i++) {
			double x = random.nextDouble() * r;
			double y = random.nextDouble() * r;
			if(Math.pow(x, 2) + Math.pow(y, 2) <= Math.pow(r, 2))
				goodSeed++;
		}
		this.Pi = 4 * ((double)goodSeed / (double)totalSeed);
	}
	
	public double GetPi() {
		DecimalFormat decimalFormat = new DecimalFormat("#.000");
		return Double.valueOf(decimalFormat.format(Pi));
	}

	public static void main(String[] args) {
		MonteCarloEstimatePi pi = new MonteCarloEstimatePi(1000);
		System.out.println(pi.GetPi());
	}

}
