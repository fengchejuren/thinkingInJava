/**  
 * @Title: DaemonDontRunFinally.java 
 * @Package concurrency.secrtion2 
 * @Description: TODO 
 * @author Rock King 2014年11月21日 上午12:44:52
 * @version V1.0  
 */ 
package concurrency.section2;

import java.util.concurrent.TimeUnit;

/** 
 * @Description: TODO
 * @author Rock King 2014年11月21日 上午12:44:52 
 * @see ~!^ Keep bugs away and code with U!	 
 */
class ADaemon implements Runnable{

	/* (非 Javadoc) 
	 * <p>Title: run</p> 
	 * <p>Description: </p>  
	 * @see java.lang.Runnable#run() 
	 */ 
	@Override
	public void run() {
		try {
			System.out.println("ADaemon is started");
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			System.out.println("Exiting via InterruptedException");
		}finally{
			System.out.println("This should arrays run?");
		}
	}
	
}
public class DaemonDontRunFinally {

	public static void main(String[] args) {
		Thread t = new Thread(new ADaemon());
		t.setDaemon(true);
		t.start();
	}
}
