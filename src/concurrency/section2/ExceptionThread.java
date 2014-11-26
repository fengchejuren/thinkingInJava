/**  
 * @Title: ExceptionThread.java 
 * @Package concurrency.section2 
 * @Description: TODO 
 * @author Rock King 2014年11月27日 上午12:02:55
 * @version V1.0  
 */ 
package concurrency.section2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * @Description: TODO
 * @author Rock King 2014年11月27日 上午12:02:55 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class ExceptionThread implements Runnable {

	/* (非 Javadoc) 
	 * <p>Title: run</p> 
	 * <p>Description: </p>  
	 * @see java.lang.Runnable#run() 
	 */ 
	@Override
	public void run() {
		throw new RuntimeException();
	}

	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new ExceptionThread());
	}
}
