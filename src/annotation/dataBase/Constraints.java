/**
 * 
 */
package annotation.dataBase;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Administrator
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Constraints {

	boolean primarkKey() default false;
	boolean allowNull() default true;
	boolean unique() default false;
	
}
