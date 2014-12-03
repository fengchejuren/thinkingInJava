package concurrency.section9;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**乐观加锁：某些atomic类允许乐观加锁：对该对象并没有锁定，其它的线程也可以修改该对象。但是当你准备修改这个
 * 对象的时候，使用方法compareAndSet来判断该对象的旧值和新值是否相同。如果不一致，则操作失败
 * @author Administrator
 *
 */
public class FastSimulation {

	static final int N_ELEMENTS = 100000;
	static final int N_GENES = 30;
	static final int N_EVOLVERS = 50;
	static final AtomicInteger[][] GRID = new AtomicInteger[N_ELEMENTS][N_GENES];
	static Random random = new Random(47);
	static class Evolvers implements Runnable{

		public void run() {
			while(!Thread.interrupted()){
				int element = random.nextInt(N_ELEMENTS);
				for(int i=0;i<N_GENES;i++){
					int previous = element - 1;
					if(previous<0) previous= N_ELEMENTS - 1;
					int next = element + 1;
					if(next>=N_ELEMENTS) next = 0;
					int oldValue = GRID[element][i].get();
					int newValue = oldValue + GRID[previous][i].get()+GRID[next][i].get();
					newValue /=3;
					if(!GRID[element][i].compareAndSet(oldValue, newValue))
						System.out.println("oldValue changed from "+oldValue);
				}
			}
		}
		
	}

	public static void main(String[] args) throws InterruptedException {
		ExecutorService exec = Executors.newCachedThreadPool();
		for(int i=0;i<N_ELEMENTS;i++){
			for(int j=0;j<N_GENES;j++){
				GRID[i][j] = new AtomicInteger(random.nextInt(1000));
			}
		}
		for(int i=0;i<N_EVOLVERS;i++)
			exec.execute(new Evolvers());
		TimeUnit.SECONDS.sleep(10);
		exec.shutdownNow();
	}
}


