package concurrency.section9;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

abstract class Accumulator {
	public static long cycles = 50000L;
	public static final int N = 4;
	public static ExecutorService exec = Executors.newFixedThreadPool(N * 2);
	private static CyclicBarrier barrier = new CyclicBarrier(N * 2 + 1);
	protected volatile int index = 0;
	protected volatile long value = 0;
	protected volatile long duration = 0;
	protected String id = "error";
	protected static final int SIZE = 100000;
	protected static int[] preLoad = new int[SIZE];
	static {
		Random random = new Random(47);
		for (int i = 0; i < SIZE; i++)
			preLoad[i] = random.nextInt();
	}

	public abstract void accumulator();

	public abstract long read();

	private class Modifier implements Runnable {

		public void run() {
			for (long i = 0; i < cycles; i++)
				accumulator();
			try {
				barrier.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	private class Reader implements Runnable {

		private volatile long value;

		public void run() {
			for (long i = 0; i < cycles; i++)
				value = read();
			try {
				barrier.await();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void timedTest() {
		long start = System.nanoTime();
		for (int i = 0; i < N; i++) {
			exec.execute(new Modifier());
			exec.execute(new Reader());
		}
		try {
			barrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		duration = System.nanoTime() - start;
		System.out.printf("%-13s : %13d\n", id, duration);
	}

	public static void reported(Accumulator acc1, Accumulator acc2) {
		System.out.printf("%-22s: %.2f\n", acc1.id + "/" + acc2.id,
				(double) acc1.duration / (double) acc2.duration);
	}
}

class BaseLine extends Accumulator{

	{ id = "BaseLine";}
	@Override
	public void accumulator() {
		value += preLoad[index++];
		if(index>=SIZE)
			index = 0;
	}

	@Override
	public long read() {
		return value;
	} 
	
}

class SynchronizedTest extends Accumulator{
	{ id = "synchronize";}
	@Override
	public synchronized void accumulator() {
		value += preLoad[index++];
		if(index>=SIZE)
			index = 0;
	}

	@Override
	public synchronized long read() {
		return value;
	}
	
}

class LockingTest extends Accumulator{
	{ id = "Locking";}
	private Lock lock = new ReentrantLock();
	@Override
	public void accumulator() {
		lock.lock();
		try {
			value += preLoad[index++];
			if (index >= SIZE)
				index = 0;
		} finally {
			lock.unlock();
		}
	}
	
	@Override
	public long read() {
		lock.lock();
		try {
			return value;
		} finally {
			lock.unlock();
		}
	}
	
}

class AtomicTest extends Accumulator{
	{ id = "Atomic";}
	private AtomicInteger index = new AtomicInteger(0);
	private AtomicLong value = new AtomicLong(0);
	
	@Override
	public void accumulator() {
		int i = index.getAndIncrement();
		value.getAndAdd(preLoad[i]);
		if(++i>=SIZE)
			index.set(0);
	}
	
	@Override
	public long read() {
		return value.get();
	}
	
}
public class SynchronizationComparisons {

	static BaseLine baseLine = new BaseLine();
	static SynchronizedTest synchronizedTest = new SynchronizedTest();
	static LockingTest lockingTest = new LockingTest();
	static AtomicTest atomicTest = new AtomicTest();
	static void test(){
		System.out.println("=============================================");
		System.out.printf("%-13s : %-12d\n","Cycles",Accumulator.cycles);
		baseLine.timedTest();
		synchronizedTest.timedTest();
		lockingTest.timedTest();
		atomicTest.timedTest();
		Accumulator.reported(synchronizedTest, baseLine);
		Accumulator.reported(lockingTest, baseLine);
		Accumulator.reported(atomicTest, baseLine);
		Accumulator.reported(synchronizedTest, lockingTest);
		Accumulator.reported(synchronizedTest, atomicTest);
		Accumulator.reported(lockingTest, atomicTest);
	}
	
	
	public static void main(String[] args) {
		int iteration = 5;
		if(args.length>0)
			iteration = new Integer(args[0]);
		System.out.println("Warm Up");
		baseLine.timedTest();
		for(int i=0;i<iteration;i++){
			test();
			Accumulator.cycles *= 2;
		}
		Accumulator.exec.shutdownNow();	
		
		
	}
	
}
