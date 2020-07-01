package Division;

public class Division {
	
	public Integer divide(int devidend, int divisor) {
		if(devidend <= 0 || divisor <= 0)
			return null;
		
		int quotient = 0, sum = 0;
		while(sum < devidend) {
			sum += divisor;
			quotient++;
		}
		
		return (sum == devidend) ? quotient : quotient - 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Division division = new Division();
		System.out.println(division.divide(10, 2));
		System.out.println(division.divide(10, 3));
		System.out.println(division.divide(10, 4));
	}

}
