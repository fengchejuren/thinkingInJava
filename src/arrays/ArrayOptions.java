package arrays;

import java.util.Arrays;

/**数组的初始化
 * @author Administrator
 *
 */
public class ArrayOptions {

	
	public static void main(String[] args) {
		BerylliumSphere[] a;
		BerylliumSphere[] b = new BerylliumSphere[10];
		System.out.println("b:"+Arrays.toString(b));
		BerylliumSphere[] c = new BerylliumSphere[10];
		for(int i=0;i<c.length;i++){
			if(c[i]==null)
				c[i] = new BerylliumSphere();
		}
		BerylliumSphere[] d = {new BerylliumSphere(),new BerylliumSphere(),new BerylliumSphere()};
		
		a = new BerylliumSphere[]{new BerylliumSphere(),new BerylliumSphere()};
		System.out.println("a.length: "+a.length);
		System.out.println("b.length: "+b.length);
		System.out.println("c.length: "+c.length);
		System.out.println("d.length: "+d.length);
		a = d;
		System.out.println("a.length: "+a.length);
		
		int[] e;
		int[] f = new int[10];
		System.out.println("f: "+Arrays.toString(f));
		int[] g = new int[4];
		for(int i=0;i<g.length;i++)
			g[i] = i*i;
		int[] h = {11,47,93};
		System.out.println("f.length:"+f.length);
		System.out.println("g.length:"+g.length);
		System.out.println("h.length:"+h.length);
		e = h;
		System.out.println("e.length:"+e.length);
		e = new int[]{1,8,56,23};
		System.out.println("e.length:"+e.length);
		
		char[] i = new char[10];
		System.out.println(Arrays.toString(i));
		System.out.println(i[3]);
		Character[] j = new Character[10];
		System.out.println(j[3].hashCode());  //空指针异常
	}
	
}
