package arrays;

import java.util.Arrays;

/** 
 * @Description: TODO
 * @author Rock King 2014年8月5日 上午12:34:14 
 * ~!^ Keep bugs away and code with U!	 
 */ 
public class ComparingArrays {

	public static void main(String[] args) {
		int[] a1 = new int[10];
		int[] a2 = new int[10];
		Arrays.fill(a1, 47);
		Arrays.fill(a2, 47);
		System.out.println("a1.equals(a2): "+a1.equals(a2));
		System.out.println("Arrays.equals(a1, a2): "+Arrays.equals(a1, a2));
		String[] h1 = new String[5];
		String[] h2 = new String[5];
		Arrays.fill(h1, "hi");
		h2 = new String[]{"hi","hi","hi","hi","hi"};
		System.out.println(Arrays.equals(h1, h2));
	}
	
}
