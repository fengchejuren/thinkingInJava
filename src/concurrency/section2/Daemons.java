/**  
 * @Title: Daemons.java 
 * @Package concurrency.secrtion2 
 * @Description: TODO 
 * @author Rock King 2014年11月21日 上午12:28:35
 * @version V1.0  
 */
package concurrency.section2;

import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @author Rock King 2014年11月21日 上午12:28:35
 * @see ~!^ Keep bugs away and code with U!
 */

class Daemon implements Runnable {

	private Thread[] threads = new Thread[10];

	/*
	 * (非 Javadoc) <p>Title: run</p> <p>Description: </p>
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(new DaemonSpawn());
			threads[i].start();
			System.out.println("DaemonSpawn" + i + " started!");
		}
		for (int i = 0; i < threads.length; i++) {
			System.out.print("threads[" + i + "].isDaemon()="
					+ threads[i].isDaemon() + "...");
		}
	}

}

class DaemonSpawn implements Runnable {

	/*
	 * (非 Javadoc) <p>Title: run</p> <p>Description: </p>
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while (true)
			Thread.yield();
	}

}

public class Daemons{
	
	public static void main(String[] args) throws InterruptedException {
		Thread d = new Thread(new Daemon());
		d.setDaemon(true);
		d.start();
		System.out.println("d.isDaemon()="+d.isDaemon()+".");
		TimeUnit.SECONDS.sleep(1);
		
		
		
	}
	
	
	
}
