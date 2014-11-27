package concurrency.section5.waxomatic;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**ģ������׹�ʹ�������������׹�����
 * wax ������
 * buffing �׹�
 * @author Administrator
 *
 */
class Car{
	private boolean waxOn = false;
	public synchronized void waxed(){
		waxOn = true; //Ready to Buff
		notifyAll();
	}
	public synchronized void buffed(){
		waxOn = false;	//waiting for another coat of car
		notifyAll();
	}
	public synchronized void waitForWaxing() throws InterruptedException{
		while(waxOn==false)
			wait();
	}
	public synchronized void waitForBuffing() throws InterruptedException{
		while(waxOn==true)
			wait();
	}
}

class WaxOn implements Runnable{

	private Car car;
	public WaxOn(Car car){this.car = car;}
	public void run() {
		try {
			while(!Thread.interrupted()){
				System.out.println("  Wax On!");
				TimeUnit.MILLISECONDS.sleep(100);
				car.waxed();
				car.waitForBuffing();
			}
		} catch (InterruptedException e) {
			System.out.println("  Exiting via interrupt!");
		}
		System.out.println("  Ending Wax On Task...");
	}
	
}

class WaxOff implements Runnable{

	private Car car;
	public WaxOff(Car car){this.car = car;}
	public void run() {
		try {
			while(!Thread.interrupted()){
				car.waitForWaxing();
				System.out.println("  Wax Off");
				TimeUnit.MILLISECONDS.sleep(200);
				car.buffed();
			}
		} catch (Exception e) {
			System.out.println("  Exiting via interrupted");
		}
		System.out.println("  Ending Wax Off Task");
	}
	
	
}


public class WaxOMatic {

	public static void main(String[] args) throws Exception {
		Car car = new Car();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new WaxOff(car));
		exec.execute(new WaxOn(car));
		TimeUnit.SECONDS.sleep(15);
		exec.shutdownNow();
		
	}
	
	
}
