/**
 * 
 */
package atunit;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Administrator
 *
 */
@Target(ElementType.METHOD)			//注解将用于什么地方
@Retention(RetentionPolicy.RUNTIME)		//注解在哪一个级别可用：SOURCE-源代码中，CLASS-类文件中，RUNTIME-运行时
public @interface Test {

}
