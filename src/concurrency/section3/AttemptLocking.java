package concurrency.section3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class AttemptLocking {

	private ReentrantLock lock = new ReentrantLock();
	
	public void untimed(){
		boolean captured = lock.tryLock();
		try {
			System.out.println("try lock"+captured);
		} catch (Exception e) {
			if(captured)
				lock.unlock();
		}
	}
	
	
	public void timed(){
		boolean captured = lock.tryLock();
		try {
			captured = lock.tryLock(2, TimeUnit.SECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			System.out.println("try lock2 "+captured);
		} catch (Exception e) {
			if(captured)
				lock.unlock();
		}
		
	}
	
	public static void main(String[] args) {
		final AttemptLocking attemptLocking = new AttemptLocking();
		attemptLocking.untimed();	//true
		attemptLocking.timed();  //true
		new Thread(){
			{setDaemon(true);}
			public void run(){
				attemptLocking.lock.lock();
				System.out.println("acquired!");
			}
		}.start();
		Thread.yield();
		attemptLocking.untimed();
		attemptLocking.timed();
	}
	
	
	
}
