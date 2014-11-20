/**  
 * @Title: SingleThread.java 
 * @Package concurrency 
 * @Description: TODO 
 * @author Rock King 2014年11月19日 上午12:58:09
 * @version V1.0  
 */ 
package concurrency.section2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * @Description: TODO
 * @author Rock King 2014年11月19日 上午12:58:09 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class SingleThreadExecutor {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newSingleThreadExecutor();
		for(int i=0;i<5;i++)
			exec.execute(new LiftOff());
		exec.shutdown();
	}
}
