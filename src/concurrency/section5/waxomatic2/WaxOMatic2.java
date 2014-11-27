package concurrency.section5.waxomatic2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Car{
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	private boolean waxOn = false;
	public void waxed(){
		lock.lock();
		try {
			waxOn = true;	//ready to buff
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}
	
	public void buffed(){
		lock.lock();
		try {
			waxOn = false;		//ready for another coat of wax
			condition.signalAll();
		} finally {
			lock.unlock();
		}
	}
	
	public void waitingForWaxing() throws InterruptedException{
		lock.lock();
		try {
			while(waxOn==false){
				condition.await();
			}
		}finally {
			lock.unlock();
		}
	}
	
	public void waitingForBuffing() throws InterruptedException{
		lock.lock();
		try {
			while(waxOn==true){
				condition.await();
			}
		}finally {
			lock.unlock();
		}
	}
}

class WaxOn implements Runnable{

	private Car car;
	public WaxOn(Car car){this.car = car;}
	public void run() {
		try {
			while(!Thread.interrupted()){
				System.out.print("Wax On  ");
				TimeUnit.MILLISECONDS.sleep(500);
				car.waxed();
				car.waitingForBuffing();
			}
		} catch (Exception e) {
			System.out.println("Exiting Interrupting via ");
		}
		System.out.println("Ending Wax on Task");
	}
}

class WaxOff implements Runnable{

	private Car car;
	public WaxOff(Car car){this.car = car;}
	
	public void run() {
		try {
			while(!Thread.interrupted()){
				car.waitingForWaxing();
				System.out.println("Wax off");
				TimeUnit.MILLISECONDS.sleep(500);
				car.buffed();
			}
		} catch (Exception e) {
			System.out.println("Exiting via interrupted");
		}
		System.out.println("Ending Wax Off Task!");
	}
	
}

public class WaxOMatic2 {

	public static void main(String[] args) throws InterruptedException {
		Car car = new Car();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new WaxOff(car));
		exec.execute(new WaxOn(car));
		TimeUnit.SECONDS.sleep(10);
		exec.shutdownNow();
		
	}
	
	
}
