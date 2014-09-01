/**
 * 
 */
package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**第20章 20.3使用apt处理注解
 * 搞不懂这个使用apt处理注解到底是怎么运行的
 * @author Administrator
 *
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface ExtractInterface {

	public String value();
	

}
