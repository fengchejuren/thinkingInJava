package arrays;

import java.util.Arrays;

public class AutoboxingArrays {

	public static void main(String[] args) {
		Integer[][] a = {
				{1,2,3,4,5,6,56},	
				{1,21,3,4,5,6,56},	
				{1,24,35,41,5,6,56},	
				{1,26,3,4,5,65,56},	
				{176,2,653,4,57,6,56},	
				{121,32,53,4,5,623,56,77}	
		};
		System.out.println(Arrays.deepToString(a));
		System.out.println("a.length:"+a.length);
		System.out.println("a[5].length:"+a[5].length);
		System.out.println("a[1].length:"+a[1].length);
	}
	
}
