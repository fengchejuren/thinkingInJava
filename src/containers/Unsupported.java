package containers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * @author Administrator
 *
 */
public class Unsupported {

	static void test(String msg,List<String> list){
		System.out.println("------------------"+msg+"----------------------");
		Collection<String> c = list;
		Collection<String> subList = list.subList(1, 8);
		Collection<String> c2 = new ArrayList<String>(subList);
		try {
			c.retainAll(c2);
		} catch (Exception e) {
			System.out.println("c.retainAll(c2)"+e);
		}
		try {
			c.removeAll(c2);
		} catch (Exception e) {
			System.out.println("c.removeAll(c2)"+e);
		}
		try {
			c.clear();
		} catch (Exception e) {
			System.out.println("c.clear() "+e);
		}
		try {
			c.add("x");
		} catch (Exception e) {
			System.out.println("c.add() "+e);
		}
		try {
			c.addAll(c2);
		} catch (Exception e) {
			System.out.println("c.addAll() "+e);
		}
		try {
			c.remove("C");
		} catch (Exception e) {
			System.out.println("c.remove(\"C\") "+e);
		}
		//the list.set() modifies the value but doesn't change the size of the structure
		try {
			list.set(0, "set0");
		} catch (Exception e) {
			System.out.println("list.set(0, \"set0\")"+e);
		}
		
	}
	
	/** Arrays.asList  产生一个长度固定的list，仅仅支持不改变容器大小的操作，否则可能会抛出 UnsupportedOperationException
	 * 为解决这个问题，可以把其结果传递给任何Collection的构造方法中，这样就会生成可以使用所有的方法的容器
	 * @param args
	 */
	public static void main(String[] args) {
		List<String> list = Arrays.asList("A B C D E F G H I J K L M N O".split(" "));
		test("modifiable Copy", new ArrayList<String>(list));
		test("Arrays.asList", list);
	}
	
}
