package concurrency.section5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

import concurrency.section2.LiftOff;

class LiftOffRunner2 implements Runnable {

	private BlockingQueue<LiftOff> rockets ;
	
	public LiftOffRunner2(BlockingQueue<LiftOff> queue){
		this.rockets = queue;
	}
	
	public void add(LiftOff liftOff){
		try {
			rockets.put(liftOff);
		} catch (InterruptedException e) {
			System.out.println("Interruped in put().");
		}
	}
	
	public void run() {
		try {
			while(!Thread.interrupted()){
				LiftOff rocket = rockets.take();
				rocket.run();
			}
		} catch (InterruptedException e) {
			System.out.println("Walking from take()");
		}
		System.out.println("Exiting LiftOff Runner");
	}

}

 
 public class TestBlockQueues{
	 static void getKey(){
		 try {
			new BufferedReader(new InputStreamReader(System.in)).readLine();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	 }
	 static void getKey(String msg){
		 System.out.println(msg);
		 getKey();
	 }
	 static void test(String msg,BlockingQueue<LiftOff> rocktes){
		 System.out.println(msg);
		 LiftOffRunner2 runner = new LiftOffRunner2(rocktes);
		 Thread t = new Thread(runner);
		 t.start();
		 for(int i=0;i<5;i++){
			 runner.add(new LiftOff(5));
		 }
		 getKey("Press Enter "+msg);
		 t.interrupt();
		 System.out.println("Finished test "+msg);
	 }
	 
	 
	 public static void main(String[] args) {
		 test("LinkedBlockingQueue", new LinkedBlockingQueue<LiftOff>());
		 test("ArrayBlockingQueue", new ArrayBlockingQueue<LiftOff>(3));
		 test("SynchronousQueue", new SynchronousQueue<LiftOff>());
		 
	}
	 
	 
 }
 