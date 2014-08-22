/**
 * 
 */
package enumerated;

enum Search{
	HITTHER,YON
}
/**
 * @author Administrator
 *
 */
public class UpcastEnum {

	/**getEnumConstants是Class上的方法，所以甚至可以对非Enum类型的对象调用此方法
	 * @param args
	 */
	public static void main(String[] args) {
		Search[] s = Search.values();
		Enum enum1 = Search.HITTHER;
		for(Enum e:enum1.getClass().getEnumConstants())
			System.out.println(e);
	}
	
}
