package containers;

import java.lang.reflect.InvocationTargetException;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

/** 
 * @Description: TODO
 * @author Rock King 2014年8月6日 下午10:33:54 
 * ~!^ Keep bugs away and code with U!	 
 */ 

class SetType{
	int i;
	public SetType(int i){
		this.i = i;
	}
	@Override
	public boolean equals(Object arg0) {
		return arg0 instanceof SetType && ((SetType)arg0).i == i;
	}
	@Override
	public String toString() {
		return Integer.toString(i);
	}
}

class HashType extends SetType{

	public HashType(int i) {
		super(i);
	}
	@Override
	public int hashCode() {
		return i;
	}
}

class TreeType extends SetType implements Comparable<TreeType>{

	public TreeType(int i) {
		super(i);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(TreeType o) {
		// TODO Auto-generated method stub
		return o.i<i?-1:(o.i==i?0:1);
	}
	
}


public class TypesForSets {

	static <T> Set<T> fill(Set<T> set,Class<T> type){
		try {
			for(int i=0;i<10;i++){
				set.add(type.getConstructor(int.class).newInstance(i));
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return set;
	}
	
	static <T> void test(Set<T> set,Class<T> type){
		fill(set, type);
		fill(set, type);		//try to add duplicates
		fill(set, type);
		System.out.println(set);
	}
	
	public static void main(String[] args) {
		test(new HashSet<HashType>(), HashType.class);
		test(new LinkedHashSet<HashType>(), HashType.class);
		test(new TreeSet<TreeType>(), TreeType.class);
		//Things that doesn't work
		test(new HashSet<SetType>(), SetType.class);
		test(new HashSet<TreeType>(), TreeType.class);
		test(new LinkedHashSet<SetType>(), SetType.class);
		test(new LinkedHashSet<TreeType>(), TreeType.class);
		
		try {
			test(new TreeSet<SetType>(), SetType.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		try {
			test(new TreeSet<HashType>(), HashType.class);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
}
