/**
 * 
 */
package enumerated;

/**
 * @author Administrator
 *
 */
public class NonEnum {

	/**对非Enum类型的Class调用getEnumConstants()方法，返回的是空，所以下面这个方法抛出NullPointerException
	 * @param args
	 */
	public static void main(String[] args) {
		Class<Integer> integerClass = Integer.class;
		for(Object o:integerClass.getEnumConstants())
			System.out.println(o);
	}
	
}
