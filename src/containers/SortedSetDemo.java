package containers;

import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @Description: TODO
 * @author Rock King 2014年8月6日 下午11:17:11 ~!^ Keep bugs away and code with U!
 */
public class SortedSetDemo {

	public static void main(String[] args) {
		SortedSet<String> sortedSet = new TreeSet<String>();
		Collections.addAll(sortedSet,
				"one two three four five six seven eight nine ten".split(" "));
		System.out.println(sortedSet);
		String low = sortedSet.first();
		String high = sortedSet.last();
		System.out.println(low);
		System.out.println(high);

		System.out.println(sortedSet.subSet(low, high));
		System.out.println(sortedSet.headSet(high));
		System.out.println(sortedSet.tailSet(low));
	}

}
