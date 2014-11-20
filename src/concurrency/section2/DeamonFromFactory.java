/**  
 * @Title: DeamonFromFactory.java 
 * @Package concurrency.secrtion2 
 * @Description: TODO 
 * @author Rock King 2014年11月21日 上午12:08:34
 * @version V1.0  
 */ 
package concurrency.section2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/** 
 * @Description: TODO
 * @author Rock King 2014年11月21日 上午12:08:34 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class DeamonFromFactory implements Runnable{

	
	/* (非 Javadoc) 
	 * <p>Title: run</p> 
	 * <p>Description: </p>  
	 * @see java.lang.Runnable#run() 
	 */ 
	@Override
	public void run() {
		try {
			while(true){
				TimeUnit.MILLISECONDS.sleep(500);
				System.out.println(Thread.currentThread()+" "+this);
			}
		} catch (InterruptedException e) {
			System.out.println("Interrupted");
		}
	}
	
	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool(new DaemonThreadFactory());
		for(int i=0;i<10;i++)
			exec.execute(new DeamonFromFactory());
		System.out.println("All deamon Started!");
		TimeUnit.MILLISECONDS.sleep(500);
		
		
	}

}
