package concurrency.section3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class Pair{
	private int x,y;
	public Pair(int x,int y){
		this.x = x;
		this.y = y;
	}
	public Pair(){this(0, 0);}
	public int getX(){
		return x;
	}
	public int getY(){
		return y;
	}
	public void incrementX(){
		x++;
	}
	public void incrementY(){
		y++;
	}
	@Override
	public String toString() {
		return "X: "+x+" ,Y: "+y;
	}
	
	public class PairValuesNotEqualException extends RuntimeException{
		public PairValuesNotEqualException(){
			super("Pair values not equal:"+Pair.this);
		}
	}
	
	public void checkState(){
		if(x!=y)
			throw new PairValuesNotEqualException();
	}
}
abstract class PairManager{
	AtomicInteger checkCount = new AtomicInteger(0);
	protected Pair p = new Pair();
	private List<Pair> storage = Collections.synchronizedList(new ArrayList<Pair>());
	
	public synchronized Pair getPair(){
		return new Pair(p.getX(),p.getY());
	}
	
	protected void storage(Pair pair){
		storage.add(pair);
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
		}
	}
	
	public abstract void increment(); 
}

class PairManager1 extends PairManager{

	@Override
	public void increment() {
		p.incrementX();
		p.incrementY();
		storage(getPair());
	}
	
}

class PairManager2 extends PairManager{

	@Override
	public void increment() {
		Pair temPair;
		synchronized (this) {
			p.incrementX();
			p.incrementY();
			temPair = getPair();
		}
		storage(temPair);
	}
}

class PairManipulator implements Runnable{
	private PairManager pairManager;
	public PairManipulator(PairManager pairManager){
		this.pairManager = pairManager;
	}
	public void run() {
		while(true)
			pairManager.increment();
	}
	@Override
	public String toString() {
		return "Pair:"+pairManager.getPair()+" CheckCounter:"+pairManager.checkCount.get();
	}
}

class PairChecker implements Runnable{
	private PairManager pManager;
	public PairChecker(PairManager pManager){
		this.pManager = pManager;
	}
	public void run() {
		while(true){
			pManager.checkCount.incrementAndGet();
			pManager.getPair().checkState();
		}
	}
	
}
public class CriticalSection {

	static void testApproaches(PairManager pm1,PairManager pm2){
		ExecutorService exec = Executors.newCachedThreadPool();
		PairManipulator
			pManipulator1 = new PairManipulator(pm1),
			pManipulator2 = new PairManipulator(pm2);
		PairChecker 
			pChecker1 = new PairChecker(pm1),
			pChecker2 = new PairChecker(pm2);
		exec.execute(pManipulator1);
		exec.execute(pManipulator2);
		exec.execute(pChecker1);
		exec.execute(pChecker2);
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("pManipulator1:"+pManipulator1+"\npManipulator2"+pManipulator2);
		System.exit(0);
	}
	
	public static void main(String[] args) {
		PairManager 
			pm1 = new PairManager1(),
			pm2 = new PairManager2();
		testApproaches(pm1, pm2);
		
	}
	
	
}
