package generics;

/**CRG---古怪的循环泛型
 * 其本质是:基类用导出类代替其参数
 * 这意味着泛型的基类变成了其所有导出类的公共功能的模板
 * @author Administrator
 *
 */
class SubType extends BasicHolder<SubType>{}
public class CRGWithBasicHolder {

	public static void main(String[] args) {
		SubType custType1 = new SubType(), custType2 = new SubType();
		custType1.set(custType2);
		SubType subType3 = custType1.get();
		custType1.f();
	}
}
