package concurrency.section4;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BlockMute{
	private Lock lock = new ReentrantLock();
	public BlockMute(){
		//acquire it right away,to demonstrate interruption of a task block of a ReentrantLock
		lock.lock();
	}
	
	public void f(){
		try {
			//this will never been available on a second task 
			lock.lockInterruptibly();	//special call();
			System.out.println("lock aquired in f()");
		} catch (InterruptedException e) {
			System.out.println("Interrupted from lock in f() ");
		}
	}
}

class BlockMute2 implements Runnable{
	BlockMute blocked = new BlockMute();
	public void run() {
		System.out.println("wating for f() in BlockMute");
		blocked.f();
		System.out.println("Broken out off block call!");
	}
	
}
public class Interrupting2 {

	public static void main(String[] args) throws Exception {
		Thread t = new Thread(new BlockMute2());
		t.start();
		TimeUnit.SECONDS.sleep(2);
		System.out.println("issuing t.interrupt()");
		t.interrupt();
	}
	
}
