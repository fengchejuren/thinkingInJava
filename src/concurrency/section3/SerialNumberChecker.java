package concurrency.section3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class CircularSet{
	private int[] array;
	private int len;
	private int index=0;
	
	public CircularSet(int size){
		array = new int[size];
		len = size;
		for(int i=0;i<array.length;i++){
			array[i] = -1;
		}
	}
	
	public synchronized void add(int i){
		array[index] = i;
		index = ++index%len;
	}
	
	public synchronized boolean contains(int val){
		for(int i=0;i<len;i++)
			if(val == array[i]) return true;
		return false;
	}
}
public class SerialNumberChecker {

	private static final int SIZE = 10;
	private static CircularSet circularSet = new CircularSet(1000);
	private static ExecutorService exec = Executors.newCachedThreadPool();
	static class SerialChecker implements Runnable{

		public void run() {
			while(true){
				int serialNumber = SerialNumberGenerator.nextSerialNumber();
				if(circularSet.contains(serialNumber)){
					System.out.println("Duplicate "+serialNumber);
					System.exit(0);
				}
				circularSet.add(serialNumber);
			}
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		for(int i=0;i<SIZE;i++){
			exec.execute(new SerialChecker());
		}
		if(args.length>0){
			TimeUnit.SECONDS.sleep(1000);
			System.out.println("No Duplicate numbers...");
			System.exit(0);
		}
	}
	
}
