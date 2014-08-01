package generics;

/**
 * @author Administrator
 * 
 */
class Other {
}

class BasicOther extends BasicHolder<Other> {
}

public class Uncontained {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BasicOther basicOther = new BasicOther();
		BasicOther basicOther2 = new BasicOther();
		basicOther.set(new Other());
		Other other = basicOther.get();
		basicOther.f();
	}
}
