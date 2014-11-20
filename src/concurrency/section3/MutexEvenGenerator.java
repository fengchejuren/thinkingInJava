package concurrency.section3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MutexEvenGenerator extends IntGenerator {

	private int currentEven = 0;
	private Lock lock = new ReentrantLock();
	
	@Override
	public int next() {
		try {
			lock.lock();
			++currentEven;		//danger pointer here
			++currentEven;
			return currentEven;
		}finally{
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		EvenChecker.test(new MutexEvenGenerator());
	}

}
