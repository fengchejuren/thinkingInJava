/**  
 * @Title: ListSortSearch.java 
 * @Package containers 
 * @Description: TODO 
 * @author Rock King 2014年8月9日 上午10:09:10
 * @version V1.0  
 */
package containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/**
 * @Description: TODO
 * @author Rock King 2014年8月9日 上午10:09:10
 * @see ~!^ Keep bugs away and code with U!
 */

public class ListSortSearch {

	public static void main(String[] args) {
		List<String> list = new ArrayList<String>(Utilities.list);
		list.addAll(Utilities.list);
		System.out.println(list);
		Collections.shuffle(list, new Random(47));
		System.out.println("Shuffled:\n" + list);
		ListIterator<String> iterator = list.listIterator(10);
		while (iterator.hasNext()) {
			iterator.next();
			iterator.remove();
		}
		System.out.println("Trimmed: \n" + list);
		Collections.sort(list);
		System.out.println("Sort:\n" + list);
		String key = list.get(7);
		int index = Collections.binarySearch(list, key);
		System.out.println("Location of " + key + " is " + index + ",list.get"
				+ index + "=" + list.get(index));
		Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
		System.out.println("String.caseInsensitiveOrder \n" + list);
		key = list.get(7);
		index = Collections.binarySearch(list, key,
				String.CASE_INSENSITIVE_ORDER);
		System.out.println("location of " + key + " is " + index + ",list.get("
				+ index + ")=" + list.get(index));
	}
}
