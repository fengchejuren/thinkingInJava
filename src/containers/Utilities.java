/**  
 * @Title: Utilities.java 
 * @Package containers 
 * @Description: TODO 
 * @author Rock King 2014年8月9日 上午9:22:01
 * @version V1.0  
 */
package containers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Random;
import java.util.Vector;

/**
 * @Description: TODO
 * @author Rock King 2014年8月9日 上午9:22:01
 * @see ~!^ Keep bugs away and code with U!
 */

public class Utilities {

	static List<String> list = Arrays.asList("one two three Four five six one"
			.split(" "));

	public static void main(String[] args) {
		System.out.println(list);
		System.out.println("list.disjoin(Four):"
				+ Collections.disjoint(list, Collections.singleton("four")));
		System.out.println("Max: " + Collections.max(list));
		System.out.println("Min: " + Collections.min(list));
		System.out.println("Max w/ comparator:"
				+ Collections.max(list, String.CASE_INSENSITIVE_ORDER));
		System.out.println("Min w/ comparator:"
				+ Collections.min(list, String.CASE_INSENSITIVE_ORDER));

		List<String> subList = Arrays.asList("Four five six".split(" "));
		System.out.println("IndexofSubList: "
				+ Collections.indexOfSubList(list, subList));
		System.out.println("LastIndexofSubList: "
				+ Collections.lastIndexOfSubList(list, subList));
		Collections.replaceAll(list, "one", "Yo");
		System.out.println("ReplaceAll: "+list);
		Collections.reverse(list);
		System.out.println("Reverse: "+list);
		Collections.rotate(list, 3);
		System.out.println(list);
		List<String> source = Arrays.asList("in the matrix".split(" "));
		Collections.copy(list, source);
		System.out.println("Copy source to list: "+list);
		Collections.swap(list, 0, list.size()-3);
		System.out.println("Swap: "+list);
		Collections.shuffle(list, new Random(47));;
		System.out.println("Shufle: \n"+list);
		Collections.fill(list, "pop");
		System.out.println("Fill pop:\n"+list);
		System.out.println("FrequencyOfPoP:"+Collections.frequency(list, "pop"));

		List<String> dups = Collections.nCopies(3, "snap");
		System.out.println("Snap:\n"+dups);
		System.out.println("'list' disjoin 'dups'?:\n"+Collections.disjoint(list, dups));
		
		Enumeration<String> e = Collections.enumeration(dups);
		Vector<String> v = new Vector<String>();
		while(e.hasMoreElements())
			v.add(e.nextElement());
		ArrayList<String> arrayList = Collections.list(v.elements());
		System.out.println("ArrayList:\n"+arrayList);
		System.out.println("Vector:\n"+v);
		
	}
}
