package containers;

/**
 * 一个测试类的基类
 * 
 * @author Administrator
 * 
 */
public abstract class Test<C> {

	String name;

	public Test(String name) {
		this.name = name;
	}
	
	abstract int test(C container,TestParam param);
	
}
