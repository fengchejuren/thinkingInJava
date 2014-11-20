/**  
 * @Title: DaenThreadFactory.java 
 * @Package concurrency.secrtion2 
 * @Description: TODO 
 * @author Rock King 2014年11月21日 上午12:04:11
 * @version V1.0  
 */ 
package concurrency.section2;

import java.util.concurrent.ThreadFactory;

/** 
 * @Description: TODO
 * @author Rock King 2014年11月21日 上午12:04:11 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class DaemonThreadFactory implements ThreadFactory {

	/* (非 Javadoc) 
	 * <p>Title: newThread</p> 
	 * <p>Description: </p> 
	 * @param r
	 * @return 
	 * @see java.util.concurrent.ThreadFactory#newThread(java.lang.Runnable) 
	 */ 
	@Override
	public Thread newThread(Runnable r) {
		Thread t  = new Thread(r);
		t.setDaemon(true);
		return t;
	}

	
	
	
	
}
