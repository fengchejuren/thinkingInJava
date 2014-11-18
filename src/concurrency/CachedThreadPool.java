/**  
 * @Title: CachedThreadPool.java 
 * @Package concurrency 
 * @Description: TODO 
 * @author Rock King 2014年11月19日 上午12:48:53
 * @version V1.0  
 */ 
package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * @Description: TODO
 * @author Rock King 2014年11月19日 上午12:48:53 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class CachedThreadPool {

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++)
			exec.execute(new LiftOff());
		exec.shutdown();
	}
	
	
	
	
	
	
	
	
}
