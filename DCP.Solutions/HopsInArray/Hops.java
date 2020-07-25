package HopsInArray;

public class Hops {
	
	public boolean canReachEnd(int[] a) {
		if(a == null || a.length == 0)
			return true;
		int n = a.length;
		int last = n - 1, current = n - 2;
		while(last > 0 && current >= 0) {
			if(last - current <= a[current]) {
				last = current;
			}
			current--;
		}
		
		return last == 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {2, 0, 1, 3};
		Hops hops = new Hops();
		System.out.println(hops.canReachEnd(a));
		int[] b = {1,0,0,1};
		System.out.println(hops.canReachEnd(b));
	}

}
