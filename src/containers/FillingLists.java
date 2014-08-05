package containers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class StringAddress {
	private String s;

	public StringAddress(String s) {
		this.s = s;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + " " + s;
	}
}

/**
 * @Description: TODO
 * @author Rock King 2014年8月5日 下午10:58:33 ~!^ Keep bugs away and code with U!
 */
public class FillingLists {

	public static void main(String[] args) {
		List<StringAddress> list = new ArrayList<StringAddress>(
				Collections.nCopies(4, new StringAddress("hello")));
		System.out.println(list);
		Collections.fill(list, new StringAddress("world!"));
		System.out.println(list);
		
	}
}
