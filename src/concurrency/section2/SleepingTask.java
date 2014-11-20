/**  
 * @Title: SleepingTask.java 
 * @Package concurrency 
 * @Description: TODO 
 * @author Rock King 2014年11月19日 下午10:55:23
 * @version V1.0  
 */ 
package concurrency.section2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/** 
 * @Description: TODO
 * @author Rock King 2014年11月19日 下午10:55:23 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class SleepingTask extends LiftOff{

	/* (非 Javadoc) 
	 * <p>Title: run</p> 
	 * <p>Description: </p>  
	 * @see concurrency.LiftOff#run() 
	 */ 
	@Override
	public void run() {
		try {
			while(countdown-->0){
				System.out.println(status());
				TimeUnit.MILLISECONDS.sleep(100);
			}
		} catch (InterruptedException e) {
			System.out.println("Interuptted");
		}
	}
	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++){
			exec.execute(new SleepingTask());
		}
		exec.shutdown();
	}
}
