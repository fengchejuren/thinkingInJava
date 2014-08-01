package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayOfGenerics {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		List<String>[] ls;
		List[] la = new List[10];
		ls = (List<String>[])la;		
		ls[0] = new ArrayList<String>();
		//编译期错误，compile-time checking produces an error
		//ls[1] = new ArrayList<Integer>();
		
		Object[] objects = ls;
		//不会报错，因为List<String> is a type of Object
		objects[1] = new ArrayList<Integer>();
		
		List<BerylliumSphere>[] spheres = (List<BerylliumSphere>[])new List[10];
		for(int i=0;i<spheres.length;i++){
			spheres[i] = new ArrayList<BerylliumSphere>();
		}
		System.out.println(Arrays.toString(spheres));
	}
}
