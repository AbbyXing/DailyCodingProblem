package BitOperators;

public class BitOperators {
	
	public int xOrY(int x, int y, int b) {
		
		b = -b; // create a mask: 1 -> all 1, 0 -> all 0
		
		/**
		 * if b = 0: -b = all 0
		 * 		~b = all 1
		 * 		(x & b) = 0
		 * 		(y & ~b) = y
		 * 
		 * if b = 1: -b = all 1
		 * 		~b = all 0
		 * 		(y & ~b) = 0
		 * 		(x & b) = x
		 * */
		
		return (x & b) | (y & ~b);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BitOperators obj = new BitOperators();
		System.out.println(obj.xOrY(3, 5, 1));
		System.out.println(obj.xOrY(3, 5, 0));
	}

}
