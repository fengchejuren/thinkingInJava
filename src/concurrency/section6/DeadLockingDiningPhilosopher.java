/**  
 * @Title: DeadLockingDining.java 
 * @Package concurrency.section6 
 * @Description: TODO 
 * @author Rock King 2014年11月28日 上午1:00:12
 * @version V1.0  
 */ 
package concurrency.section6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/** 
 * @Description: 很容易产生死锁
 * @author Rock King 2014年11月28日 上午1:00:12 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class DeadLockingDiningPhilosopher {

	public static void main(String[] args) throws Exception{
		int ponder = 5;
		if(args.length>0)
			ponder = Integer.parseInt(args[0]);
		int size = 5;
		if(args.length>1)
			size = Integer.parseInt(args[1]);
		ExecutorService exec = Executors.newCachedThreadPool();
		Chopstick[] sticks = new Chopstick[size];
		for(int i=0;i<size;i++)
			sticks[i] = new Chopstick();
		for(int i=0;i<size;i++){
			exec.execute(new Philosopher(sticks[i], sticks[(i+1)%size], i, ponder));
		}
		if(args.length==3&&args[2].equals("timeout"))
			TimeUnit.SECONDS.sleep(5);
		else{
			System.out.println("Press enter to quit");
			System.in.read();
		}
		exec.shutdownNow();
		
	}
	
}
