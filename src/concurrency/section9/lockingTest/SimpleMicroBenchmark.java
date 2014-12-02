package concurrency.section9.lockingTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

abstract class Incrementable{
	protected int counter = 0;
	public abstract void increment();
}

class SynchronizingTest extends Incrementable{

	@Override
	public void increment() {
		++counter;
	}
	
}

class LockingTest extends Incrementable{

	private Lock lock = new ReentrantLock();
	
	@Override
	public void increment() {
		lock.lock();
		try {
			++counter;
		} finally {
			lock.unlock();
		}
	}
	
}
public class SimpleMicroBenchmark {

	static long test(Incrementable incrementable){
		long start = System.nanoTime();
		for(int i=0;i<10000000L;i++){
			incrementable.increment();
		}
		return System.nanoTime()-start;
	}
	
	public static void main(String[] args) {
		long synchronizeTime = test(new SynchronizingTest());
		long lockingTime = test(new LockingTest());
		System.out.printf("synchronize:%1$10d\n",synchronizeTime);
		System.out.printf("lock:%1$10d\n",lockingTime);
		System.out.printf("lock/synchronize=%1$.3f",(double)lockingTime/(double)synchronizeTime);
		
	}
}
