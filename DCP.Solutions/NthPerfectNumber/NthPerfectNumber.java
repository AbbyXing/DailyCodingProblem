package NthPerfectNumber;

public class NthPerfectNumber {
	
	public int GetNthNumber(int n) {
		int number = 19, count = 1;
		
		while(true) {
			if(count == n)
				break;
			number += 9;
			if(isValid(number))
				count++;
		}
		
		return number;
	}
	
	private boolean isValid(int num) {
		int sum = 0;
		while(num > 0) {
			sum += num % 10;
			num /= 10;
		}
		sum += num % 10;
		
		if(sum == 10)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NthPerfectNumber solution = new NthPerfectNumber();
		System.out.println(solution.GetNthNumber(20));
	}

}
