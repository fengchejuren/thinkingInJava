package concurrency.section10;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ActiveObjectDemo {

	private ExecutorService exec = Executors.newSingleThreadExecutor();
	private Random random = new Random(47);
	
	private void pause(int factor){
		try {
			TimeUnit.MILLISECONDS.sleep(100+factor);
		} catch (InterruptedException e) {
			System.out.println("sleep() interrupted!");
		}
	}
	
	public Future<Integer> caculateInt(final int x,final int y){
		return exec.submit(new Callable<Integer>() {

			public Integer call() throws Exception {
				System.out.print("pause x:"+x+" y: "+y);
				pause(500);
				return x+y;
			}
		});
	}
	
	public Future<Float> caculateFloat(final float x,final float y){
		return exec.submit(new Callable<Float>() {

			public Float call() throws Exception {
				System.out.println("starting x:"+x+" y:"+y);
				pause(2000);
				return x+y;
			}
		});
	}

	public void shutdown(){
		exec.shutdown();
	}
	
	public static void main(String[] args) {
		ActiveObjectDemo d1 = new ActiveObjectDemo();
		List<Future<?>> results = new CopyOnWriteArrayList<Future<?>>();
		for(float f=0.0f;f<1.0f;f+=0.2f){
			results.add(d1.caculateFloat(f, f));
		}
		for(int i=0;i<5;i++){
			results.add(d1.caculateInt(i, i));
		}
		System.out.println("all synch call made!");
		while(results.size()>0){
			for(Future<?> f:results){
				if(f.isDone()){
					try {
						System.out.println(f.get());
					} catch (Exception e) {
						e.printStackTrace();
					}
					results.remove(f);
				}
			}
		}
		d1.shutdown();
	}
}
