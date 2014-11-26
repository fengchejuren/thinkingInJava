/**  
 * @Title: SimplePriorities.java 
 * @Package concurrency 
 * @Description: TODO 
 * @author Rock King 2014年11月19日 下午11:13:53
 * @version V1.0  
 */ 
package concurrency.section2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** 
 * @Description: TODO
 * @author Rock King 2014年11月19日 下午11:13:53 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class SimplePriorities implements Runnable {

	private int countdown = 5;
	private volatile double d;
	private int priority;
	
	public SimplePriorities(int priority){
		this.priority = priority;
	}
	/* (非 Javadoc) 
	 * <p>Title: toString</p> 
	 * <p>Description: </p> 
	 * @return 
	 * @see java.lang.Object#toString() 
	 */ 
	@Override
	public String toString() {
		return "Thread "+Thread.currentThread()+":"+countdown;
	}
	
	/* (非 Javadoc) 
	 * <p>Title: run</p> 
	 * <p>Description: </p>  
	 * @see java.lang.Runnable#run() 
	 */ 
	@Override
	public void run() {
		Thread.currentThread().setPriority(priority);
		while(true){
			for(int i=0;i<100000;i++){
				d+=(Math.PI+Math.E)/(double)i ;
				if(i%1000==0)
					Thread.yield();
			}
			System.out.println(this);
			if(--countdown==0)
				return;
		}
		
	}

	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++)
			exec.execute(new SimplePriorities(Thread.MIN_PRIORITY));
		exec.execute(new SimplePriorities(Thread.MAX_PRIORITY));
		exec.shutdown();
		
	}
}
