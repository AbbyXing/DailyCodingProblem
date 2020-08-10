package RotateListByK;

import java.util.Arrays;

public class RotateList {
	
	public static int[] rotateByK(int[] a, int k) {
		for(int i = 0; i < k; i++) {
			a = rotate(a);
		}
		
		return a;
	}
	
	// rotate by 1
	private static int[] rotate(int[] a) {
		int first = a[0];
		for(int i = 0; i < a.length - 1; i++) {
			a[i] = a[i + 1];
		}
		a[a.length - 1] = first;
		
		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1,2,3,4,5,6};
		System.out.println(Arrays.toString(RotateList.rotateByK(a, 2)));
	}

}
