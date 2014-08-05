package containers;

import java.util.ArrayList;

import utils.CollectionData;
import utils.RandomGenerator;

/**
 * @Description: TODO
 * @author Rock King 2014年8月5日 下午11:21:04 ~!^ Keep bugs away and code with U!
 */
public class CollectionDataGeneration {

	/**
	 * @Description: TODO
	 * @param args
	 *            void
	 * @throws
	 * @see Any changes please send mail to:superman166@126.com ~!^ Keep bugs
	 *      away and code with U!
	 */
	public static void main(String[] args) {
		System.out.println(new ArrayList<String>(CollectionData.list(
				new RandomGenerator.String(9), 10)));
		System.out.println(new ArrayList<Integer>(CollectionData.list(
				new RandomGenerator.Integer(), 10)));

	}
}
