/**  
 * @Title: SimpleDaemons.java 
 * @Package concurrency 
 * @Description: TODO 
 * @author Rock King 2014年11月20日 上午12:05:56
 * @version V1.0  
 */ 
package concurrency.section2;

import java.util.concurrent.TimeUnit;

/** 
 * @Description: TODO
 * @author Rock King 2014年11月20日 上午12:05:56 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class SimpleDaemons implements Runnable {

	/* (非 Javadoc) 
	 * <p>Title: run</p> 
	 * <p>Description: </p>  
	 * @see java.lang.Runnable#run() 
	 */ 
	@Override
	public void run() {
		while(true){
			try {
				TimeUnit.MILLISECONDS.sleep(100);
				System.out.println("Thread "+Thread.currentThread()+" "+this);
			} catch (InterruptedException e) {
				System.out.println("Sleeping interrupted!");
			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		for(int i=0;i<10;i++){
			Thread deam = new Thread(new SimpleDaemons());
			deam.setDaemon(true);
			deam.start();
		}
		System.out.println("All deam Sleep!");
		TimeUnit.MILLISECONDS.sleep(100);
	}
}
