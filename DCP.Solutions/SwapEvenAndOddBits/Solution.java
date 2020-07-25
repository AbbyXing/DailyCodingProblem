package SwapEvenAndOddBits;

/**
 * Bit-Operations
 * 
 * */

public class Solution {
	
	public int swapEvenAndOdd(int num) {
		
//		// get all odd bits
//		int odds = num & 0xaa; // 0xaa = 10101010
//		
//		// get all even bits
//		int evens = num & 0x55; // 0x55 = 01010101
//		
//		// right shift odd bits
//		odds = odds >> 1;
//		
//		// left shift even bits
//		evens = evens << 1;
//		
//		// combine them together
//		num = odds | evens;
//		
//		return num;
		
		return ((num & 0xaa) >> 1) | ((num & 0x55) << 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		int num = 170;
		System.out.println(solution.swapEvenAndOdd(num)); // 85
		num = 226;
		System.out.println(solution.swapEvenAndOdd(num)); // 209
	}

}
