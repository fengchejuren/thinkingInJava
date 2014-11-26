/**  
 * @Title: SettingDefaultHandler.java 
 * @Package concurrency.section2 
 * @Description: TODO 
 * @author Rock King 2014年11月27日 上午12:23:15
 * @version V1.0  
 */ 
package concurrency.section2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * @Description: TODO
 * @author Rock King 2014年11月27日 上午12:23:15 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class SettingDefaultHandler {

	public static void main(String[] args) {
		//将处理器设为默认的未捕获异常处理器
		Thread.setDefaultUncaughtExceptionHandler(new MyUnCaughtExceptionHandler());
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new ExceptionThread());
	}
}
