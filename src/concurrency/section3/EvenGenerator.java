package concurrency.section3;

public class EvenGenerator extends IntGenerator {

	private int currentEven = 0;
	@Override
	public int next() {
		++currentEven;		//danger pointer here
		++currentEven;
		return currentEven;
	}
	
	public static void main(String[] args) {
		EvenChecker.test(new EvenGenerator());
	}

}
