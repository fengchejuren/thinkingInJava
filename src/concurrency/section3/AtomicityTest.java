package concurrency.section3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AtomicityTest implements Runnable {

	private int i=0;
	
	public int getValue(){
		return i;
	}
	
	private synchronized void evenIncrement(){i++;i++;};
	
	public void run() {
		while(true)
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				evenIncrement();
			}
	}

	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		AtomicityTest atomicityTest = new AtomicityTest();
		exec.execute(atomicityTest);
		while(true){
			int val = atomicityTest.getValue();
			if(val%2!=0){
				System.out.println(val);
				System.exit(0);
			}
		}
	}
}
