package concurrency.section3;

public class SynchronizedEvenGenerator extends IntGenerator {

	private int currentEven = 0;
	@Override
	public synchronized int next() {
		++currentEven;		//danger pointer here
		Thread.yield();
		++currentEven;
		return currentEven;
	}
	
	public static void main(String[] args) {
		EvenChecker.test(new SynchronizedEvenGenerator());
	}

}
