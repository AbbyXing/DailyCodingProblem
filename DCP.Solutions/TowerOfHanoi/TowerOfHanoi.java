package TowerOfHanoi;

/**
 * Recursive
 * 
 * ??????
 * */

public class TowerOfHanoi {
	
	public final static int rod = 3;
	
	public static void steps(int n, int fromRod, int toRod, int auxRod) {
		if(n == 1) {
			System.out.println("Move disk 1 from rod " + fromRod + " to rod " + toRod);
			return;
		}
		steps(n - 1, fromRod, auxRod, toRod);
		System.out.println("Move disk " + n +" from rod " + fromRod + " to rod " + toRod);
		steps(n - 1, auxRod, toRod, fromRod);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TowerOfHanoi.steps(3, 1, 3, 2);
	}

}
