/**  
 * @Title: DeamonThreadPoolExectutor.java 
 * @Package utils 
 * @Description: TODO 
 * @author Rock King 2014年11月21日 上午12:17:59
 * @version V1.0  
 */
package utils;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import concurrency.section2.DaemonThreadFactory;

/**
 * @Description: TODO
 * @author Rock King 2014年11月21日 上午12:17:59
 * @see ~!^ Keep bugs away and code with U!
 */

public class DeamonThreadPoolExecutor extends ThreadPoolExecutor {

	public DeamonThreadPoolExecutor() {
		super(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS,
				new SynchronousQueue<Runnable>(), new DaemonThreadFactory());
	}

}
