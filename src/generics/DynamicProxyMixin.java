package generics;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

class Mixin implements InvocationHandler{

	Map<String, Object> delegatesByMethod;
	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2)
			throws Throwable {
		// TODO Auto-generated method stub
		return null;
	}
	
}

/** 可以使用动态代理来实现一种比装饰器模式更贴近混合模式的机制
 * @ClassName: DynamicProxyMixin 
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author Rock King
 * @date 2014年7月26日 上午11:31:58  
 */ 
public class DynamicProxyMixin {

}
