package concurrency.section9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReaderWriterList<T> {

	private ArrayList<T> lockList;
	private ReentrantReadWriteLock lock = new ReentrantReadWriteLock(true);
	
	public ReaderWriterList(int size,T initValue){
		lockList = new ArrayList<T>(Collections.nCopies(size, initValue));
	}
	
	public T set(int size,T val){
		Lock wLock = lock.writeLock();
		wLock.lock();
		try {
			return lockList.set(size, val);
		} finally {
			wLock.unlock();
		}
	}
	
	public T get(int size){
		Lock rLock = lock.readLock();
		rLock.lock();
		try {
			if(lock.getReadLockCount()>1)
				System.out.println("lock.getLock(): "+lock.getReadLockCount());
			return lockList.get(size);
		} finally {
			rLock.unlock();
		}
	}
	
	public static void main(String[] args) {
		new ReaderWriterListTest(50, 5);
	}
}

class ReaderWriterListTest {
	ExecutorService exec = Executors.newCachedThreadPool();
	private final int SIZE = 100;
	private static Random random = new Random(47);
	private ReaderWriterList<Integer> list = new ReaderWriterList<Integer>(SIZE, 0);
	private class Writer implements Runnable{

		public void run() {
			try {
				for(int i=0;i<20;i++){
					list.set(i, random.nextInt());
					TimeUnit.MILLISECONDS.sleep(100);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("exec.shutdownNow()");
			exec.shutdownNow();
		}
		
	}
	private class Reader implements Runnable{
		
		public void run() {
			try {
				while(!Thread.interrupted()){
					for(int i=0;i<SIZE;i++){
						System.out.println("index:"+i+" "+list.get(i));
						TimeUnit.MILLISECONDS.sleep(1);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("exec.shutdownNow()");
			exec.shutdownNow();
		}
	}
	
	public ReaderWriterListTest(int reader,int writer){
		for(int i=0;i<reader;i++)
			exec.execute(new Reader());
		for(int i=0;i<writer;i++)
			exec.execute(new Writer());
	}
	
}