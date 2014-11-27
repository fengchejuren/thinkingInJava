package concurrency.section5;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 饭店 有一个厨师和一个服务员，服务员必须等待厨师准备好饭菜。当厨师准备好以后，通知服务员。之后服务员上菜，之后继续等待
 * 
 * @author Administrator
 * 
 */

class Meal {
	private int orderNum;

	public Meal(int orderNum) {
		this.orderNum = orderNum;
	}

	@Override
	public String toString() {
		return "Meal " + orderNum;
	}
}

class WaitPerson implements Runnable {

	private Restaurant r;

	public WaitPerson(Restaurant r) {
		this.r = r;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					if (r.meal == null)
						wait(); // for the chef to product meal
				}
				System.out.println("waitPerson got " + r.meal);
				synchronized (r.chef) {
					r.meal = null;
					r.chef.notifyAll(); // ready for another
				}
			}
		} catch (Exception e) {
			System.out.println("waitPerson interrupted!");
		}
	}

}

class Chef implements Runnable {

	private Restaurant r;
	private int count = 0;

	public Chef(Restaurant r) {
		this.r = r;
	}

	public void run() {
		try {
			while (!Thread.interrupted()) {
				synchronized (this) {
					if (r.meal != null) {
						wait();
					}
				}
				if (++count == 10) {
					System.out.println("out of food,closing");
					r.exec.shutdownNow();
				}
				System.out.print(" Order up!");
				synchronized (r.waitPerson) {
					r.meal = new Meal(count);
					r.waitPerson.notifyAll();
				}
				TimeUnit.SECONDS.sleep(3);
			}
		} catch (Exception e) {
			System.out.println("Chef interrupted!");
		}
	}

}

public class Restaurant {

	Meal meal;
	ExecutorService exec = Executors.newCachedThreadPool();
	WaitPerson waitPerson = new WaitPerson(this);
	Chef chef = new Chef(this);

	public Restaurant() {
		exec.execute(chef);
		exec.execute(waitPerson);
	}

	public static void main(String[] args) {
		new Restaurant();
	}

}
