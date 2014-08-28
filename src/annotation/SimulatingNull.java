/**
 * 
 */
package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**在注解元素中，对于非基本类型的注解元素，元素不能有不确定的值。也就是说，元素要么有默认值，要么有使用注解时提供的值
 * 其次，无论是声明时，还是使用时，注解的元素都不能以null值作为其元素值
 * @author Administrator
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SimulatingNull {

	public int id() default -1;
	public String description() default "";
}
