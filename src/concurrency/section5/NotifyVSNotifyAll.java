package concurrency.section5;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**nofifyAll并不是唤醒‘所有正在等待的任务’，而是当notifyAll()因某个特定锁而被调用时，只有等待这个锁的任务才会被唤醒
 * @author Administrator
 *
 */

class Blocker{
	synchronized void waitingCall(){
		try {
			while(!Thread.interrupted()){
				wait();
				System.out.print(Thread.currentThread()+" ---");
			}
		} catch (InterruptedException e) {
			
		}
	}
	
	synchronized void prod(){notify();}
	
	synchronized void prodAll(){notifyAll();}
}

class Task implements Runnable{

	static Blocker blocker = new Blocker();
	public void run() {
		blocker.waitingCall();
	}
}

class Task2 implements Runnable{
	// a separate Blocker Object
	static Blocker blocker = new Blocker();
	public void run() {
		blocker.waitingCall();
	}
}

public class NotifyVSNotifyAll {

	public static void main(String[] args)throws Exception {
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i=0;i<5;i++)
			exec.execute(new Task());
		exec.execute(new Task2());
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			boolean prod = true;
			@Override
			public void run() {
				if(prod){
					System.out.print("\nnotify() ");
					Task.blocker.prod();
					prod = false;
				}else{	
					System.out.print("\nnotifyAll() ");
					Task.blocker.prodAll();
					prod = true;
				}
			}
		},400,400);
		TimeUnit.SECONDS.sleep(5);
		timer.cancel();
		System.out.println("\nTimer canceled");
		TimeUnit.MILLISECONDS.sleep(500);
		System.out.println("\nTask2.blocker.prodAll()");
		Task2.blocker.prodAll();
		TimeUnit.MILLISECONDS.sleep(500);
		System.out.println("\nShutting down");
		exec.shutdownNow();
		
	}
	
}
