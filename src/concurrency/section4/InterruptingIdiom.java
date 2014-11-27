package concurrency.section4;

import java.util.concurrent.TimeUnit;

class NeedsCleanup{
	private final int id;
	public NeedsCleanup(int id){
		this.id = id;
		System.out.println("NeedsCleanup "+id);
	}
	public void cleanup(){
		System.out.println("cleanup "+id);
	}
	
}

class Block3 implements Runnable{

	private volatile double d = 0.0;
	
	public void run() {
		try {
			while(!Thread.interrupted()){
				NeedsCleanup n1 = new NeedsCleanup(1);
				try {
					System.out.println("Sleeping");
					TimeUnit.SECONDS.sleep(5);
					NeedsCleanup n2 = new NeedsCleanup(2);
					try {
						System.out.println("Caculating");
						for(int i=0;i<2500000;i++)
							d = d + (Math.E+Math.PI)/d;
						System.out.println("finished time_consume operation!");
					} finally {
						n2.cleanup();
					}
				} finally{
					n1.cleanup();
				}
			}
			System.out.println("Exiting via while test()");
		} catch (Exception e) {
			System.out.println("Exiting via interruption");
		}
	}
	
}
public class InterruptingIdiom {

	public static void main(String[] args) throws Exception {
		if(args.length != 1){
			System.out.println("java exiting 5 delay-seconds");
			System.exit(1);
		}
		Thread t = new Thread(new Block3());
		t.start();
		TimeUnit.SECONDS.sleep(new Integer(args[0]));
		t.interrupt();
		
	}
}
