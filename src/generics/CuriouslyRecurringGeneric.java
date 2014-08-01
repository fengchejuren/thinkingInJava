package generics;

class GenericType<T> {
}

/**古怪的循环泛型
 * 创建一个新类,继承自一个泛型类型,这个泛型类型接受新类作为其参数
 * @author Administrator
 *
 */
public class CuriouslyRecurringGeneric extends
		GenericType<CuriouslyRecurringGeneric> {

}
