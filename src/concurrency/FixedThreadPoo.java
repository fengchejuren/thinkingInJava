/**  
 * @Title: FixedThreadPoo.java 
 * @Package concurrency 
 * @Description: TODO 
 * @author Rock King 2014年11月19日 上午12:53:58
 * @version V1.0  
 */
package concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Description: TODO
 * @author Rock King 2014年11月19日 上午12:53:58
 * @see ~!^ Keep bugs away and code with U!
 */

public class FixedThreadPoo {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newFixedThreadPool(5);
		for(int i=0;i<5;i++)
			exec.execute(new LiftOff());
		exec.shutdown();
		
		
	}
}
