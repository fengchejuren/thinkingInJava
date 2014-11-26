package concurrency.section3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ExplicitPairManager1 extends PairManager{

	private Lock lock = new ReentrantLock();
	@Override
	public synchronized void increment() {
		lock.lock();
		try {
			p.incrementX();
			p.incrementY();
			storage(getPair());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("lock.unclock()");
			lock.unlock();
		}
		
	}
	
}
//use a critical section
class ExplicitPairManager2 extends PairManager{

	private Lock lock = new ReentrantLock();
	
	@Override
	public void increment() {
		Pair tempPair ;
		lock.lock();
		try {
			p.incrementX();
			p.incrementY();
			tempPair = getPair();
		} finally {
			lock.unlock();
		}
		storage(tempPair);
	}
	
}
public class ExplicitCriticalSection {

	public static void main(String[] args) {
		PairManager
			pman1 = new ExplicitPairManager1(),
			pman2 = new ExplicitPairManager2();
		CriticalSection.testApproaches(pman1, pman2);
	}
}
