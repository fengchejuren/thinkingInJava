package concurrency.section5;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import concurrency.section5.Toast.Status;

/**制作吐司，给吐司抹黄油，在抹过黄油的吐司上涂上果酱
 * @author Administrator
 *
 */

class Toast{
	public enum Status{DRY,BUTTERED,JAMMED};
	private Status status = Status.DRY;
	private final int id;
	public Toast(int id){this.id = id;}
	public void butter(){status = Status.BUTTERED;}
	public void jam(){status = Status.JAMMED;}
	public Status getStatus(){
		return status;
	}
	public int getId(){
		return id;
	}
	@Override
	public String toString() {
		return "Toast "+id+":"+status;
	}
}

class ToastQueue extends LinkedBlockingQueue<Toast>{}

class Toaster implements Runnable{

	private ToastQueue tQueue;
	private int count;
	private Random random = new Random(47);
	public Toaster(ToastQueue tQueue){this.tQueue = tQueue;}
	public void run() {
		try {
			while(!Thread.interrupted()){
				TimeUnit.MILLISECONDS.sleep(100+random.nextInt(500));
				Toast t = new Toast(count++);
				System.out.println("Toaster :"+t);
				tQueue.put(t);
			}
		} catch (Exception e) {
			System.out.println("Toaster interrupted");
		}
		System.out.println("Toaster Off...");
	}
	
}

class Butterer implements Runnable{

	private ToastQueue dryQueue,butteredQueue;
	
	public Butterer(ToastQueue dryQueue, ToastQueue butteredQueue) {
		this.dryQueue = dryQueue;
		this.butteredQueue = butteredQueue;
	}

	public void run() {
		try {
			while(!Thread.interrupted()){
				Toast toast = dryQueue.take();
				toast.butter();
				System.out.println("Butterer :"+toast);
				butteredQueue.put(toast);
			}
		} catch (Exception e) {
			System.out.println("Butterer Interrupted!");
		}
		System.out.println("Butterer Off...");
	}
	
}

class Jammer implements Runnable{

	private ToastQueue buttererQueue,finishedQueue;
	public void run() {
		try {
			while(!Thread.interrupted()){
				Toast toast = buttererQueue.take();
				toast.jam();
				System.out.println("Jammer :"+toast);
				finishedQueue.put(toast);
			}
		} catch (Exception e) {
			System.out.println("Jammer Interrupted!");
		}
		System.out.println("Jamme Off...");
	}
	public Jammer(ToastQueue buttererQueue, ToastQueue finishedQueue) {
		this.buttererQueue = buttererQueue;
		this.finishedQueue = finishedQueue;
	}
	
}

class Eater implements Runnable{

	private ToastQueue finishedqQueue;
	private int count=0;
	
	public Eater(ToastQueue finishedqQueue) {
		this.finishedqQueue = finishedqQueue;
	}

	public void run() {
		try {
			while(!Thread.interrupted()){
				Toast toast = finishedqQueue.take();
				if(toast.getStatus()!=(Status.JAMMED)||toast.getId()!=count++){
					System.out.println(">>> Error:"+toast);
					System.exit(1);
				}else{
					System.out.println("Chomp! "+toast);
				}
			}
		} catch (Exception e) {
			System.out.println("Eater Interrupted!");
		}
		System.out.println("Eater Off...");
	}
	
}

public class ToastOmatic {

	public static void main(String[] args) throws Exception{
		ToastQueue dryqQueue = new ToastQueue(),
				   buttererQueue = new ToastQueue(),
				   finishedQueue = new ToastQueue();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new Toaster(dryqQueue));
		exec.execute(new Butterer(dryqQueue,buttererQueue));
		exec.execute(new Jammer(buttererQueue, finishedQueue));
		exec.execute(new Eater(finishedQueue));
		TimeUnit.SECONDS.sleep(5);
		exec.shutdownNow();
	}
}
