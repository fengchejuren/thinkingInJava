/**  
 * @Title: Philosopher.java 
 * @Package concurrency.section6 
 * @Description: TODO 
 * @author Rock King 2014骞�11鏈�28鏃� 涓婂崍12:46:32
 * @version V1.0  
 */ 
package concurrency.section6;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/** 
 * @Description: TODO
 * @author Rock King 2014骞�11鏈�28鏃� 涓婂崍12:46:32 
 * @see ~!^ Keep bugs away and code with U!	 
 */

public class Philosopher implements Runnable {

	private Chopstick left;
	private Chopstick right;
	private final int id;
	private final int pondarFactory;
	private Random random = new Random(47);
	private void pause() throws InterruptedException{
		if(pondarFactory==0) return;
		TimeUnit.MILLISECONDS.sleep(random.nextInt(pondarFactory*250));
	}
	
	/** 
	 * <p>Title: </p> 
	 * <p>Description: </p> 
	 * @param left
	 * @param right
	 * @param id
	 * @param pondarFactory 
	 */
	public Philosopher(Chopstick left, Chopstick right, int id,
			int pondarFactory) {
		this.left = left;
		this.right = right;
		this.id = id;
		this.pondarFactory = pondarFactory;
	}


	public void run() {
		try {
			while(!Thread.interrupted()){
				System.out.println(this+" thinking...");
				pause();
				System.out.println(this + " grabbing left");
				left.take();
				System.out.println(this + " eating");
				pause();
				left.drop();
				right.drop();
			}
		} catch (InterruptedException e) {
			System.out.println(this + " exiting via interrupt");
		}
	}
	
	/* (闈� Javadoc) 
	 * <p>Title: toString</p> 
	 * <p>Description: </p> 
	 * @return 
	 * @see java.lang.Object#toString() 
	 */ 
	@Override
	public String toString() {
		return "Philosopher "+id;
	}

}
