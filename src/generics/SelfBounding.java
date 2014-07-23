package generics;



/** 
 * @ClassName: SelfBounded 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author RockKing 
 * @date 2014年7月24日 上午12:23:11 
 * @param <T> 
 */ 
class SelfBounded<T extends SelfBounded<T>> {
	T element;

	SelfBounded<T> set(T selfBounded) {
		element = selfBounded;
		return this;
	}

	T get() {
		return element;
	}
}

class A extends SelfBounded<A> {
}

class B extends SelfBounded<A> {
}

class C extends SelfBounded<C> {
	/** 
	 * @Title: setAndGet 
	 * @Description: TODO 
	 * @param @param arg
	 * @param @return   
	 * @return C  
	 * @throws 
	 * @see Any changes please send mail to:superman166@126.com ~!~KEEP BUG AWAY AND CODE WITH U! 
	 */
	C setAndGet(C arg) {
		set(arg);
		return get();
	}
}

class D {
}

/**
 * can't do this compile Error
 * 
 */
// class E extends SelfBounded<D>{}

/**
 * it is OK
 * 
 */
class F extends SelfBounded {
}


/** 
 * @ClassName: SelfBounding 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Rock King
 * @date Jul 24, 2014 1:02:58 AM  
 */ 
public class SelfBounding {

	/** 
	 * @Title: main 
	 * @Description: TODO 
	 * @param @param args   
	 * @return void  
	 * @throws 
	 * @see Any changes please send mail to:superman166@126.com ~!~KEEP BUG AWAY AND CODE WITH U! 
	 */
	public static void main(String[] args) {
		A a = new A();
		a.set(new A());
		a = a.set(new A()).get();
		a = a.get();
		C c = new C();
		c = c.setAndGet(new C());
	}
}
