package arrays;

import java.util.Arrays;
import java.util.Random;

import utils.Generator;

public class CompType implements Comparable<CompType>{

	int i;
	int j;
	public static int count=1;
	public CompType(int i,int j){
		this.i = i;
		this.j = j;
	}
	@Override
	public String toString() {
		String result = "[ i= "+i+" ,j="+j+"]";
		if(count++%3==0)
			result += "\n";
		return result;
	}
	@Override
	public int compareTo(CompType o) {
		// TODO Auto-generated method stub
		return i<o.i?-1:(i==o.i?0:1);
	}

	public static Generator<CompType> generator(){
		return new Generator<CompType>() {
			@Override
			public CompType next() {
				// TODO Auto-generated method stub
				return new CompType(new Random(47).nextInt(100), new Random(47).nextInt(100));
			}
		};
	}
	
	
	
	public static void main(String[] args) {
		CompType[] a = new CompType[12];
		Arrays.fill(a, generator().next());
		System.out.println("before sort:"+Arrays.toString(a));
		Arrays.sort(a);
		System.out.println("after sort:"+Arrays.toString(a));
		
	}
}
