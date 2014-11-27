/**  
 * @Title: FixedDining.java 
 * @Package concurrency.section6 
 * @Description: TODO 
 * @author Rock King 2014年11月28日 上午1:18:01
 * @version V1.0  
 */
package concurrency.section6;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Description: TODO
 * @author Rock King 2014年11月28日 上午1:18:01
 * @see ~!^ Keep bugs away and code with U!
 */

public class FixedDiningPhilosopher {

	public static void main(String[] args) throws Exception {
		int ponder = 5;
		if (args.length > 0)
			ponder = Integer.parseInt(args[0]);
		int size = 5;
		if (args.length > 1)
			size = Integer.parseInt(args[1]);
		ExecutorService exec = Executors.newCachedThreadPool();
		Chopstick[] sticks = new Chopstick[size];
		for (int i = 0; i < size; i++)
			sticks[i] = new Chopstick();
		for (int i = 0; i < size; i++) {
			if (i < size - 1)
				exec.execute(new Philosopher(sticks[i], sticks[(i + 1) % size],
						i, ponder));
			else
				exec.execute(new Philosopher(sticks[0], sticks[i], i, ponder));
		}
		if (args.length == 3 && args[2].equals("timeout"))
			TimeUnit.SECONDS.sleep(5);
		else {
			System.out.println("Press enter to quit");
			System.in.read();
		}
		exec.shutdownNow();

	}

}
