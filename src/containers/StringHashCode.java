package containers;

/**String类型的hashCode有这样一个特点：
 * 如果程序中包含多个String对象，并且有着相同的字符串序列，那么这些String对象被映射到同一块内存区域
 * 也就是说,hashCode是基于String的内容的
 * @author Administrator
 *
 */
public class StringHashCode {

	public static void main(String[] args) {
		String[] hellos = "hello hello".split(" ");
		System.out.println(hellos[0].hashCode());
		System.out.println(hellos[1].hashCode());
		
	}
	
}
