/**  
 * @Title: CallableDemo.java 
 * @Package concurrency 
 * @Description: TODO 
 * @author Rock King 2014年11月19日 下午10:45:42
 * @version V1.0  
 */ 
package concurrency.section2;

import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/** 
 * @Description: TODO
 * @author Rock King 2014年11月19日 下午10:45:42 
 * @see ~!^ Keep bugs away and code with U!	 
 */

class TaskWithResult implements Callable<String>{

	private int id;
	public TaskWithResult(int id){
		this.id = id;
	}
	/* (非 Javadoc) 
	 * <p>Title: call</p> 
	 * <p>Description: </p> 
	 * @return
	 * @throws Exception 
	 * @see java.util.concurrent.Callable#call() 
	 */ 
	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "result of taskWithResult:"+id;
	}
	
	
}
public class CallableDemo {

	
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		ArrayList<Future<String>> results = new ArrayList<>();
		for(int i=0;i<10;i++){
			results.add(exec.submit(new TaskWithResult(i)));
		}
		for(Future<String> future:results){
			try {
				System.out.println(future.get());
			} catch (InterruptedException e) {
				e.printStackTrace();
				return;
			} catch (ExecutionException e) {
				e.printStackTrace();
				return;
			}finally{
				exec.shutdown();
			}
		}
	}
}
