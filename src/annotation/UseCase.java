/**
 * 
 */
package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**这个是一个简单的注解，我们可以用它来跟踪一个项目中的用例。
 * 如果一个方法或者一组方法实现了某个用例的需求，那么我们可以为此方法加上注解。
 * 于是，项目经理通过计算实现的用例就可以很好的掌握项目的进度
 * 而如果要更新或者修改系统的业务逻辑，则维护该项目的开发人员也可以很容易的在项目中找到对应的用例
 * @author Administrator
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UseCase {

	public int id();
	
	public String descripting() default "no descripting";
}
