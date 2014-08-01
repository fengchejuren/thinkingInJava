package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class BerylliumSphere{
	private static long counter=1;
	private long id = counter++;
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " Sphere "+id;
	}
}
/**thinkingInJavachapter16  สýื้
 * @author Administrator
 *
 */
public class ContainerComparison {

	public static void main(String[] args) {
		BerylliumSphere[] spheres = new BerylliumSphere[10];
		for(int i=0;i<spheres.length;i++){
			spheres[i] = new BerylliumSphere();
		}
		System.out.println(Arrays.toString(spheres));
		System.out.println(spheres[6]);
		
		List<BerylliumSphere> list = new ArrayList<BerylliumSphere>();
		for(int i=0;i<5;i++)
			list.add(new BerylliumSphere());
		System.out.println(list);
		System.out.println(list.get(3));
		
		Integer[] integers = {1,2,3,4,5,6,7,8,9};
		System.out.println(Arrays.toString(integers));
		System.out.println(integers[6]);
		
		List<Integer> integerList = new ArrayList<Integer>();
		for(int i=0;i<10;i++)
			integerList.add(i);
		System.out.println(integerList);
		System.out.println(integerList.get(4));
		
	}
}
