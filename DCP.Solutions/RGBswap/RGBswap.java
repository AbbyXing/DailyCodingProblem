package RGBswap;

/**
 * Can only swap elements in the array!
 * */

public class RGBswap {
	
	public Character[] GetSegregated(Character[] array) {
		
		int n = array.length;
		// r and g record the last element's index of 'R' and 'G' respectively
		int r = 0, g = 0;
		// swap all 'R' to the very beginning of the array
		for(int i = 0; i < n; i++) {
			char c = array[i];
			if(c == 'R') {
				array = swap(array, i, r);
				r++;
			}
		}
		// swap all 'G' right after all 'R'
		g = r;
		for(int i = 0; i < n; i++) {
			char c = array[i];
			if(c == 'G') {
				array = swap(array, i, g);
				g++;
			}
		}
		// all 'B' have already been placed appropriately
		
		return array;
	}
	
	private Character[] swap(Character[] a, int i, int j) {
		char swap = a[i];
		a[i] = a[j];
		a[j] = swap;
		
		return a;
	}

	public static void main(String[] args) {
		Character[] array = {'G', 'B', 'R', 'R', 'B', 'R', 'G'};
		RGBswap solution = new RGBswap();
		array = solution.GetSegregated(array);
		for(char c: array)
			System.out.print(c + " ");
	}

}
