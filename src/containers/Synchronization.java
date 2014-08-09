/**  
 * @Title: Synchronization.java 
 * @Package containers 
 * @Description: TODO 
 * @author Rock King 2014年8月9日 上午10:58:15
 * @version V1.0  
 */
package containers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @Description: TODO
 * @author Rock King 2014年8月9日 上午10:58:15
 * @see ~!^ Keep bugs away and code with U!
 */

public class Synchronization {

	public static void main(String[] args) {
		Collection<String> c = Collections
				.synchronizedCollection(new ArrayList<String>());
		List<String> list = Collections
				.synchronizedList(new ArrayList<String>());
		Set<String> set = Collections.synchronizedSet(new HashSet<String>());
		Set<String> sortedSet = Collections
				.synchronizedSortedSet(new TreeSet<String>());
		Map<String, String> map = Collections
				.synchronizedMap(new HashMap<String, String>());
		Map<String, String> sortedMap = Collections
				.synchronizedSortedMap(new TreeMap<String, String>());

	}

}
