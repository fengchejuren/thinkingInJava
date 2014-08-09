/**  
 * @Title: ReadOnly.java 
 * @Package containers 
 * @Description: TODO 
 * @author Rock King 2014年8月9日 上午10:27:16
 * @version V1.0  
 */
package containers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

import utils.Countries;

/**
 * @Description: TODO
 * @author Rock King 2014年8月9日 上午10:27:16
 * @see ~!^ Keep bugs away and code with U!
 */

public class ReadOnly {

	static Collection<String> data = new ArrayList<String>(Countries.names(6));

	public static void main(String[] args) {
		Collection<String> c = Collections
				.unmodifiableCollection(new ArrayList<String>(data));
		System.out.println(c); // 可以读
		// c.add("abd"); //不能增改

		List<String> a = Collections.unmodifiableList(new ArrayList<String>(
				data));
		ListIterator<String> iterator = a.listIterator();
		System.out.println(iterator.next()); // readOnly,
		// iterator.add("change"); //can't change

		Set<String> s = Collections.unmodifiableSet(new HashSet<String>(data));
		System.out.println(s); // readOnly
		// s.add("change"); //can't change

		Set<String> ss = Collections.unmodifiableSortedSet(new TreeSet<String>(
				data));
		System.out.println(ss);
		// ss.add("change"); //can't change
		Map<String, String> m = Collections
				.unmodifiableMap(new HashMap<String, String>(Countries
						.captials(6)));
		System.out.println(m);
		// m.put("change", "can't"); //can't change

		Map<String, String> mm = Collections
				.unmodifiableSortedMap(new TreeMap<String, String>(Countries
						.captials(6)));
		System.out.println(mm);
	}

}
