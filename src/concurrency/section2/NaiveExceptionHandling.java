/**  
 * @Title: NaiveExceptionHolding.java 
 * @Package concurrency.section2 
 * @Description: TODO 
 * @author Rock King 2014年11月27日 上午12:06:50
 * @version V1.0  
 */ 
package concurrency.section2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * @Description: TODO
 * @author Rock King 2014年11月27日 上午12:06:50 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class NaiveExceptionHandling {

	public static void main(String[] args) {
		try {
			ExecutorService exec = Executors.newCachedThreadPool();
			exec.execute(new ExceptionThread());
		} catch (RuntimeException e) {		//此异常没有捕获
			System.out.println("Exception has catched!");
		}
	}
}
