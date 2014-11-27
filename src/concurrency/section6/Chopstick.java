/**  
 * @Title: Chopstic.java 
 * @Package concurrency.section6 
 * @Description: TODO 
 * @author Rock King 2014年11月28日 上午12:41:20
 * @version V1.0  
 */ 
package concurrency.section6;

/** 
 * @Description: TODO
 * @author Rock King 2014年11月28日 上午12:41:20 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class Chopstick {

	private boolean taken = false;
	
	public synchronized void take() throws InterruptedException{
		while(taken)
			wait();
		taken = true;
	}
	
	public synchronized void drop(){
		taken = false;
		notifyAll();
	}
}
