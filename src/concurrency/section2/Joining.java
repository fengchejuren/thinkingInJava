/**  
 * @Title: Joinning.java 
 * @Package concurrency.section2 
 * @Description: TODO 
 * @author Rock King 2014年11月26日 上午12:00:08
 * @version V1.0  
 */
package concurrency.section2;

/**
 * @Description: TODO
 * @author Rock King 2014年11月26日 上午12:00:08
 * @see ~!^ Keep bugs away and code with U!
 */
class Sleeper extends Thread {
	private int duration;

	public Sleeper(String name, int count) {
		super(name);
		duration = count;
		start();
	}

	/*
	 * (非 Javadoc) <p>Title: run</p> <p>Description: </p>
	 * 
	 * @see java.lang.Thread#run()
	 */
	@Override
	public void run() {
		try {
			sleep(duration);
		} catch (InterruptedException e) {
			System.out.println(getName() + " was interrupted. is interrupted:"
					+ isInterrupted());
			return;
		}
		System.out.println(getName()+" has awakened!");
	}
}

class Joinner extends Thread{
	private Sleeper sleeper;
	public Joinner(String name,Sleeper sleeper){
		super(name);
		this.sleeper = sleeper;
		start();
	}
	/* (非 Javadoc) 
	 * <p>Title: run</p> 
	 * <p>Description: </p>  
	 * @see java.lang.Thread#run() 
	 */ 
	@Override
	public void run() {
		try {
			sleeper.join();
		} catch (InterruptedException e) {
			System.out.println("interrupted");
		}
		System.out.println(getName()+"joining completed!");
	}
}
public class Joining {

	public static void main(String[] args) {
		Sleeper 
			sleeper = new Sleeper("Sleeper", 1500),
			grumpy = new Sleeper("Grumpy", 1500);
		Joinner 
		 	dopey = new Joinner("Dopey", sleeper),
		 	doc = new Joinner("Doc", grumpy);
		grumpy.interrupt();
		
		
	}
}
